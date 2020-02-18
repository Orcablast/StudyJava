package kh.java.controller;

import java.util.HashMap;
import java.util.Set;

import kh.java.view.PointMgrView;
import kh.java.vo.Grade;

public class PointMgr {

	PointMgrView view = new PointMgrView();

	HashMap<String, Grade> mbrs = new HashMap<String, Grade>();

	public void main() {

		while (true) {

			int slt = view.main();

			switch (slt) {
			case 1:
				insertMbr();
				break;

			case 2:
				view.printAllMbr(mbrs);
				break;

			case 3:
				printMbr();
				break;

			case 4:
				modifyMbr();
				break;

			case 5:
				deleteMbr();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void insertMbr() {
		Grade g = view.insertMbr();

		if (mbrs.containsKey(g.getName())) {
			System.out.println("중복되는 회원이 있습니다.");
			return;
		} else {
			mbrs.put(g.getName(), g);
		}
	}

	public void printMbr() {
		String name = view.getName("검색");

		if (mbrs.containsKey(name)) {
			System.out.println(mbrs.get(name).getName() + "님의 회원정보를 출력합니다.");
			System.out.println("회원 등급 : " + mbrs.get(name).getGrade());
			System.out.println("보유 포인트 : " + mbrs.get(name).getPoint());
			System.out.println("보너스 포인트 : " + mbrs.get(name).getBonus());

		} else {

			System.out.println("회원이 없습니다.");
		}
	}

	public void modifyMbr() {
		String name = view.getName("수정");
		
		if(mbrs.containsKey(name)) {
			
			Grade g = view.modifyMbr();
			
			if(g==null) {
				System.out.println("잘못된 회원 등급입니다.");
				
			} else if (mbrs.containsKey(g.getName())) {
				System.out.println("중복되는 회원이 있습니다.");
				
			} else {
				mbrs.remove(name);
				mbrs.put(g.getName(), g);
			}	
			
		} else {
			System.out.println("회원 정보가 없습니다.");			
		}		
	}
	
	public void deleteMbr() {
		String name = view.getName("삭제");
		
		mbrs.remove(name);		
	}

}
