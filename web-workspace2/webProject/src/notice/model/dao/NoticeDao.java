package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class NoticeDao {

	public ArrayList<Notice> selectList(Connection conn, int start, int end) {
		
		PreparedStatement pst = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		ResultSet rset = null;
		String query = "select * from(select rownum as rnum, n.* from (select * from notice order by NOTICE_NO desc)n) where rnum between ? and ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, start);
			pst.setInt(2, end);
			
			rset = pst.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setFileName(rset.getString("filename"));
				n.setFilePath(rset.getString("filepath"));
				
				list.add(n);							
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}
				
				
		return list;
	}

	public int totalCount(Connection conn) {
		
		PreparedStatement pst = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) as cnt from notice";
		
		try {
			pst = conn.prepareStatement(query);
			
			rset = pst.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}
		
		return result;
	}


}
