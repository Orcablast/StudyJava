package kh.java.test;

import java.sql.*;

import java.util.*;

public class JDBCTest {

	private Connection conn = null;

	private PreparedStatement pstmt = null;

	private ResultSet rs = null;

	private void close() {

		try {

			if (rs != null) {
				rs.close();
				rs = null;
			}

			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<HashMap<String, Object>> testSelect() {

		List<HashMap<String, Object>> memoList = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "oracleuser", "pwd1234");

			String sql = " select no, name, msg, writeday "	+ " from tbl_memo "					+ " order by no asc ";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			int count = 0;

			while (rs.next()) {

				count++;

				if (count == 1) {

					memoList = new ArrayList<HashMap<String, Object>>();

				}

				HashMap<String, Object> memo = new HashMap<String, Object>();

				

				memo.put("no", rs.getInt(1)); // 1번 수정

				memo.put("msg", rs.getString(3));
				
				memo.put("name", rs.getString(2));

				memo.put("writeday", rs.getDate(4));
				
				
				
				memoList.add(memo); // 2번 수정

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			close();

		}

		return memoList;

	}

}