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
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet(name = "UpdateBoard", urlPatterns = { "/updateBoard" })
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2.변수저장
		Board b = new Board();
		b.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		b.setBoardTitle(request.getParameter("boardTitle"));
		b.setBoardContent(request.getParameter("boardContent"));
		
		// 3.비지니스 로직
		int result = new BoardService().updateBoard(b);
		
		if(result>0) {
			request.setAttribute("msg", "수정 완료");
			request.setAttribute("loc", "/boardView?boardNo="+b.getBoardNo());
		} else {
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("loc", "/boardUpdateFrm?boardNo="+b.getBoardNo());
		}
		
		request.getRequestDispatcher("/WEB-INF/views/msg.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
