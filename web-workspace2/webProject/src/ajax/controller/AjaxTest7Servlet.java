package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class AjaxTest7Servlet
 */
@WebServlet(name = "AjaxTest7", urlPatterns = { "/ajaxTest7" })
public class AjaxTest7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest7Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<User> list = new ArrayList<User>();
		
		list.add(new User(1, "박아무개", "서울아무데"));
		list.add(new User(2, "김아무개", "경기아무데"));
		list.add(new User(3, "최아무개", "부산아무데"));
		list.add(new User(4, "이아무개", "울산아무데"));
		list.add(new User(5, "장아무개", "한국아무데"));
		
		String userNums = request.getParameter("dataNum");
		StringTokenizer sT = new StringTokenizer(userNums,",");
		
		ArrayList<Integer> userNum = new ArrayList<Integer>();
		
		while(sT.hasMoreTokens()) {
			userNum.add(Integer.parseInt(sT.nextToken())-1);
		}
		
		JSONObject map = new JSONObject();
				
		for(int i=0; i<userNum.size(); i++) {
			User u = list.get(userNum.get(i));
			
			JSONObject result = new JSONObject();
			result.put("userNo", u.getUserNo());
			result.put("userName", URLEncoder.encode(u.getUserName()));
			result.put("userAddr", URLEncoder.encode(u.getUserAddr()));
			
			map.put(URLEncoder.encode(u.getUserName()), result);
		}			
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(map);
		out.flush(); // 버퍼링 되어서 아직 기록되지 않은 데이터를 출력스트림에 모두 출력
		out.close(); // 출력되지 않은 데이터가 있으면 먼저 출력하고 스트림 종료
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
