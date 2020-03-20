package kh.exam.controller;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.exam.model.dao.ExamDao;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;
import kh.exam.view.ExamView;

public class ExamController {

	ExamView view = new ExamView();

	Member loginMember;

	public void logIn() {

		while (true) {
			switch (view.logInMenu()) {
			case 1:
				signin();
				mainMenu();
				break;

			case 2:
				signup();
				break;

			case 3:
				searchByName();
				break;

			case 0:
				view.printMsg("프로그램을 종료합니다.");
				break;

			default:
				view.printMsg("0~3을 입력하세요.");
				break;

			}
		}
	}

	public void mainMenu() {
		while (loginMember != null) {
			switch (view.mainMenu()) {
			case 1:
				showBoardList();
				break;

			case 2:
				readBoard();
				break;

			case 3:
				boardWrite();
				break;

			case 4:
				modifyBoard();
				break;

			case 5:
				deleteBoard();
				break;

			case 6:
				showUserInfo();
				break;

			case 7:
				modifyUserInfo();
				break;

			case 8:
				mbrQuit();
				break;

			case 0:
				logOut();
				break;

			default:
				view.printMsg("잘못된 입력입니다.");
			}
		}

	}

	public void signup() {

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		view.printSubject("회원 가입");

		Member newMbr = view.inputUserInfo("가입");

		int result = db.signup(conn, newMbr);

		JDBCTemplate.commitOrRollback(conn, result);

		view.printTCResult(result, "회원가입");

		JDBCTemplate.close(conn);

	}

	public void searchByName() {

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		view.printSubject("아이디 찾기");

		Member m = view.inputUserInfo("찾기");

		m = db.searchMember(conn, m);

		if (checkMemberNull(m) > 0) {
			view.printMsg("아이디는 [" + m.getMemberId() + "] 입니다.");
		}

		JDBCTemplate.close(conn);
	}

	public void signin() {

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		view.printSubject("로그인");

		Member m = view.inputUserInfo("로그인");

		loginMember = db.searchMember(conn, m);

		if (checkMemberNull(loginMember) > 0) {
			System.out.println("로그인 성공!");
		}

		JDBCTemplate.close(conn);
	}

	public int checkMemberNull(Member m) {

		if (m == null) {
			System.out.println("일치하는 정보가 없습니다.");
			loginMember = null;

			return -1;
		}

		return 1;

	}

	public void logOut() {

		loginMember = null;
		view.printMsg("로그아웃하셨습니다.");

	}

	public void showUserInfo() {

		view.printSubject("내 정보 보기");

		view.printMsg(loginMember.toString());

	}

	public void modifyUserInfo() {

		view.printSubject("내 정보 수정");

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		Member m = view.inputUserInfo("수정");

		loginMember.setMemberPw(m.getMemberPw());
		loginMember.setPhone(m.getPhone());

		int result = db.modifyUserInfo(conn, loginMember);

		JDBCTemplate.commitOrRollback(conn, result);

		view.printTCResult(result, "정보 수정");

		loginMember = db.searchMember(conn, loginMember);

		JDBCTemplate.close(conn);

	}

	public void mbrQuit() {

		switch (view.mbrQuit()) {
		case 1:

			Connection conn = JDBCTemplate.getConnectionDB();

			ExamDao db = new ExamDao();

			int result = db.deleteMbr(conn, loginMember.getMemberId());

			view.printTCResult(result, "회원 탈퇴");

			if (result > 0) {
				JDBCTemplate.commit(conn);
				loginMember = null;

			} else {
				JDBCTemplate.rollback(conn);
			}

			JDBCTemplate.close(conn);

			System.out.println("이용해 주셔서 감사합니다.");
			break;

		case 2:
			System.out.println("탈퇴를 취소하셨습니다.");
			break;

		default:
			view.printMsg("잘못 입력하셨습니다.");
		}

	}

	public void boardWrite() {

		view.printSubject("게시물 작성");

		Board b = view.boardWrite();

		b.setBoardWriter(loginMember.getMemberId());

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		int result = db.boardWrite(conn, b);

		JDBCTemplate.commitOrRollback(conn, result);

		view.printTCResult(result, "게시물 등록");

		JDBCTemplate.close(conn);

	}

	public void showBoardList() {

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		view.printSubject("게시물 목록");

		ArrayList<Board> list = db.boardList(conn, -1);

		if (list.isEmpty()) {
			view.printMsg("작성된 게시글이 없습니다.");
			view.printMsg("이전 화면으로 돌아갑니다.");

		} else {

			view.printBoardItems();

			for (Board b : list) {
				view.printMsg(b.toString());
			}
		}

		JDBCTemplate.close(conn);
	}

	public void readBoard() {

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		ArrayList<Board> list = db.boardList(conn, 0);

		int slt = view.selectOnList();

		if ((slt <= list.size()) && (slt > 0)) {

			if (db.countRead(conn, list.get(slt - 1)) > 0) {
				JDBCTemplate.commit(conn);
				view.printSubject("게시글 정보");
				view.printBoardDetails(db.readBoard(conn, slt));
			} else {

				JDBCTemplate.rollback(conn);
				view.printMsg("게시글 조회에 실패하였습니다.");
			}

		} else {
			view.printMsg("게시물 번호를 확인하세요.");
		}

		JDBCTemplate.close(conn);
	}

	public void modifyBoard() {

		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();

		int slt = view.selectOnList();

		if ((slt <= db.boardList(conn, 0).size()) && (slt > 0)) {
			Board b = db.readBoard(conn, slt);

			if (checkWriter(loginMember, b)) {

				b = view.modifyBoard(b);

				slt = db.modifyBoard(conn, b);

				JDBCTemplate.commitOrRollback(conn, slt);

				view.printTCResult(slt, "게시글 수정");

			} else {
				view.printMsg("작성자만 수정이 가능합니다.");
			}

		} else {
			view.printMsg("게시물 번호를 확인하세요.");
		}

		JDBCTemplate.close(conn);

	}

	public void deleteBoard() {
		
		Connection conn = JDBCTemplate.getConnectionDB();

		ExamDao db = new ExamDao();
		
		int slt = view.selectOnList();

		if ((slt <= db.boardList(conn, 0).size()) && (slt > 0)) {
			Board b = db.readBoard(conn, slt);

			if (checkWriter(loginMember, b)) {

				slt = db.deleteBoard(conn, b);

				JDBCTemplate.commitOrRollback(conn, slt);

				view.printTCResult(slt, "게시글 삭제");

			} else {
				view.printMsg("작성자만 삭제가 가능합니다.");
			}

		} else {
			view.printMsg("게시물 번호를 확인하세요.");
		}

		JDBCTemplate.close(conn);

	}

	public boolean checkWriter(Member m, Board b) {

		if (m.getMemberId().equals(b.getBoardWriter())) {
			return true;
		}
		return false;
	}

}
