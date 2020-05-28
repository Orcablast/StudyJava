package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

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
		request.setCharacterEncoding("utf-8");
		
		// 2. 변수값 저장
		Member m = new Member();
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		
		System.out.println(m.getMemberId());
		System.out.println(m.getMemberPw());
		
		// 3.비지니스 로직
		
		Member member = new MemberService().selectOneMember(m);
		
		if(member == null) { // 로그인 실패시
			
			System.out.println("로그인 실패");
			request.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
			request.setAttribute("loc", "/");
		} else if(member.getMemberLevel()==0) {
			request.setAttribute("msg", "가입 승인 대기중입니다. 관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
		} else if(member.getDisable()==1) {
			request.setAttribute("msg", "이용이 중지된 회원입니다.");
			request.setAttribute("loc", "/");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			request.setAttribute("msg", "로그인 성공!");
			request.setAttribute("loc","/main");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
