package kh.java.controller;

import java.util.ArrayList;

import kh.java.view.PointMgrView;
import kh.java.vo.Grade;

public class PointMgrControll {

	PointMgrView view = new PointMgrView();

	ArrayList<Grade> mbrs = new ArrayList<Grade>();

	public void main() {
		
		while(true) {
			int select = view.main();
			
			switch (select) {
			case 1: // 회원가입
				
				insertMbr(view.insertMbr());
				break;

			case 2: // 회원정보 출력 (전체)
				view.printAllMbr(mbrs);
				break;

			case 3: // 회원정보 출력 (1인)
				printMbr();
				break;

			case 4: // 회원정보 수정
				modifyMbr();
				break;

			case 5:
				deleteMbr();
				break;

			case 0:
				view.printMsg("프로그램을 종료합니다.");
				return;

			default:
				view.printMsg("잘못된 입력입니다.");

			}
		}		
	}

	public void insertMbr(Grade g) {
		if(searchMbr(g.getName())==-1) {
			mbrs.add(g);
		} else {
			view.printMsg("이름이 중복되는 회원이 있습니다.");
		}		
	}

	public void printMbr() {
		String name = view.getName("수정");
		int index = searchMbr(name);
		
		if(index==-1) {
			view.printMsg("회원이 없습니다.");
			return;		
			
		} else {
			System.out.println(mbrs.get(index).getName()+"님의 회원정보");
			System.out.println("등급 : "+mbrs.get(index).getGrade());
			System.out.println("포인트 : "+mbrs.get(index).getPoint());
			System.out.println("보너스 포인트 : "+mbrs.get(index).getBonus());
			
		}
		
	}

	public int searchMbr(String name) {

		for (int i = 0; i < mbrs.size(); i++) {
			if (mbrs.get(i).getName().equals(name)) {
				return i;
			}
		}

		return -1;
	}
	
	public void modifyMbr() {
		String name = view.getName("수정");
		int index = searchMbr(name);
		
		if(index==-1) {
			view.printMsg("회원이 없습니다.");
			return;
		} else {
			Grade g = view.modifyMbr();
			
			mbrs.set(index, g);
		}		
		
	}
	
	public void deleteMbr() {
		String name = view.getName("삭제");
		int index = searchMbr(name);
		
		if(index==-1) {
			view.printMsg("회원이 없습니다.");
			return;
		} else {
			mbrs.remove(index);
		}	
	}

}
