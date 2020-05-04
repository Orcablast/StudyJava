package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeCommentServlet
 */
@WebServlet(name = "NoticeComment", urlPatterns = { "/noticeComment" })
public class NoticeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 변수에 값 저장
		NoticeComment nc = new NoticeComment();
		
		nc.setNoticeCommentLevel(Integer.parseInt(request.getParameter("noticeCommentLevel")));
		nc.setNoticeCommentWriter(request.getParameter("noticeCommentWriter"));
		nc.setNoticeCommentContent(request.getParameter("noticeCommentContent"));
		nc.setNoticeRef(Integer.parseInt(request.getParameter("noticeRef")));
		nc.setNoticeCommentRef(Integer.parseInt(request.getParameter("noticeCommentRef")));		
		
		// 3. 비즈니스 로직
		
		int result = new NoticeService().noticeCommentInsert(nc);
		// 4. 결과 처리
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
