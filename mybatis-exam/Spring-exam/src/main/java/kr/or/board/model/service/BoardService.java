package kr.or.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardPageData;

@Service("boardService")
public class BoardService {

	@Autowired
	@Qualifier("boardDao")
	private BoardDao dao;

	public BoardPageData boardList(int boardType, int reqPage) {
		
		int totalCount = dao.totalCount(boardType);

		int numPerPage = 20;

		int totalPage = 0;

		if (totalCount % numPerPage != 0) {
			totalPage = totalCount / numPerPage + 1;
		} else {
			totalPage = totalCount / numPerPage;
		}

		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardType", boardType);
		map.put("start", start);
		map.put("end", end);

		List list = dao.selectBoardList(map);

		StringBuffer pageNavi = new StringBuffer();

		int pageSize = 10;
		int pageNo = ((reqPage - 1) / pageSize) * pageSize + 1;

		if (pageNo != 1) {
			pageNavi.append("<a class='btn btn-primary' href='/boardList.do?boardType=" + boardType + "&reqPage="
					+ (pageNo-1) + "'>이전</a>");
		}

		for (int i = 0; i < pageSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='btn btn-primary'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn btn-primary' href='/boardList.do?boardType=" + boardType + "&reqPage="
						+ pageNo + "'>" + pageNo + "</a>");
			}

			pageNo++;

			if (pageNo > totalPage) {
				break;
			}
		}
		
		if(pageNo <= totalPage) {
			pageNavi.append("<a class='btn btn-primary' href='/boardList.do?boardType=" + boardType + "&reqPage="
					+ pageNo + "'>다음</a>");
		}
		
		return new BoardPageData((ArrayList<Board>)list, pageNavi.toString());
	}

	public int boardWrite(Board b) {
		return dao.boardWrite(b);
	}

	@Transactional
	public Board selectOneBoard(int boardNo) {
		
		Board b = dao.selectOneBoard(boardNo);
		
		int result = dao.updateReadCount(boardNo);
		
		return b;
	}

}
