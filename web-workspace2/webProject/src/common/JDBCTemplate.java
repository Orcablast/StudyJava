package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","KH_SERVER","1234");
			
			conn.setAutoCommit(false); // 오토커밋 방지 설정
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		
		try {
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			
			if(conn!=null && !conn.isClosed()) {
				conn.commit();
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		
		try {
			
			if(conn!=null && !conn.isClosed()) {
				conn.rollback();
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
}
