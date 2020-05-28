package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet(name = "BoardWrite", urlPatterns = { "/boardWrite" })
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 변수값 저장
		Board b = new Board();
		
		b.setBoardTitle(request.getParameter("boardTitle"));
		b.setBoardWriter(request.getParameter("boardWriter"));
		b.setBoardContent(request.getParameter("boardContent"));	
		
		// 3. 비지니스 로직
		int result = new BoardService().insertBoard(b);
		
		// 4. 결과처리
		if(result>0) {
			request.setAttribute("msg", "작성 완료");
			request.setAttribute("loc", "/boardList?reqPage=1");
		} else {
			request.setAttribute("msg", "작성실패");
			request.setAttribute("loc", "/boardWriteFrm");
		}
		request.getRequestDispatcher("/WEB-INF/views/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
