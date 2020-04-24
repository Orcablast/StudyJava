package kh.java.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.java.member.model.service.MemberService;
import kh.java.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		
		// 3. 비즈니스 로직 처리
		
		Member loginMember = new MemberService().selectOneMember(m);
		
		// 4. 결과 송출
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/msg.jsp");
		request.setAttribute("loc", "/");
		if(loginMember != null) {
			// 로그인 성공
			// 세션 객체 생성
			HttpSession session = request.getSession();
			session.setAttribute("member", loginMember);
			request.setAttribute("msg", "로그인 성공");
		} else {
			// 로그인 실패
			request.setAttribute("msg", "아이디 또는 패스워드를 확인하세요");
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
