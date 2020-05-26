package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Check;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberInfoServlet
 */
@WebServlet(name = "MemberInfo", urlPatterns = { "/memberInfo" })
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoServlet() {
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
		String ckNo = request.getParameter("ckNo");
		String ckId = request.getParameter("ckId");
		String ckName = request.getParameter("ckName");
		String ckAge = request.getParameter("ckAge");
		Check ck = new Check(ckNo, ckId, ckName, ckAge); 
		
		// 3. 비지니스 로직 처리
		
		ArrayList<Member> list = new MemberService().memberInfo(ck);
		
		// 4. 결과처리
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/memberInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
