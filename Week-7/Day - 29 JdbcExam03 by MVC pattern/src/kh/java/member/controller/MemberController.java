package kh.java.member.controller;

import java.util.ArrayList;

import kh.java.member.dao.MemberDao;
import kh.java.member.view.MemberView;
import kh.java.member.vo.Member;

public class MemberController {

	MemberView mv = new MemberView();
	MemberDao md = new MemberDao();
	

	public void main() {
		while (true) {
			int slt = mv.mainMenu();

			switch (slt) {
			case 1: // 회원 전체 출력
				printAll();
				break;

			case 2: // 회원 ID로 검색
				printMbr("조회할 ID : ");
				break;

			case 3: // 회원 이름으로 검색
				printMbr("조회할 회원명 : ");
				break;

			case 4: // 회원 가입
				insertMbr();
				break;

			case 5: // 회원 정보 수정
				modifyMbr();
				break;

			case 6: // 회원 삭제
				deleteMbr();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("0~6 사이의 수를 입력하세요.");
				break;
			}
		}
	}

	public void insertMbr() {
		
		Member m = mv.getMbrInfo();
		
		int result = md.insertMbr(m);

		mv.printResult(result, "회원가입");
		
	}
	
	public void printAll() {
		
		ArrayList<Member> mbrs = md.getAllMbrs();
		
		if(mbrs.isEmpty()) {
			mv.printMsg("회원이 존재하지 않습니다.");
		} else {
			
			mv.printColumns();
			
			for(Member m : mbrs) {
				mv.printMsg(m.toString());
			}
		}
	}
	
	public void printMbr(String keyWord) {
		String key = mv.askKey(keyWord);
		
		ArrayList<Member> mbrs  = md.getMbr(keyWord,key);
		
		if(mbrs.isEmpty()) {
			mv.printMsg("찾으시는 회원이 없습니다.");
			
		} else {
			mv.printColumns();
			for(Member m : mbrs) {
				mv.printMsg(m.toString());				
			}
		}
		
	}
	
	public void deleteMbr() {
		String key = mv.askKey("삭제할 회원 ID : ");
		
		int result = md.deleteMbr(key);
		
		mv.printResult(result, "회원 삭제");
						
	}

	public void modifyMbr() {
		String key = mv.askKey("수정할 회원 ID : ");
		
		ArrayList<Member> mbrs = md.getMbr("ID", key);
		
		Member m = null;
		
		if(mbrs.isEmpty()) {
			System.out.println("해당하는 회원이 없습니다.");
			
		} else {
			m = mv.getModInfo(mbrs.get(0));
			
			m.setMemberId(key);
			
			int result = md.modifyMbr(m);
			
			mv.printResult(result, "수정");
						
		}
	}
}
