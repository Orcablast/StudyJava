package board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardData;
import common.SqlSessionTemplate;

public class BoardService {

	public BoardData selectList(int reqPage, String type, String keyword) {

		SqlSession session = SqlSessionTemplate.getSqlSession();
		// 페이지당 게시물 수
		int numPerPage = 10;

		// 전체 게시물 수 조회
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("type", type);
		map.put("keyword", keyword);

		int totalCount = new BoardDao().totalCount(session, map);

		// 전체 페이지 수 조회

		int totalPage = 0;

		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;

		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));

		List list = new BoardDao().selectList(session, map);

		session.close();

		// pageNavi 작성

		StringBuffer pageNavi = new StringBuffer();
		int pageNaviSize = 3;

		// pageNo 연산 -> 페이지 시작번호 -> 요청 페이지 기준으로 -1 요청페이지 +1
		int pageNo = 1;

		if (reqPage != 1) {
			pageNo = reqPage - 1;
		}

		// 이전 버튼 생성
		if (pageNo != 1) {
			pageNavi.append("<a href='/boardList?reqPage=" + (pageNo - 1));
			if (type != null) {
				pageNavi.append("&type=" + type + "&keyword=" + keyword);
			}
			pageNavi.append("'>이전</a>");
		}

		// 페이지 버튼
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a href='/boardList?reqPage=" + pageNo);
				if (type != null) {
					pageNavi.append("&type=" + type + "&keyword=" + keyword);
				}
				pageNavi.append("'>" + pageNo + "</a>");
			}
			pageNo++;

			if (pageNo > totalPage) {
				break;
			}
		}

		// 다음버튼
		if (pageNo <= totalPage) {
			pageNavi.append("<a href='boardList?reqPage=" + pageNo);
			if (type != null) {
				pageNavi.append("&type=" + type + "&keyword=" + keyword);
			}
			pageNavi.append("'>다음</a>");
		}

		BoardData bd = new BoardData();
		bd.setPageNavi(pageNavi.toString());
		bd.setList((ArrayList<Board>) list);

		return bd;
	}

	public int insertBoard(Board b) {

		SqlSession session = SqlSessionTemplate.getSqlSession();

		int result = new BoardDao().insertBoard(session, b);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public Board selectOneBoard(int boardNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();

		int result = new BoardDao().addCount(session,boardNo);
		
		Board b = new BoardDao().selectOneBoard(session, boardNo);
		
		
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();

		return b;
	}

	public int updateBoard(Board b) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		int result = new BoardDao().updateBoard(session,b);
		
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		return result;
	}

	public int deleteBoard(String[] delNo) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		int result = new BoardDao().deleteBoard(session, delNo);
		
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		return result;
	}

}
