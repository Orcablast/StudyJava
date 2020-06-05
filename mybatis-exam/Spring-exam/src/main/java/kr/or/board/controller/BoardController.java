package kr.or.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardPageData;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService service;
	
	@RequestMapping("/boardView.do")
	public String boardView(Board b, Model model) {
		
		Board selectedBoard = service.selectOneBoard(b.getBoardNo());
		
		model.addAttribute("board",selectedBoard);
		
		return "board/boardView";
	}
	
	@RequestMapping("/boardWrite.do")
	public String boardWrite(Board b, Model model) {
		
		int result = service.boardWrite(b);
		
		if(result >0) {
			model.addAttribute("msg","게시글 등록 완료");
			model.addAttribute("loc","/boardList.do?boardType=1&reqPage=1");
		} else {
			model.addAttribute("msg","게시글 등록 실패");
			model.addAttribute("loc","/boardWriteFrm.do");
		}
		return "common/msg";
	}
	
	@RequestMapping("/boardList.do")
	public String boardList(String boardType, String reqPage, Model model) {
		
		BoardPageData pd = service.boardList(Integer.parseInt(boardType), Integer.parseInt(reqPage));
		
		model.addAttribute("list",pd.getList());
		model.addAttribute("pageNavi",pd.getPageNavi());
		model.addAttribute("reqPage",Integer.parseInt(reqPage));
		model.addAttribute("boardType",boardType);
		
		return "board/board";
	}
	
	@RequestMapping("/boardWriteFrm.do")
	public String boardWriteFrm(String boardType, Model model) {
		model.addAttribute("boardType", boardType);
		return "board/boardWrite";
	}
	
}
