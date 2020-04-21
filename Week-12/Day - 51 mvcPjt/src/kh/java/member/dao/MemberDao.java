package kh.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.java.member.vo.Member;

public class MemberDao {

	public int insertMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		String query = "insert into member values(?,?,?,?,?,?,?,sysdate)";
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getHobby());		
			
			result = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		
		return result;
	}

	public ArrayList<Member> selectAll(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = "select * from member";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return list;
	}

	public Member searchMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setHobby(rset.getString("hobby"));
				m.setPhone(rset.getString("phone"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return m;
	}

	public int modifyMember(Connection conn, Member m) {
		
		int result = 0;
		
		PreparedStatement pst = null;
		String query = "update member set member_pw = ?, member_name = ?, hobby = ?, phone = ? where member_id = ?";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, m.getMemberPw());
			pst.setString(2, m.getMemberName());
			pst.setString(3, m.getHobby());
			pst.setString(4, m.getPhone());
			pst.setString(5, m.getMemberId());		
			
			result = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		
		return result;
	}

	public int deleteMember(Connection conn, Member m) {
		
		PreparedStatement pst = null;
		int result = 0;
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

	public int addDelMember(Connection conn, Member m) {
		
		PreparedStatement pst = null;
		
		int result = 0;
		String query = "insert into del_member values(del_seq.nextval,?,sysdate)";
		
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

}
