package board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDao;
import board.model.vo.BoardData;
import common.SqlSessionTemplate;

public class BoardService {

	public BoardData selectList(int reqPage) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		// 페이지당 게시물 수
		int numPerPage = 10;
		
		// 전체 게시물 수 조회
		
		int totalCount = new BoardDao().totalCount(session);
		
		
		// 전체 페이지 수 조회
		
		int totalPage = 0;
		
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		} else {
			totalPage = totalCount/numPerPage+1;
		}
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
				
		List list = new BoardDao().selectList(session, map);
		
		session.close();
		
		// pageNavi 작성
		
		StringBuffer pageNavi = new StringBuffer();
		int pageNaviSize = 3;
		
		// pageNo 연산 -> 페이지 시작번호
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		// 이전 버튼 생성
		if(pageNo != 1) {
			pageNavi.append("<a href='/boardList?reqPage="+(pageNo-1)+"'>이전</a>");
		}
		
		BoardData bd = new BoardData();
		
		return bd;
	}

}
