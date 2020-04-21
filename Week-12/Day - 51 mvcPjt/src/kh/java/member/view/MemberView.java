package kh.java.member.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.member.vo.Member;

public class MemberView {

	Scanner sc = new Scanner(System.in);
	
	public int mainMenu() {
		System.out.println("\n=========== 회원관리 ===========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 1명 조회");
		System.out.println("3. 회원 등록");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
				
		return sc.nextInt();
	}
	
	public Member insertMember() {
		System.out.println("\n회원 가입을 진행합니다");
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		System.out.print("이름 입력 : ");
		String memberName = sc.next();
		System.out.print("성별 입력 [M/F] : ");
		String gender = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("전화번호 입력 [000-0000-0000] : ");
		String phone = sc.next();
		System.out.print("취미 입력 : ");
		String hobby = sc.next();
		
		Member m = new Member(memberId, memberPw, memberName, gender, age, phone, hobby, null);
		
		return m;
	}

	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public void printSubject() {
		System.out.println("\n회원 ID\t회원 이름\t회원 나이\t회원 성별\t회원 취미\t전화번호\t\t가입일");
	}

	public void printAll(ArrayList<Member> list) {
		printSubject();
		
		for(Member m : list) {
			System.out.println(m);
		}
		
	}

	public Member searchMember(String msg) {
		
		Member m = new Member();
		
		System.out.print(msg+"할 회원 ID : ");
		m.setMemberId(sc.next());
		
		return m;
	}

	public Member getModInfo(Member m) {
		
		System.out.print("수정할 비밀번호 : ");
		m.setMemberPw(sc.next());
		
		System.out.print("수정할 회원 이름 : ");
		m.setMemberName(sc.next());
				
		System.out.print("수정할 취미 : ");
		m.setHobby(sc.next());
		
		System.out.print("수정할 전화번호 : ");
		m.setPhone(sc.next());
		
		
		return m;
	}
	
}
