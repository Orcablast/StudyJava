package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

/**
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet(name = "DeleteBoard", urlPatterns = { "/deleteBoard" })
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardServlet() {
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
		String[] delNo = request.getParameterValues("delNo");
		
		// 3.비지니스 로직
		int result = new BoardService().deleteBoard(delNo);
		
		if(result>0) {
			request.setAttribute("msg", "삭제가 완료되었습니다.");
		} else {
			request.setAttribute("msg", "게시글 삭제 실패");
		}
		request.setAttribute("loc","/boardList?reqPage=1");
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
