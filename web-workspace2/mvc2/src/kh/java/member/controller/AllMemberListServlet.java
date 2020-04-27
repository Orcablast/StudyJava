package kh.java.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.java.member.model.service.MemberService;
import kh.java.member.model.vo.Member;

/**
 * Servlet implementation class AllMemberListServlet
 */
@WebServlet(name = "AllMemberList", urlPatterns = { "/allMemberList" })
public class AllMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 인코딩
		// 2. 변수저장
		// 3. 비지니스 로직
		ArrayList<Member> list = new MemberService().selectAllMember();
		// 4. 결과처리
		// 4.1 RequestDispatcher - Servlet이 jsp 페이지에 값을 전달해야 할때 
		// 4.2 sendRedirect - Servlet이 jsp 페이지에 전달할 값이 없을때
		
		// 경로 선정시
		// Servlet을 반드시 거쳐가야 하는지?
		// 1) DB작업이 있는 값을 넘겨주는 경우 WEB-INF폴더 내부
		// 2) DB작업이 없이 페이지 이동만 하는 경우 WEB_INF 외부
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/allMemberList.jsp");
		
		// jsp에 넘겨줄 데이터 등록
		
		request.setAttribute("list", list);
		
		// 페이지 이동
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
