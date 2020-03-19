package kh.java.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DBConnect {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rset = null;
	
	

	public void getConnectDB() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

	}

	public void clearConnect() {
		if(conn!=null) {
			conn = null;			
		} else if (pst!=null) {
			pst = null;			
		} else if (rset!=null) {
			rset = null;			
		}
	}

	public void setResult() {

	}

	public Member searchById(String mbrValue) {

		String query = "select * from member where member_id = ?";

		Member m = null;

		try {

			getConnectDB();

			pst = conn.prepareStatement(query);

			pst.setString(1, mbrValue);

			rset = pst.executeQuery();

			if (rset.next()) {

				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String phone = rset.getString("phone");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");

				m = new Member(memberId, memberPw, memberName, gender, age, phone, hobby, enrollDate);

			}

		} catch (ClassNotFoundException | SQLException e) {
			try {
				conn.close();
				pst.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		clearConnect();

		return m;
	}

	public int modifyMbr(Member m) {

		int result = 0;

		Connection conn = null;

		PreparedStatement pstmt = null;

		String query = "update member set member_pw = ?, phone = ?, hobby = ? where member_id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

			pstmt = conn.prepareStatement(query);

			// 위치 홀더에 값을 대입하여 쿼리문 완성

			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getHobby());
			pstmt.setString(4, m.getMemberId());

			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();

			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return result;
	}

	public void closeResources() {
		try {
			if(rset!=null) {
				rset.close();
			} else if (pst != null) {
				pst.close();
			} else if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public ArrayList<Member> searchByName(String memberName) {

		ArrayList<Member> mbrs = new ArrayList<Member>();
		
		String query = "select * from member where member_name like ?";
		
		memberName = "%"+memberName+"%";
		
		try {
			getConnectDB();
			
			pst = conn.prepareStatement(query);
			
			pst.setString(1, memberName);
			
			rset = pst.executeQuery();
			
			while(rset.next()) {
				mbrs.add(setMember());
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {			
			closeResources();
		}

		clearConnect();		
		return mbrs;
	}

	public ArrayList<Member> getAllMbr() {
		
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
			closeResources();
		}
		
		
		clearConnect();
		return mbrs;
	}

	public int insertMbr(Member m) {

		int result = 0;
		
		String query = "insert into member values(?,?,?,?,?,?,?,sysdate)";
		
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
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();			
		} finally {
			closeResources();
		}
		
		clearConnect();
		return result;
	}

	public int deleteMbr(String memberId) {
		
		int result= 0;
		
		String query = "delete from member where member_id = ?";
		
		try {
			getConnectDB();
			
			pst = conn.prepareStatement(query);
			
			pst.setString(1, memberId);
			
			result = pst.executeUpdate();
			
			if(result > 0 ) {
				conn.commit();
			} else {
				conn.rollback();
			}
					
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		
		clearConnect();
		
		return result;
	}
	
	public int countVals(String query) {
		
		int result = 0;
		
		StringTokenizer sT = new StringTokenizer(query, "?");
		
		result = sT.countTokens();
		
		
		return result;
	}
	
	public void switchQuery(String query) {
		if(query.contains("update")) {
			
		} else if (query.contains("insert")) {
		
		} else if(query.contains("select")) {
		
		} else if(query.contains("delete")) {
			
		}
	}

	// public int updateMbr(Member mbr, String query) {
	//
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	//
	// int result = 0;
	//
	// try {
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	//
	// conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
	// "jdbc", "1234");
	//
	// pstmt = conn.prepareStatement(query);
	//
	// // int valueNum = query.
	//
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
	//

}
