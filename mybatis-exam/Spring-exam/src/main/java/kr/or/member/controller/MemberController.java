package kr.or.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.board.model.vo.Board;
import kr.or.company.model.service.CompanyService;
import kr.or.company.model.vo.Company;
import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService service;	
	
	@Autowired
	@Qualifier("companyService")
	private CompanyService comService;
		
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		
		if(m != null) {
			return "common/main";
		} else {
			
			System.out.println("세션정보 없음");
			return "redirect:/";
		}		
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, Member m, Model model) {
		
		Member loginMember = service.selectOneMember(m);
		
		if(loginMember != null && loginMember.getMemberLevel() != 0) {
			
			Company c = comService.selectOneCompany(loginMember.getCompanyCode());
			HttpSession session = request.getSession();
			session.setAttribute("member", loginMember);
			session.setAttribute("memberCompany", c);
			return "redirect:/main.do";			
		} else if(loginMember != null && loginMember.getMemberLevel() == 0){
			model.addAttribute("msg","로그인 권한이 없습니다. 관리자에게 요청하세요.");
		} else {
			model.addAttribute("msg", "아이디 비밀번호를 확인하세요.");
		}
		model.addAttribute("loc","/");
		
		return "common/msg";
	}
	
	
	@RequestMapping("/insertMember.do")
	public String insertMember(Member m, Model model) {
		
		m.setMemberPw("1234");
		int result = service.insertMember(m);
		
		if(result>0) {
			model.addAttribute("msg","회원가입을 완료하였습니다");
			model.addAttribute("loc","/");
		} else {
			model.addAttribute("msg","회원가입에 실패하였습니다");
			model.addAttribute("loc","/");			
		}		
		
		return "common/msg";
	}
	
	@RequestMapping("/joinFrm.do")
	public String joinFrm(Model model) {
		
		List list = comService.selectAllCompany();
		
		model.addAttribute("list", (ArrayList<Company>)list);
		return "member/join";
	}	
}
