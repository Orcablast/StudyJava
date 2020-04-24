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
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
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
		Member m = new Member();
		m.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		m.setMemberName(request.getParameter("memberName"));
		m.setFootsize(Integer.parseInt(request.getParameter("footSize")));
		
		// 3. 비즈니스 로직
		int result = new MemberService().updateMember(m);
		
		// 4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/msg.jsp");
		request.setAttribute("loc", "/mypage");
		
		if(result>0) {
			HttpSession session = request.getSession(false);
			session.setAttribute("member", m);
			request.setAttribute("msg", "회원 정보 수정 완료");
		} else {
			request.setAttribute("msg", "수정 실패!!");
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
