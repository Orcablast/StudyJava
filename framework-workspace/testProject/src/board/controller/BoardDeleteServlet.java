package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet(name = "BoardDelete", urlPatterns = { "/boardDelete" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
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
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String[] delNo = new String[1];
		delNo[0] = request.getParameter("boardNo");
		// 3. 비지니스 로직
		int result = new BoardService().deleteBoard(delNo);
		
		// 4. 결과처리
		
		if(result>0) {
			request.setAttribute("msg", "게시물이 삭제되었습니다.");
			request.setAttribute("loc", "/boardList?reqPage=1");
		} else {
			request.setAttribute("msg", "게시물 삭제에 실패하였습니다.");
			request.setAttribute("loc", "/boardView?boardNo="+boardNo);
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
