package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(Connection conn, String memberId, String memberPw) {

		PreparedStatement pst = null;
		ResultSet rset = null;
		String query = "select * from member where member_id = ? and member_pw =?";
		Member m = null;

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, memberId);
			pst.setString(2, memberPw);

			rset = pst.executeQuery();

			if (rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}

		return m;
	}

	public int insertMember(Connection conn, Member m) {

		int result = 0;
		PreparedStatement pst = null;
		String query = "insert into member values(?,?,?,?,?,?,?,sysdate)";

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, m.getMemberId());
			pst.setString(2, m.getMemberPw());
			pst.setString(3, m.getMemberName());
			pst.setInt(4, m.getAge());
			pst.setString(5, m.getEmail());
			pst.setString(6, m.getPhone());
			pst.setString(7, m.getAddress());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

	public Member selectOneMember(Connection conn, String memberId) {

		Member m = null;
		PreparedStatement pst = null;
		ResultSet rset = null;
		String query = "select * from member where member_id = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, memberId);
			
			rset = pst.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));				
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}		
		
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pst = null;
		String query = "update member set member_pw = ?, member_name = ?, age= ?, email = ?, phone = ?, address = ? where member_id = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, m.getMemberPw());
			pst.setString(2, m.getMemberName());
			pst.setInt(3, m.getAge());
			pst.setString(4, m.getEmail());
			pst.setString(5, m.getPhone());
			pst.setString(6, m.getAddress());
			pst.setString(7, m.getMemberId());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		
		return result;
	}

	public int deleteMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pst = null;
		String query = "delete from member where member_id = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, m.getMemberId());
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		
		return result;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pst = null;
		ResultSet rset = null;
		String query = "select * from member";
		
		try {
			pst = conn.prepareStatement(query);
			
			rset = pst.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		return list;
	}

	public int deleteMember(Connection conn, String memberId) {
		
		PreparedStatement pst = null;
		int result = 0;
		String query = "delete from member where member_id = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, memberId);
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		
		return result;
	}

}
