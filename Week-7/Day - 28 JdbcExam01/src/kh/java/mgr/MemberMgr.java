package kh.java.mgr;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.db.DBConnect;
import kh.java.db.Member;

public class MemberMgr {

	Scanner sc = new Scanner(System.in);

	DBConnect db = new DBConnect();

	ArrayList<Member> mbrs = new ArrayList<Member>();

	public void main() {

		while (true) {
			System.out.println("=========== 회원 관리 프로그램 v1.2 ===========");
			System.out.println("1. 회원 전체 정보 조회"); // select
			System.out.println("2. 회원 아이디 조회"); // select
			System.out.println("3. 회원 이름 조회"); // select
			System.out.println("4. 회원 가입"); // insert
			System.out.println("5. 회원 정보 변경"); // update
			System.out.println("6. 회원 삭제"); // delete
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printAll();
				break;

			case 2:
				idSearch();
				break;

			case 3:
				nameSearch();
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
				return;

			default:
				System.out.println("0~6까지의 정수를 입력하세요");
				continue;
			}
		}
	}

	public void deleteMbr() {
		
		System.out.print("삭제할 회원의 ID : ");
		String memberId = sc.next();
		
		int result = db.deleteMbr(memberId);
		
		if(result > 0) {
			System.out.println("회원 삭제가 완료되었습니다.");
		} else {
			System.out.println("회원 삭제에 실패하였습니다.");
		}
		
	}

	public void modifyMbr() {
		
		System.out.print("수정할 회원의 ID : ");
		String memberId = sc.next();
		
		Member m = db.idSearch(memberId);
		
		if(m!= null) {
		
			System.out.print("비밀번호 수정 : ");
			String memberPw = sc.next();
			
			System.out.print("연락처 : ");
			String phone = sc.next();
			
			System.out.print("취미 수정 : ");
			String hobby = sc.next();
			
			Member mbr = new Member();
			
			mbr.setMemberId(memberId);
			mbr.setMemberPw(memberPw);
			mbr.setPhone(phone);
			mbr.setHobby(hobby);
			
			int result = db.modifyMbr(mbr);
			
			if(result > 0) {
				System.out.println("회원 정보 수정이 완료되었습니다.");
			} else {
				System.out.println("회원 정보 수정이 실패하였습니다.");
			}
			
		} else {
			System.out.println("해당하는 회원이 없습니다.");
		}
		
		
		
	}

	public void insertMbr() {

		System.out.println("회원 정보를 입력해주세요.");
		System.out.print("회원 ID : ");
		String memberId = sc.next();
		
		if(db.idSearch(memberId)!=null) {
		
			System.out.println("중복되는 ID가 있습니다.");
			
		} else {
			System.out.print("비밀번호 : ");
			String memberPw = sc.next();
			System.out.print("회원 이름 : ");
			String memberName = sc.next();
			System.out.print("성별 [M/F] : ");
			String gender = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("연락처 : ");
			String phone = sc.next();
			System.out.print("취미 : ");
			String hobby = sc.next();

			while ((gender.charAt(0) != 'M') && (gender.charAt(0) != 'F')) {
				System.out.println("성별 입력은 M 또는 F로 입력해주세요.");

				System.out.print("성별 [M/F] : ");
				gender = sc.next();
			}

			Member mbr = new Member(memberId, memberPw, memberName, gender, age, phone, hobby, null);

			
			int result = db.insertMbr(mbr);

			if (result > 0) {
				System.out.println("회원가입이 완료되었습니다.");
			} else {
				System.out.println("회원가입에 실패하였습니다.");
			}
		}
	}

	public void nameSearch() {

		System.out.println("검색할 회원명 : ");
		String memberName = sc.next();

		mbrs = db.nameSearch(memberName);

		int i = 1;

		if (!(mbrs.size() == 0)) {
			for (Member m : mbrs) {

				System.out.println((i++) + "번째 회원의 정보");

				System.out.println("회원 ID : " + m.getMemberId());
				System.out.println("회원 PW : " + m.getMemberPw());
				System.out.println("회원 이름 : " + m.getMemberName());

				char gender = m.getGender().charAt(0);

				if (gender == 'M') {
					System.out.println("회원 성별 : 남자");

				} else {
					System.out.println("회원 성별 : 여자");
				}

				System.out.println("회원 나이 : " + m.getAge());
				System.out.println("회원 연락처 : " + m.getPhone());
				System.out.println("회원 취미 : " + m.getHobby());
				System.out.println("회원 가입일 : " + m.getEnrollDate());
			}

			mbrs.clear();

		} else {
			System.out.println("찾으시는 회원이 없습니다.");
		}
	}

	public void idSearch() {
		System.out.print("검색할 ID : ");
		String memberId = sc.next();

		Member member = db.idSearch(memberId);

		if (member == null) {
			System.out.println("아이디를 조회 할 수 없습니다.");

		} else {

			System.out.println("아이디 : " + member.getMemberId());
			System.out.println("비번 : " + member.getMemberPw());
			System.out.println("이름 : " + member.getMemberName());
			System.out.println("성별 : " + member.getGender());
			System.out.println("나이 : " + member.getAge());
			System.out.println("연락처 : " + member.getPhone());
			System.out.println("취미 : " + member.getHobby());
			System.out.println("가입일 : " + member.getEnrollDate());
		}
	}

	public void printColumns() {
		System.out.println("============== 회원 정보 출력 =============");

		System.out.println("ID\tPW\t이름\t성별\t나이\t연락처\t\t취미\t가입일");

	}

	public void printAll() {

		mbrs = db.searchAll();

		printColumns();

		for (Member m : mbrs) {

			System.out.println(m);

		}

	}
}
