package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeCommentUpdateServlet
 */
@WebServlet(name = "NoticeCommentUpdate", urlPatterns = { "/noticeCommentUpdate" })
public class NoticeCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩(필터처리)
		// 2. 변수 저장
		NoticeComment nc = new NoticeComment();
		nc.setNoticeCommentNo(Integer.parseInt(request.getParameter("noticeCommentNo")));
		nc.setNoticeCommentContent(request.getParameter("noticeCommentContent"));
		int noticeNo = Integer.parseInt(request.getParameter("noticeRef"));
		
		
		// 3. 비즈니스 로직
		
		int result = new NoticeService().updateNoticeComment(nc);
		
		// 4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/WEB-INF/views/noticeView?noticeNo="+noticeNo);
		if(result>0) {
			request.setAttribute("msg", "댓글 수정 성공");
		} else {
			request.setAttribute("msg", "댓글 수정 실패");
		}
		
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
