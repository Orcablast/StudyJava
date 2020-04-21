package kh.java.member.controller;

import java.util.ArrayList;

import kh.java.member.dao.MemberDao;
import kh.java.member.service.MemberService;
import kh.java.member.view.MemberView;
import kh.java.member.vo.Member;

public class MemberController {

	MemberView view = new MemberView();
	MemberDao dao = new MemberDao();
	MemberService service = new MemberService();
	
	public void main() {

		while (true) {

			switch (view.mainMenu()) {
			case 1:
				selectAll();
				break;

			case 2:
				searchMember();
				break;

			case 3:
				insertMember();
				break;

			case 4:
				modifyMember();
				break;

			case 5:
				deleteMember();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				break;

			}
		}
	}
	
	public void insertMember() {
		Member m = view.insertMember();
		
		int result = service.insertMember(m);
		
		if(result > 0) {
			view.printMsg("회원가입 성공!");
		} else {
			view.printMsg("회원가입에 실패하였습니다.");
		}
		
	}
	
	public void selectAll() {
		ArrayList<Member> list = service.selectAll();
		
		if(list.isEmpty()) {
			view.printMsg("회원이 없습니다.");
		} else {
			view.printAll(list);			
		}
		
	}
	
	public void searchMember() {
		Member m = view.searchMember("검색");
		
		m = service.searchMember(m);
		
		if(m.getMemberName() == null) {
			view.printMsg("해당하는 회원이 없습니다.");
		} else {
			view.printSubject();
			view.printMsg(m.toString());
		}
	}
	
	public void modifyMember() {
		Member m = view.searchMember("수정");
		int result = 0;
		
		m = service.searchMember(m);
		
		if(m.getMemberName() == null) {
			view.printMsg("해당하는 회원이 없습니다.");
		} else {
			m = view.getModInfo(m);
			result = service.modifyMember(m);
			
			if(result > 0) {
				view.printMsg("회원정보를 수정하였습니다");
			} else {
				view.printMsg("회원정보 수정에 실패하였습니다");
			}
		}
	}

	public void deleteMember() {
		Member m = view.searchMember("삭제");
		
		int result = 0;
		
		m = service.searchMember(m);
		
		if(m.getMemberName() == null) {
			view.printMsg("해당하는 회원이 없습니다.");
		} else {
			result = service.deleteMember(m);
			
			if(result > 0) {
				
				view.printMsg("회원 삭제 성공");		
				
			} else {
				view.printMsg("회원 삭제 실패");
			}
		}
	}
}
