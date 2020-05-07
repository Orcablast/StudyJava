package photo.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import photo.model.dao.PhotoDao;
import photo.model.vo.Photo;

public class PhotoService {

	public int insertPhoto(Photo p) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new PhotoDao().insertPhoto(conn, p);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int totalCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int totalCount = new PhotoDao().totalCount(conn);
		
		JDBCTemplate.close(conn);
		
		return totalCount;
	}

	public ArrayList<Photo> morePhoto(int start) {
		Connection conn = JDBCTemplate.getConnection();
		
		int lengh = 5; // 한번에 더 가지고 올 사진의 수
		
		int end = start+lengh-1;
		
		ArrayList<Photo> list = new PhotoDao().morePhoto(conn, start, end);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
