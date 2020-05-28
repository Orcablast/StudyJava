package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class MultiUploadServlet
 */
@WebServlet(name = "MultiUpload", urlPatterns = { "/multiUpload" })
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 1.메모리나 파일로 업로드 파일을 보관하는 FileItem의 Factory 설정
		DiskFileItemFactory diskFactory = new DiskFileItemFactory();
		
		// 업로드시 사용할 임시메모리 크기 설정(단위는 byte, 기본값 10240(10kb))
		diskFactory.setSizeThreshold(4096);
		
		// 임시저장폴더 지정
		diskFactory.setRepository(new File(getServletContext().getRealPath("/")+"upload/test2"));
		
		// 2. 업로드 요청을 처리하는 ServletFileUpload객체 생성
		ServletFileUpload upload = new ServletFileUpload(diskFactory);
		
		upload.setSizeMax(3*1024*1024);
		//setSizeMax -> 전체 파일 업로드 최대크기
		//setFileSize -> 개별 파일 업로드 최대크기
		
		// 3. ServletFileUpload 객체를 이용해서 request에서 보낸 파라미터값 처리
		// 모든 파라미터가 FileItem객체 형태로 저장되고 List로 묶어서 가져옴
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator item = items.iterator();
			ArrayList<String> params = new ArrayList<String>();
			
			while(item.hasNext()) {
				FileItem fi = (FileItem)item.next();
				
				if(fi.isFormField()) { //isFormField()에서 true가 리턴되면 일반 파라미터
					String descript = fi.getString("UTF-8");
					params.add(descript);
					
				} else { // 파일인 경우
					String fileOriginName = fi.getName(); // 파일명 변수에 저장 (기존 filepath 개념)
					String files = fi.getFieldName();  // 기존 filename개념
					
					// 중복파일명 처리 코드
					// ex) aaa.txt -> aaa_1 . txt
					String fileNameFront = fileOriginName.substring(0,fileOriginName.lastIndexOf('.'));
					String fileNameExetension = fileOriginName.substring(fileOriginName.lastIndexOf('.'));
					
					File uploadFile = null;
					StringBuilder fileName = new StringBuilder();
					
					int num=0; // 중복이름이 있는경우 붙여줄 숫자변수
					while(true) {
						fileName.setLength(0); // fileName 초기화
						
						fileName.append(fileNameFront);
						if(num != 0) {
							fileName.append("_"+num);
						}
						fileName.append(fileNameExetension);
						
						uploadFile = new File(getServletContext().getRealPath("/")+"upload/test/"+fileName.toString());
						
						if(!uploadFile.exists()) { // 현재 파일명과 일치하는 파일이 존재하지 않으면 파일 업로드 수행
							params.add(fileName.toString());
							
							try {
								fi.write(uploadFile);
								break;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						num++;
					}
				}
			}
			
			for(String str : params) {
				System.out.println(str);
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
