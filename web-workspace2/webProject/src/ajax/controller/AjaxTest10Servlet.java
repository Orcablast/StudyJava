package ajax.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxTest10Servlet
 */
@WebServlet(name = "AjaxTest10", urlPatterns = { "/ajaxTest10" })
public class AjaxTest10Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest10Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, User> map = new HashMap<String, User>();
		User user1 = new User(1, "사람1", "주소1");
		User user2 = new User(2, "사람2", "주소2");
		User user3 = new User(3, "사람3", "주소3");
		User user4 = new User(4, "사람4", "주소4");
		User user5 = new User(5, "사람5", "주소5");
		
		map.put(user1.getUserName(), user1);
		map.put(user2.getUserName(), user2);
		map.put(user3.getUserName(), user3);
		map.put(user4.getUserName(), user4);
		map.put(user5.getUserName(), user5);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(map, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
