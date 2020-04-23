package kh.java.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.java.member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(Connection conn, Member login) {
		
		Member m = null;
		
		PreparedStatement pst = null;
		ResultSet rset = null;
		String query = "select * from member where member_id = ? and member_pw = ?";		
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, login.getMemberId());
			pst.setString(2, login.getMemberPw());
			
			rset = pst.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setFootsize(rset.getInt("foot_size"));
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
		String query = "insert into member values(mem_seq.nextval,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, m.getMemberId());
			pst.setString(2, m.getMemberPw());
			pst.setString(3, m.getMemberName());
			pst.setInt(4, m.getFootsize());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}		
		
		return result;
	}

	public int removeMember(Connection conn, String memberId) {
		
		int result = 0;
		PreparedStatement pst = null;
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

	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pst = null;
		String query = "update member set member_id = ?, member_pw = ?, member_name=?, foot_size=? where member_no = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, m.getMemberId());
			pst.setString(2, m.getMemberPw());
			pst.setString(3, m.getMemberName());
			pst.setInt(4, m.getFootsize());
			pst.setInt(5, m.getMemberNo());
			
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
				
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setFootsize(rset.getInt("foot_size"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}		
		
		return list;
	}



}
