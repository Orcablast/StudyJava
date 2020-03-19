package kh.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.java.member.vo.Member;

public class MemberDao {

	PreparedStatement pst = null;
	ResultSet rset = null;

//	public void commitOrRollback(int result) throws SQLException {
//
//		if (result > 0) {
//			conn.commit();
//		} else {
//			conn.rollback();
//		}
//	}

	public int insertMbr(Member m, Connection conn) {

		int result = 0;

		String query = "insert into member values (?,?,?,?,?,?,?,sysdate)";

		try {

			pst = conn.prepareStatement(query);

			pst.setString(1, m.getMemberId());
			pst.setString(2, m.getMemberPw());
			pst.setString(3, m.getMemberName());
			pst.setString(4, m.getGender());
			pst.setInt(5, m.getAge());
			pst.setString(6, m.getPhone());
			pst.setString(7, m.getHobby());

			result = pst.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

	public ArrayList<Member> getAllMbrs(Connection conn) {

		ArrayList<Member> mbrs = new ArrayList<Member>();

		String query = "select * from member";

		try {
			conn = JDBCTemplate.getConnection();

			pst = conn.prepareStatement(query);
			
			rset = pst.executeQuery();

			while (rset.next()) {

				mbrs.add(setMember());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}

		return mbrs;
	}

	public Member setMember() throws SQLException {

		Member m = new Member();

		m.setMemberId(rset.getString("member_id"));
		m.setMemberPw(rset.getString("member_pw"));
		m.setMemberName(rset.getString("member_name"));
		m.setGender(rset.getString("gender").equals("M") ?  "남자" : "여자");
		m.setAge(rset.getInt("age"));
		m.setPhone(rset.getString("phone"));
		m.setHobby(rset.getString("hobby"));
		m.setEnrollDate(rset.getDate("enroll_date"));

		return m;
	}

	public ArrayList<Member> getMbr(String keyWord, String key,Connection conn) {

		conn = JDBCTemplate.getConnection();
		Member m = null;

		String query = null;

		ArrayList<Member> mbrs = new ArrayList<Member>();

		if (keyWord.contains("ID")) {
			query = "select * from member where member_id = ?";

		} else if (keyWord.contains("명")) {
			query = "select * from member where member_name = ?";
		}

		try {

			pst = conn.prepareStatement(query);

			pst.setString(1, key);

			rset = pst.executeQuery();

			while (rset.next()) {
				m = setMember();
				mbrs.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}

		return mbrs;
	}

	public int modifyMbr(Member m, Connection conn) {

		conn = JDBCTemplate.getConnection();

		int result = 0;

		String query = "update member set member_pw = ?, member_name = ?, phone = ?, hobby = ? where member_id = ?";

		try {

			pst = conn.prepareStatement(query);

			pst.setString(1, m.getMemberPw());
			pst.setString(2, m.getMemberName());
			pst.setString(3, m.getPhone());
			pst.setString(4, m.getHobby());
			pst.setString(5, m.getMemberId());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

	public int deleteMbr(String key, Connection conn) {

		int result = 0;

		String query = "delete from member where member_id = ?";

		try {

			pst = conn.prepareStatement(query);
			pst.setString(1, key);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

	public int deleteMember(String memberId) {

		// 1. 드라이버 등록, 2. Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();

		String query = "delete from member where member_id = ?";

		int result = 0;

		PreparedStatement pst = null;

		try {

			// 3. Statement 객체 생성
			pst = conn.prepareStatement(query);

			// 위치홀더 값 지정
			pst.setString(1, memberId);

			// 4. 쿼리문 실행 및 결과 받기
			result = pst.executeUpdate();

			// 5. 결과 처리

			if (result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			JDBCTemplate.close(pst);

		}

		return result;
	}

	public int insertDelMbr(String key, Connection conn) {

		int result = 0;

		conn = JDBCTemplate.getConnection();

		String qeury = "insert into del_member values (del_seq.nextval, ?, sysdate)";

		try {
			pst = conn.prepareStatement(qeury);

			pst.setString(1, key);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

}
