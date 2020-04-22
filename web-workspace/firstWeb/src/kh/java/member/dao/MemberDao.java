package kh.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


}
