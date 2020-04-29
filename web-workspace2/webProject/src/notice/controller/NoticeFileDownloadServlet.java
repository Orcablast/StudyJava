package notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet(name = "NoticeFileDownload", urlPatterns = { "/noticeFileDownload" })
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 변수저장
		String fileName = request.getParameter("fileName");
		String filePath = request.getParameter("filePath");
		
		// 3. 비지니시 로직
		
		// 3.1 경로 설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/notice/";
		
		// 3.2 파일과 서블릿 연결
		FileInputStream fis = new FileInputStream(saveDirectory+filePath);
		// 3.3 보조스트림 생성
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		// 3.4 파일을 내보내기 위한 스트림 생성
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		String resFileName = "";
		// 브루아저가 IE인지 확인
		boolean bool = request.getHeader("user-agent").indexOf("MSIE") != -1 || request.getHeader("user-agent").indexOf("Trident") != -1;
				
		if(bool) { // IE인 경우
			resFileName = URLEncoder.encode(fileName, "UTF-8");
			resFileName = resFileName.replaceAll("\\\\", "%20");
			
		} else { // 나머지 브라우저인 경우
			resFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
		// 파일 다운로드를 위한 HTTP Header 설정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;fileName="+resFileName);
		
		int read = -1;
		
		while((read = bis.read())!=-1) {
			bos.write(read);
		}
		
		bos.close();
		bis.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
