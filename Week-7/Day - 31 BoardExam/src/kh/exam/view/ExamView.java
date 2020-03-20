package kh.exam.view;

import java.util.Scanner;

import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamView {

	Scanner sc = new Scanner(System.in);

	public int logInMenu() {

		System.out.println("\n----------- KH 커뮤니티 -----------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디 찾기");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");

		return sc.nextInt();
	}
	
	public int mainMenu() {
		System.out.println("\n----------- KH 커뮤니티 -----------");
		System.out.println("1. 게시물 목록");
		System.out.println("2. 게시물 상세보기");
		System.out.println("3. 게시물 등록");
		System.out.println("4. 게시물 수정");
		System.out.println("5. 게시물 삭제");
		System.out.println("6. 내 정보 보기");
		System.out.println("7. 내 정보 변경");
		System.out.println("8. 회원 탈퇴");
		System.out.println("0. 로그아웃");
		System.out.print("선택 > ");
		
		int slt = sc.nextInt();
		sc.nextLine();
		
		return slt;
	}

	public void printBoardItems() {
		System.out.println("\n번호\t제목\t\t작성자\t조회수\t  작성일");
	}

	public void printBoardDetails(Board b) {
		System.out.println("게시물 번   호 : " + b.getBoardNo());
		System.out.println("게시물 제   목 : " + b.getBoardTitle());
		System.out.println("게시물 내   용 : " + b.getBoardContent());
		System.out.println("\n게시물 조회수 : " + b.getReadCount());
		System.out.println("게시물 작성일 : " + b.getWriteDate());
	}

	public Member inputUserInfo(String keyWord) {
		
		Member m = new Member();
		
		if(keyWord.contains("로그인")) {
			
			System.out.print("ID 입력 : ");
			m.setMemberId(sc.next());
			System.out.print("PW 입력 : ");
			m.setMemberPw(sc.next());
			
		} else if(keyWord.contains("가입")) {
			
			System.out.print("ID 입력 : ");
			m.setMemberId(sc.next());
			System.out.print("PW 입력 : ");
			m.setMemberPw(sc.next());
			System.out.print("이름 입력 : ");
			m.setMemberName(sc.next());
			System.out.print("연락처 입력 (Ex.01012345678) : ");
			m.setPhone(sc.next());
			
		} else if (keyWord.contains("수정")) {
			
			System.out.print("PW 입력 : ");
			m.setMemberPw(sc.next());
			
			System.out.print("연락처 입력 (Ex.01012345678) : ");
			m.setPhone(sc.next());
			
		} else if (keyWord.contains("찾기")) {
			
			System.out.print("이름 입력 : ");
			m.setMemberName(sc.next());
			System.out.print("연락처 입력 (Ex.01012345678) : ");
			m.setPhone(sc.next());
		}
		
		return m;
	}

	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public void printTCResult(int result, String msg) {
		if(result > 0) {
			System.out.println(msg+" 성공");
		} else {
			System.out.println(msg+" 실패");
		}
	}
	
	public void printSubject(String msg) {
		System.out.println("\n----------- "+msg+" -----------");
	}
	
	public int mbrQuit() {
		printSubject("회원 탈퇴");
		System.out.print("정말 탈퇴 하시겠습니까 ? [1.YES / 2.NO] : ");
		return sc.nextInt();
		
	}

	public Board boardWrite() {
		
		Board b = new Board();
		
		System.out.print("제목 입력 : ");
		b.setBoardTitle(sc.nextLine());
		
		System.out.print("내용 입력 : ");
		b.setBoardContent(sc.nextLine());		
		
		return b;
	}

	public int selectOnList() {
		
		System.out.print("게시물 번호 입력 : ");
		
		return sc.nextInt();
	}
	
	public Board modifyBoard(Board b) {
		
		System.out.print("제목 입력 : ");
		b.setBoardTitle(sc.nextLine());
		System.out.print("내용 입력 : ");
		b.setBoardContent(sc.nextLine());
		
		return b;
	}
	
}
