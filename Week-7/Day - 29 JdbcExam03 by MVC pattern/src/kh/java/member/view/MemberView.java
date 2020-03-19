package kh.java.member.view;

import java.util.Scanner;

import kh.java.member.vo.Member;

public class MemberView {

	Scanner sc = new Scanner(System.in);
	
	public int mainMenu() {

		System.out.println("\n============== 회원 관리 프로그램 v1.4 ==============");
		System.out.println("1. 회원 전체 출력");
		System.out.println("2. 회원 ID 검색");
		System.out.println("3. 회원 이름 검색");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
		
		int slt = sc.nextInt();
		
		return slt;
	}

	public Member getMbrInfo() {
		
		System.out.println("\n회원 정보를 입력하세요.");		
				
		System.out.print("회원 ID : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("성별 : ");
		String gender = sc.next();
		switchGender(gender);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("연락처 : ");
		String phone = sc.next();
		System.out.print("취미 : ");
		String hobby = sc.next();
		
		Member m = new Member(memberId, memberPw, memberName, gender, age, phone, hobby, null);
				
		return m;
	}
	
	public void printResult(int result, String msg) {
		if(result > 0) {
			System.out.println(msg+"에 성공하였습니다.");
		} else {
			System.out.println(msg+"에 실패하였습니다.");
		}
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public String switchGender(String gender) {
		
		while(!(gender.contains("남") && !(gender.contains("여") && !(gender.charAt(0)=='M') && !(gender.charAt(0)=='F')))) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.print("성별 : ");
			gender = sc.next();
		}			
		
		if(gender.contains("남")) {
			gender = "M";
		} else if (gender.contains("여")) {
			gender = "F";
		}
		
		return gender;
	}
	
	public void printColumns() {
		System.out.println("\n  ID\t비밀번호\t이름\t성별\t나이\t연락처\t\t취미\t가입일");
	}

	public String askKey(String msg) {

		System.out.print(msg);
		
		return sc.next();
	}

	
	public Member getModInfo(Member m) {

		System.out.println("\n수정 할 회원 정보를 입력하세요.");		
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("연락처 : ");
		String phone = sc.next();
		System.out.print("취미 : ");
		String hobby = sc.next();
		
		m = new Member(m.getMemberId(), memberPw, memberName, m.getGender(), m.getAge(), phone, hobby, m.getEnrollDate());
				
		return m;
	}
	
	

}
