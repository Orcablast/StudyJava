package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgrView {
	
	Scanner sc = new Scanner(System.in);
	
	public int main() {		
		while(true) {
			System.out.println("=================== 회원관리 프로그램 v7.0 ===================");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (1인)");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			
			int select = sc.nextInt();
			
			return select;
		}		
	}
	
	public Grade insertMbr() {
		
		while(true) {			
			System.out.println("------ 회원 가입을 진행합니다. ------");
			System.out.print("이   름 : ");
			String name = sc.next();
									
			System.out.print("등   급 : ");
			String grade = sc.next().toLowerCase();
			
			System.out.print("포인트 : ");
			int point = sc.nextInt();
					
			
			Grade g = switchGradeOrNull(name, grade, point);
			
			if(g!=null) {
				return g;
			} else {
				continue;				
			}			
		}			
	}
	
	public void printAllMbr(ArrayList<Grade> mbrs) {
		System.out.println("등급\t이름\t보유포인트\t보너스포인트");
		
		for(Grade g : mbrs) {
			System.out.println(g);
		}
	}
	
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public String getName(String msg) {
		System.out.print(msg+"할 회원 이름 : ");
		String name = sc.next();
		return name;
	}
	
	public Grade modifyMbr() {
		
		while(true) {
			System.out.print("수정할 이름 : ");
			String name = sc.next();
			
			System.out.print("수정할 등급 : ");
			String grade = sc.next().toLowerCase();
			
			System.out.print("수정할 포인트 : ");
			int point = sc.nextInt();					
			
			Grade g = switchGradeOrNull(name, grade, point);
			
			if(g!=null) {
				return g;
			} else {
				continue;
			}
		}		
	}
	
	
	public Grade switchGradeOrNull(String name, String grade, int point) {
		switch(grade) {
		
		case "silver" :
			return new Silver(name,grade,point);
			
		case "gold" : 
			return new Gold(name,grade,point);
			
		case "vip" :
			return new Vip(name,grade,point);			
			
		case "vvip":
			return new Vvip(name,grade,point);			
			
		default : 
			System.out.println("회원 등급을 잘못 입력하셨습니다 : "+grade);
			return null;
		}		
	}
	
}
