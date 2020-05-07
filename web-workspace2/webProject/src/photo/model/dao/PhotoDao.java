package photo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import photo.model.vo.Photo;

public class PhotoDao {

	public int insertPhoto(Connection conn, Photo p) {

		PreparedStatement pst = null;
		int result = 0;
		String query = "insert into photo values(seq_photo.nextval,?,?,?,?,sysdate,0)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPhotoWriter());
			pst.setString(2, p.getPhotoContent());
			pst.setString(3, p.getPhotoFilename());
			pst.setString(4, p.getPhotoFilepath());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}		
		
		return result;
	}

	public int totalCount(Connection conn) {
		
		int totalCount = 0;
		PreparedStatement pst = null;
		ResultSet rset = null;
		String query = "select count(*) cnt from photo";
		
		try {
			pst = conn.prepareStatement(query);

			rset = pst.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}
		
		
		return totalCount;
	}

	public ArrayList<Photo> morePhoto(Connection conn, int start, int end) {
		
		ArrayList<Photo> list = new ArrayList<Photo>();
		PreparedStatement pst = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, p.* from(select * from photo order by photo_no desc) p) where rnum between ? and ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, start);
			pst.setInt(2, end);
			
			rset = pst.executeQuery();
			
			while(rset.next()) {
				Photo p = new Photo();
				p.setPhotoNo(rset.getInt("photo_no"));
				p.setPhotoContent(rset.getString("photo_content"));
				p.setPhotoDate(rset.getDate("photo_date"));
				p.setPhotoFilename(rset.getString("photo_filename"));
				p.setPhotoFilepath(rset.getString("photo_filepath"));
				p.setPhotoReadcount(rset.getInt("photo_readcount"));
				p.setPhotoWriter(rset.getString("photo_writer"));
				
				list.add(p);
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

}
