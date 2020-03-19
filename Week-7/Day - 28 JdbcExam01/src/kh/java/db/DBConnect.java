package kh.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnect {

	public int insertMbr(Member mbr) {

		Connection conn = null;
		Statement stmt = null;

		int result = 0;

		String query = "insert into member values('" + mbr.getMemberId() + "'," 
						+ "'" + mbr.getMemberPw()+ "',"
						+ "'" + mbr.getMemberName() + "'," 
						+ "'" + mbr.getGender() + "'," 
						+ mbr.getAge() + "," 
						+ "'" + mbr.getPhone() + "'," 
						+ "'" + mbr.getHobby() + "'," 
						+ "sysdate)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

			stmt = conn.createStatement();

			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
				System.out.println(result + "행이 입력되었습니다.");

			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		

	}

	public Member idSearch(String memberId) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		Member member = null;

		String query = "select * from member where member_id = '" + memberId + "'";

		try {
			// 1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

			// 3. Statement 객체 생성
			stmt = conn.createStatement();

			// 4. query문 전달 및 결과 수신

			rset = stmt.executeQuery(query);

			// 5. 결과 처리

			if (rset.next()) {

				member = new Member();

				String id = rset.getString("member_id");
				member.setMemberId(id);

				String pw = rset.getString("member_pw");
				member.setMemberPw(pw);

				String name = rset.getString("member_name");
				member.setMemberName(name);

				String gender = rset.getString("gender");
				member.setGender(gender);

				int age = rset.getInt("age");
				member.setAge(age);

				String phone = rset.getString("phone");
				member.setPhone(phone);

				member.setHobby(rset.getString("hobby"));

				member.setEnrollDate(rset.getDate("enroll_date"));

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return member;
	}

	public ArrayList<Member> nameSearch(String memberName) {

		ArrayList<Member> arr = new ArrayList<Member>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Member member = null;

		String query = "select * from member where member_name like '%" + memberName + "%'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {
				member = new Member();

				member.setMemberId(rset.getString("member_id"));

				member.setMemberPw(rset.getString("member_pw"));

				member.setMemberName(rset.getString("member_name"));

				member.setGender(rset.getString("gender"));

				member.setAge(rset.getInt("age"));

				member.setPhone(rset.getString("phone"));

				member.setHobby(rset.getString("hobby"));

				member.setEnrollDate(rset.getDate("enroll_date"));

				arr.add(member);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arr;

	}

	public ArrayList<Member> searchAll() {

		ArrayList<Member> mbrs = new ArrayList<Member>();

		Member mbr = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from member";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {

				mbr = new Member();

				mbr.setMemberId(rset.getString("member_id"));

				mbr.setMemberPw(rset.getString("member_pw"));

				mbr.setMemberName(rset.getString("member_name"));

				mbr.setGender(rset.getString("gender"));

				mbr.setAge(rset.getInt("age"));

				mbr.setPhone(rset.getString("phone"));

				mbr.setHobby(rset.getString("hobby"));

				mbr.setEnrollDate(rset.getDate("enroll_date"));

				mbrs.add(mbr);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rset.close();
				conn.close();
				stmt.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return mbrs;
	}

	
	public int modifyMbr(Member mbr) {
		
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
		
		String query = "update member set "
				+"member_pw = '"+mbr.getMemberPw()+"',"
				+"phone = '"+mbr.getPhone()+"',"
				+"hobby = '"+mbr.getHobby()+"'"
				+"where member_id = '"
				+mbr.getMemberId()+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
			if(result > 0) {
				conn.commit();			
				
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int deleteMbr(String memberId) {
		
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
		
		String query = "delete from member where member_id = '"+memberId+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(query);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
}
