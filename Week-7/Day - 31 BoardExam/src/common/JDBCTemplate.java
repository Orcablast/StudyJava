package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	public static Connection getConnectionDB() {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");

			conn.setAutoCommit(false);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void close(ResultSet rset) {

		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement pst) {
		
		try {
			
			if(pst!=null && !pst.isClosed()) {
				pst.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void commit(Connection conn) {
		try {
			
			if(conn!=null && !conn.isClosed()) {
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		
		try {
			if(conn!= null && !conn.isClosed()) {
				conn.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void commitOrRollback(Connection conn, int result) {
		
		try {
			if(conn!= null && !conn.isClosed()) {
				
				if(result > 0) {
					conn.commit();					
				} else {
					conn.rollback();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
