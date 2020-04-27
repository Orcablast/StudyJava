package kh.java.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.java.member.model.vo.Member;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "Test", urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestServlet 호출");
		// Member m은 DB작업을 통해 얻은 결과물
		Member m = new Member();
		m.setMemberId("test");
		m.setMemberName("test");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/test.jsp");
		request.setAttribute("test", m);
		rd.forward(request, response);
		// a 태그로 이동하는것과 같은 동작
//		response.sendRedirect("/WEB-INF/views/member/test.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
