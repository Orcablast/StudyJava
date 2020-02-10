package kr.or.iei.controller;

import java.util.Scanner;
import kr.or.iei.point.Silver;

public class PointMgr {
	
	Scanner sc = new Scanner(System.in);
	Silver[] svs = new Silver[30];
	
	int index;

	public void main() {

		while (true) {
			System.out.println("========= Silver 포인트 관리 v1.0 =========");
			System.out.println("현재 회원 수 : "+index);
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원정보 출력 (전체)");
			System.out.println("3. 회원정보 출력 (1인)");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원 탈퇴");
			System.out.print("선택 > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1: // 회원가입
				System.out.println("회원가입을 진행합니다.");			
				
				insertMbr();
				
				break;
				
			case 2: // 회원정보 출력 (전체)
				
				printAll();
				break;

			case 3: // 회원정보 출력 (1인)
				
				printMbr();				
				break;

			case 4: // 회원정보 수정
				modifyMbr();
				break;

			case 5: // 회원 탈퇴
				delMbr();
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;

			}

		}
	} // main method 종료
	
	
	public void insertMbr() { // 회원가입 메소드
		System.out.print("이       름    : ");
		String name = sc.next();
		
		if(findMbr(name)!=-1) { // 회원중 같은 이름이 있으면 회원가입을 중단
			System.out.println("중복된 회원이 있습니다.");
			return;
		}
		
		System.out.print("등       급    : ");
		String grade = sc.next();
		System.out.print("보유 포인트 : ");
		int point = sc.nextInt();
		
		
		Silver sv = new Silver(name, grade, point);
		
		svs[index] = sv; // 새로운 객체 sv를 객체배열 svs index번째로 저장
		index++;		
	}
	
	public void printAll() { // 회원 정보 전체를 출력하는 메소드
		System.out.println("이름\t등급\t보유 포인트\t보너스 포인트");
		
		for(int i=0; i<index; i++) {
			System.out.println(svs[i].getName()+"\t"+svs[i].getGrade()+"\t"+svs[i].getPoint()+"\t\t"+svs[i].getBonusP());
		}
	}
	
	public void printMbr() { // 이름을 통해 검색하여 해당 회원정보를 검색하는 메소드
		System.out.print("출력할 회원 이름 : ");
		String name = sc.next();
		
		int mbrIndex = findMbr(name);
		
		if(mbrIndex==-1) {
			System.out.println("회원이 없습니다.");
			return;
		} else {
			System.out.println("이       름       : "+svs[mbrIndex].getName());			
			System.out.println("등       급       : "+svs[mbrIndex].getGrade());
			System.out.println("보유    포인트 : "+svs[mbrIndex].getPoint());	
			System.out.println("보너스 포인트 : "+svs[mbrIndex].getBonusP());		
		}
		
	}
	
	public int findMbr(String name) { // 검색할 회원의 index를 return하는 메소드
		for(int i=0; i<index; i++) {
			if(svs[i].getName().equals(name)) { 
				return i; 
			}
		}		
		return -1;
	}
	
	public void modifyMbr() { // 회원 이름을 통해 회원정보를 수정하는 메소드
		System.out.print("수정할 회원 이름 : ");
		
		int mbrIndex = findMbr(sc.next());

		System.out.print("이       름    : ");
		svs[mbrIndex].setName(sc.next());
		System.out.print("등       급    : ");
		svs[mbrIndex].setGrade(sc.next());
		System.out.print("보유 포인트 : ");
		svs[mbrIndex].setPoint(sc.nextInt());
		
		System.out.println("수정이 완료되었습니다.");
	}
	
	public void delMbr() { // 회원 이름을 통해 회원정보를 삭제하는 메소드
		System.out.print("탈퇴할 회원 이름 : ");
		
		int mbrIndex = findMbr(sc.next());
		
		if(mbrIndex == -1) {
			System.out.println("회원이 없습니다.");
		} else {
			
			for(int i=mbrIndex; i<index-1; i++) {
				svs[i].setName(svs[i+1].getName());
				svs[i].setGrade(svs[i+1].getGrade());
				svs[i].setPoint(svs[i+1].getPoint());
			}			

			index--;			
			
			svs[index].setName(null);
			svs[index].setGrade(null);
			svs[index].setPoint(0);
			
		}		
	}
	
	
}
