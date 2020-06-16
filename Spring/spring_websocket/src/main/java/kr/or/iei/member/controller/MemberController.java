package kr.or.iei.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService service;	
	
	public MemberController() {
		super();		
		System.out.println("멤바 컨트롤러 생성");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String errorHandler() {
		return "redirect:/error.do";
	}
	
	@RequestMapping(value = "/goChat.do")
	public String goChat() {
		return "member/chat";
	}
	
	@RequestMapping("/error.do")
	public String error() {
		return "member/error";
	}
	
	@RequestMapping(value="/login.do")
	public String loginMember(HttpSession session, Member m) {		
		
		//비지니스 로직 호출
		Member member = service.selectOneMember(m);						
		
		if(member != null) {
			session.setAttribute("member", member);	
			return "member/loginSuccess";
		} else {
			return "member/loginFailed";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/selectAllMember.do", produces = "application/json;charset=utf-8")
	public String selectAllMember() {
		
		ArrayList<Member> list = service.selectAllMember();
		
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value="/allMember.do")
	public String allMember() {
		return "member/allMember";
	}
	
	// ajax 통신의 return 방식
	@CrossOrigin(origins = {"http://192.168.10.7","http://localhost","http://192.168.10.8"})
	@ResponseBody
	@RequestMapping(value="/checkId.do", produces = "text/html;charset=utf-8")
	public String checkId(String memberId) {		
		// 비지니스 로직 호출
		int result = service.checkId(memberId);
		
		if(result==0) { // 사용가능한 아이디
			return "0";
		} else { // 사용중인 아이디
			return "1";			
		}
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/join";
	}
	
	@RequestMapping(value="/join.do")
	public String join(Member m) {
		
		int result = service.insertMember(m);
		if(result>0) {
			return "member/joinSuccess";
		} else {
			return "member/joinFailed";
		}
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		// viewResolver를 사용을 회피하기 위해 redirect: 기입
		return "redirect:/";		
	}
	
	@RequestMapping(value = "/mypage.do")
	public String mypage(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("member");
		
		model.addAttribute("m",m);
		
		return "member/mypage";
	}
	
	@RequestMapping(value = "/mUpdate.do")
	public String mUpdate(HttpSession session, Member m) {
		
		int result = service.updateMember(m);
			
		if(result >0) {
			session.setAttribute("member", m);
			return "member/mypageSuccess";
			
		} else {
			return "member/mypageFailed";
		}		
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(HttpSession session) {
		
		Member m = (Member)session.getAttribute("member");
		
		int result = service.deleteMember(m);
		
		if(result>0) {
			session.invalidate();
			return "member/deleteSuccess";
		} else {
			return "member/deleteFailed";
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/arduinoTest.do")
	public String arduino(String str) {
		System.out.println(str);
		return "ok";
	}
	
}
