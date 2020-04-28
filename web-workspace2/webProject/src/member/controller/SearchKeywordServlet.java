package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class SearchKeywordServlet
 */
@WebServlet(name = "SearchKeyword", urlPatterns = { "/searchKeyword" })
public class SearchKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchKeywordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");

		// 2. 변수저장
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");

		// 3. 비지니스 로직
		ArrayList<Member> list = new MemberService().searchMember(type, keyword);

		// 4. 결과처리
		RequestDispatcher rd = null;
		if (!list.isEmpty()) {
			rd = request.getRequestDispatcher("/WEB-INF/views/member/adminPage.jsp");
			request.setAttribute("list", list);
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "해당하는 회원이 없습니다.");
			request.setAttribute("loc", "/adminPage");
		}
		
		rd.forward(request, response);

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
