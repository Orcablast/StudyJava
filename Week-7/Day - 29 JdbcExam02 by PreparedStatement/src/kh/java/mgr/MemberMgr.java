package kh.java.mgr;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.db.DBConnect;
import kh.java.db.Member;

public class MemberMgr {

	Scanner sc = new Scanner(System.in);

	DBConnect db = new DBConnect();
	
	public void main() {

		while (true) {
			System.out.println("\n============== 회원 관리 프로그램 v1.3 ==============");
			System.out.println("1. 회원 전체 출력");
			System.out.println("2. 회원 ID 검색");
			System.out.println("3. 회원 이름 검색");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printAllMbr();
				break;

			case 2:
				searchById();
				break;

			case 3:
				searchByName();
				break;

			case 4:
				insertMbr();
				break;

			case 5:
				modifyMbr();
				break;

			case 6:
				deleteMbr();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");

			default:
				System.out.println("0~6까지의 정수만 입력하세요.");				
				return;

			}
		}
	}

	public void modifyMbr() {

		Member m = new Member();
		
		System.out.print("수정할 회원 ID : ");
		String memberId = sc.next();
		m.setMemberId(memberId);
		
		System.out.print("비밀번호 수정 : ");
		m.setMemberPw(sc.next());
		
		System.out.print("연락처 수정 : ");
		m.setPhone(sc.next());
		
		System.out.print("취미 수정 : ");
		m.setHobby(sc.next());
		
		int result = db.modifyMbr(m);
		
		if(result > 0) {
			System.out.println("정보 수정을 완료했습니다.");
		} else {
			System.out.println("정보 수정에 실패하였습니다.");
		}
	}
	
	public void searchById() {
		System.out.print("조회할 회원의 ID : ");
		String memberId = sc.next();
		
		Member m = db.searchById(memberId);
		
		printColumns();		
		System.out.println(m);
		
	}
	
	public void searchByName() {
		System.out.print("조회할 회원의 이름 : ");
		String memberName = sc.next();
		
		ArrayList<Member> mbrs = db.searchByName(memberName);
		
		printColumns();
		
		for(Member m : mbrs) {
			System.out.println(m);
		}
		
	}
	
	public void printColumns() {
		System.out.println("\n  ID\t비밀번호\t이름\t성별\t나이\t연락처\t\t취미\t가입일");
	}

	public void printAllMbr() {
		
		ArrayList<Member> mbrs = db.getAllMbr();
		
		printColumns();
		
		for(Member m : mbrs) {
			System.out.println(m);
		}
		
	}

	public void insertMbr() {
		
		System.out.println("\n회원 정보를 입력해주세요.");
		System.out.print("회원 ID : ");
		String memberId = sc.next();
		
		if(db.searchById(memberId)==null) {
			
			System.out.print("비밀번호 : ");
			String memberPw = sc.next();
			
			System.out.print("회원 이름: ");
			String memberName = sc.next();
			
			System.out.print("성별 : ");
			String gender = sc.next();
			
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
			
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			System.out.print("연락처 : ");
			String phone = sc.next();
			
			System.out.print("취미 : ");
			String hobby = sc.next();
			
			Member m = new Member(memberId, memberPw, memberName, gender, age, phone, hobby, null);
			
			int result = db.insertMbr(m);
			
			if(result > 0) {
				System.out.println("회원가입이 완료되었습니다.");
			} else {
				System.out.println("회원가입이 실패하였습니다.");
			}
			
		} else {
			System.out.println("중복되는 회원이 있습니다.");
			System.out.println("입력한 ID : "+memberId);
		}
	}
	
	public void deleteMbr() {
		System.out.print("삭제할 회원 ID : ");
		String memberId = sc.next();
		
		int result = db.deleteMbr(memberId);
		
		if(result>0) {
			System.out.println("회원을 삭제하였습니다.");
			
		} else {
			System.out.println("회원 삭제에 실패하였습니다.");
		}
	}
}
