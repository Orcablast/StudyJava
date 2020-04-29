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

	public int insertNotice(Connection conn, Notice n) {
		
		PreparedStatement pst = null;
		int result = 0;
		String query = "insert into notice values(seq_notice.nextval,?,?,?,sysdate,?,?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, n.getNoticeTitle());
			pst.setString(2, n.getNoticeWriter());
			pst.setString(3, n.getNoticeContent());
			pst.setString(4, n.getFileName());
			pst.setString(5, n.getFilePath());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		
		return result;
	}

	public Notice selectOneNotice(Connection conn, int noticeNo) {
				
		PreparedStatement pst = null;
		ResultSet rset = null;		
		Notice n = null;
		String query = "select * from notice where notice_no = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, noticeNo);
			
			rset = pst.executeQuery();
			
			if(rset.next()) {
				n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setFileName(rset.getString("filename"));
				n.setFilePath(rset.getString("filepath"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);			
		}
		
		return n;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		
		int result = 0;
		PreparedStatement pst = null;
		String query = "delete from notice where notice_no = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, noticeNo);
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		return result;
	}

	public int updateNotice(Connection conn, Notice n) {

		int result = 0;
		PreparedStatement pst = null;
		String query = "update notice set notice_title=?, notice_content=?, filename = ?, filepath=? where notice_no = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, n.getNoticeTitle());
			pst.setString(2, n.getNoticeContent());
			pst.setString(3, n.getFileName());
			pst.setString(4, n.getFilePath());
			pst.setInt(5, n.getNoticeNo());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		return result;
	}


}
