package kh.java.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.java.member.vo.Member;

public class MemberDao {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rset = null;

	public void getConnectDB() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

	}

	public void closeConnectDB() {
		try {
			if(rset!=null) {
				rset.close();
				rset = null;
			} else if(pst!=null) {
				pst.close();
				pst = null;
			}			
			conn.close();
			conn = null;
		} catch (SQLException e) {
		}
		
	}

	public void commitOrRollback(int result) throws SQLException {
		
		if(result > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}
		
	}
	
	public int insertMbr(Member m) {

		int result = 0;

		String query = "insert into member values (?,?,?,?,?,?,?,sysdate)";

		try {
			getConnectDB();
			
			pst = conn.prepareStatement(query);
			
			pst.setString(1, m.getMemberId());
			pst.setString(2, m.getMemberPw());
			pst.setString(3, m.getMemberName());
			pst.setString(4, m.getGender());
			pst.setInt(5, m.getAge());
			pst.setString(6, m.getPhone());
			pst.setString(7, m.getHobby());
			
			result = pst.executeUpdate();
			
			if(pst==null) {
				System.out.println("커밋전 pst는 null");
			} else if (conn == null) {
				System.out.println("커밋전 conn는 null");
			} else if (rset == null) {
				System.out.println("커밋전 rset은 null");
			}
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnectDB();
		}
		
		if(pst==null) {
			System.out.println("커밋후 pst는 null");
		} else if (conn == null) {
			System.out.println("커밋후 conn는 null");
		} else if (rset == null) {
			System.out.println("커밋후 rset은 null");
		}

		return result;
	}

	public ArrayList<Member> getAllMbrs() {
		
		ArrayList<Member> mbrs = new ArrayList<Member>();
		
		String query = "select * from member";
		
		try {
			getConnectDB();
			
			pst = conn.prepareStatement(query);
			rset = pst.executeQuery();
			
			while(rset.next()) {
				
				mbrs.add(setMember());
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnectDB();
		}
		
		
		return mbrs;
	}
		
	public Member setMember() throws SQLException {

		Member m = new Member();
		
		m.setMemberId(rset.getString("member_id"));
		m.setMemberPw(rset.getString("member_pw"));
		m.setMemberName(rset.getString("member_name"));
		m.setGender(rset.getString("gender"));
		m.setAge(rset.getInt("age"));
		m.setPhone(rset.getString("phone"));
		m.setHobby(rset.getString("hobby"));
		m.setEnrollDate(rset.getDate("enroll_date"));
		
		
		return m;
	}

	
	public ArrayList<Member> getMbr(String keyWord,String key) {

		Member m = null;
		
		String query = null;
		
		ArrayList<Member> mbrs = new ArrayList<Member>();
		
		if(keyWord.contains("ID")) {
			query = "select * from member where member_id = ?";
			
		} else if (keyWord.contains("명")) {
			query = "select * from member where member_name = ?";
		}
				
		try {
			getConnectDB();
			
			pst = conn.prepareStatement(query);
			
			pst.setString(1, key);
			
			rset = pst.executeQuery();
			
			while(rset.next()) {
				m = setMember();
				mbrs.add(m);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnectDB();
		}		
		
		return mbrs;
	}

	public int deleteMbr(String key) {
		
		int result = 0;
		
		String query = "delete from member where member_id = ?";
		
		try {
			getConnectDB();
			
			pst = conn.prepareStatement(query);
			pst.setString(1, key);
			
			result = pst.executeUpdate();
			
			commitOrRollback(result);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnectDB();
		}
		
		return result;
	}

	public int modifyMbr(Member m) {
		
		int result = 0;
		
		String query = "update member set member_pw = ?, member_name = ?, phone = ?, hobby = ? where member_id = ?";
		
		try {
			getConnectDB();
			
			pst = conn.prepareStatement(query);
			
			pst.setString(1, m.getMemberPw());
			pst.setString(2, m.getMemberName());
			pst.setString(3, m.getPhone());
			pst.setString(4, m.getHobby());
			pst.setString(5, m.getMemberId());
			
			result = pst.executeUpdate();
			
			commitOrRollback(result);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnectDB();
		}
		
		return result;
	}
	
}
