package notice.controller;

import java.io.File;
import java.io.IOException;
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
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet(name = "UpdateNotice", urlPatterns = { "/updateNotice" })
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// multiPart 체크
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "[enctype]확인");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/veiws/common/msg.jsp").forward(request, response);
			return;
		}
		
		// 파일저장 준비
		
		// 1) 업로드 경로
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/notice";
		
		// 2) 파일크기 지정
		int maxSize = 10*1024*1024;
		
		// 2. 변수저장
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		Notice n = new Notice();
		
		n.setNoticeNo(Integer.parseInt(mRequest.getParameter("noticeNo")));
		n.setNoticeTitle(mRequest.getParameter("noticeTitle"));
		n.setNoticeContent(mRequest.getParameter("noticeContent"));
		n.setFileName(mRequest.getOriginalFileName("fileName"));
		n.setFilePath(mRequest.getFilesystemName("fileName"));
		
		String status = mRequest.getParameter("status");
		String oldFilePath = mRequest.getParameter("oldFilePath");
		String oldFileName = mRequest.getParameter("oldFileName");
		
		// 기존 파일값을 유지하기 위한 로직
		if(n.getFileName() == null) { // 새로 입력된 파일이 없을때
			if(status.equals("stay")) { // status가 stay라면
				n.setFileName(oldFileName); // 기존 파일명을 n에 셋 (기존에 null이었다면 null)
				n.setFilePath(oldFilePath); // 기존 파일경로를 n에 셋 (기존에 null이었다면 null)
			}
		}
		
		// 3. 비즈니스 로직
		
		int result = new NoticeService().updateNotice(n);
		
		// 4. 결과처리
		if(result>0) {
			if(status.equals("delete")) { // 새로 입력된 파일이 있는데, 기존에도 파일이 있었을 경우 (상단 if문 skip됨)
				File delFile = new File(saveDirectory+"/"+oldFilePath);
				delFile.delete();
			}
			request.setAttribute("msg", "수정 성공!");
			
		} else {
			request.setAttribute("msg", "수정 실패!");
		}
		
		request.setAttribute("loc", "/noticeView?noticeNo="+n.getNoticeNo());
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
