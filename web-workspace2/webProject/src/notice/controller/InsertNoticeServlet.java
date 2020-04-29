package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet(name = "InsertNotice", urlPatterns = { "/insertNotice" })
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 변수 저장
		// enctype=multipart/form-data 인지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 타입오류[enctype]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		// 파일업로드 준비
		// 1) 파일 업로드 경로지정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/notice";
		
		// 2) 업로드 파일 크기 지정
		int maxSize = 10*1024*1024;
		
		// request -> MultipartRequest
		// 파일 업로드 시점
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Notice n = new Notice();
		n.setNoticeTitle(mRequest.getParameter("noticeTitle"));
		n.setNoticeWriter(mRequest.getParameter("noticeWriter"));
		n.setNoticeContent(mRequest.getParameter("noticeContent"));
		n.setFileName(mRequest.getOriginalFileName("fileName"));
		n.setFilePath(mRequest.getFilesystemName("fileName"));
		
		
		// 3. 비지니스 로직
		
		int result = new NoticeService().insertNotice(n);
		
		// 4. 결과처리		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/noticeList?reqPage=1");
		if(result >0) {
			request.setAttribute("msg", "게시글이 작성되었습니다.");
		} else {
			request.setAttribute("msg", "게시글 작성에 실패하였습니다.");
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
