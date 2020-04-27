package kh.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(name = "Calc", urlPatterns = { "/cal" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. request 데이터 인코딩 (한글이 있을 수 있으므로)
		request.setCharacterEncoding("utf-8");
		
		// 2. 넘어온 값 변수에 저장
		int firstVal = Integer.parseInt(request.getParameter("first_value"));
		int secondVal = Integer.parseInt(request.getParameter("second_value"));
		String cal = request.getParameter("cal");
		int result = 0;
		
		// 3. 비즈니스 로직 호출
		if(cal.equals("+")) {
			result = firstVal + secondVal;
		} else if(cal.equals("-")) {
			result = firstVal - secondVal;
		} else if(cal.equals("*")) {
			result = firstVal * secondVal;
		} else if(cal.equals("/")) {
			result = firstVal / secondVal;
		}
		
		// 4. 결과 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>계산결과</title></head>");
		out.println("<body>");
		out.println("<h2>연산결과</h2><hr>");
		out.println("<p>"+firstVal+cal+secondVal+"="+result+"</p>");
		out.println("</body>");
		out.println("</html>");
		
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
