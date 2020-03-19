package kh.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest {
	
	Scanner sc = new Scanner(System.in);

	public void main() {

		try {
			// 1. 드라이버 등록

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");

			String query = "select * from employee";

			// 3. Statement 객체 생성
			Statement stmt = conn.createStatement();

			// 4. 쿼리문 요청 후 결과 받기
			ResultSet rset = stmt.executeQuery(query);

			// 5. 결과 처리

			int i = 1;

			String name, phone;
			int salary;

			while (rset.next()) {
				name = rset.getString(2); // column index로 선택
				salary = rset.getInt("salary"); // column name으로 선택
				phone = rset.getString("phone");
				System.out.println((i++) + ". 사원명 : " + name + "\t급여 : " + salary + "\t연락처 : " + phone);
			}

			// 6. 자원 반환 (생성 역순)

			rset.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void exam01() { // query문 as 별칭

		try {
			// 1. 드라이버 등록

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성

			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");

			String query = "select emp_name as name from employee";

			// 3. Statement 객체 생성
			Statement stmt = conn.createStatement();

			// 4. 쿼리문 요청 후 결과 받기
			ResultSet rset = stmt.executeQuery(query);

			// 5. 결과 처리

			int i = 1;

			String name;

			while (rset.next()) {
				name = rset.getString("name");
				System.out.println((i++)+". " + name);
			}

			// 6. 자원 반환 (생성 역순)

			rset.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmp() {
		
		Connection conn = null;
		Statement stmt = null;
		
		System.out.print("해고 할 직원의 이름 : ");
		String dName = sc.next();
		
		String query = "delete from employee where emp_name = '"+dName+"'";
		
		try {
			// 1. 드라이버 등록
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. connection 객체 생성
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
			
			// 3. Statement 객체 생성 by connection
			
			stmt = conn.createStatement();
			
			// 4. 쿼리 전송 및 결과 받기
			
			int result = stmt.executeUpdate(query);
						
			// 5. 결과 처리
			
			if(result > 0) {
				conn.commit();
				System.out.println(result+"개의 행이 삭제 되었습니다.");
				
			} else {
				conn.rollback();
				System.out.println("작업이 수행되지 않았습니다.");
			}		
			
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			// 6. 자원 반환			
			try {
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
