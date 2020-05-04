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
 * Servlet implementation class NoticeCommentServlet
 */
@WebServlet(name = "NoticeCommentInsert", urlPatterns = { "/noticeCommentInsert" })
public class NoticeCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentInsertServlet() {
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
		System.out.println(nc.getNoticeCommentWriter());
		
		// 3. 비즈니스 로직
		
		int result = new NoticeService().noticeCommentInsert(nc);
		
		// 4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("msg", "댓글 등록 성공");
		} else {
			request.setAttribute("msg", "댓글 등록 실패");
		}
		
		request.setAttribute("loc", "/noticeView?noticeNo="+nc.getNoticeRef());
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
