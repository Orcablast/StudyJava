package kr.or.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;

@Repository("boardDao")
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate session;

	public int totalCount(int boardType) {
		return session.selectOne("board.totalCount",boardType);
	}

	public List selectBoardList(HashMap<String, Integer> map) {
		return session.selectList("board.selectBoardList", map);
	}

	public int boardWrite(Board b) {
		return session.insert("board.boardWrite", b);
	}

	public Board selectOneBoard(int boardNo) {
		return session.selectOne("board.selectOneBoard",boardNo);
	}

	public int updateReadCount(int boardNo) {
		return session.update("board.updateReadCount", boardNo);
	}


}
