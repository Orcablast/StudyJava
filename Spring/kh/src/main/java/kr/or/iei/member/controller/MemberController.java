package kr.or.iei.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.or.iei.member.model.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/beginSpring/memberRegister.action", method = { RequestMethod.POST })
	public String memberRegisterEnd(HttpServletRequest request, ModelAndView mv) {

			String userid = request.getParameter("userid");

			String passwd = request.getParameter("passwd");

			String name = request.getParameter("name");

			String email = request.getParameter("email");

			String tel = request.getParameter("tel");

			HashMap<String, String> paraMap = new HashMap<String, String>();

			paraMap.put("userid", userid);

			paraMap.put("passwd", passwd);

			paraMap.put("name", name);

			paraMap.put("email", email);

			paraMap.put("tel", tel);

			int n = service.memberRegister(paraMap);
		
			System.out.println("콘트롤러 : 오류 발생");
		

		return "index";
	}
}
