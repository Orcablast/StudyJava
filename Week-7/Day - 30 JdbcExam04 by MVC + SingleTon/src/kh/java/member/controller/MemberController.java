package kh.java.member.controller;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.java.member.dao.MemberDao;
import kh.java.member.view.MemberView;
import kh.java.member.vo.Member;

public class MemberController {

	MemberView mv = new MemberView();
	MemberDao md = new MemberDao();
	
	public void main() {
		while (true) {
			int slt = mv.mainMenu();

			switch (slt) {
			case 1: // 회원 전체 출력
				printAll();
				break;

			case 2: // 회원 ID로 검색
				printMbr("조회할 ID : ");
				break;

			case 3: // 회원 이름으로 검색
				printMbr("조회할 회원명 : ");
				break;

			case 4: // 회원 가입
				insertMbr();
				break;

			case 5: // 회원 정보 수정
				modifyMbr();
				break;

			case 6: // 회원 삭제
				deleteMbr();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("0~6 사이의 수를 입력하세요.");
				break;
			}
		}
	}

	public void insertMbr() {
		
		Member m = mv.getMbrInfo();
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = md.insertMbr(m,conn);
		
		JDBCTemplate.commitOrRollback(result, conn);

		mv.printResult(result, "회원가입");
		
		JDBCTemplate.close(conn);
	}
	
	public void printAll() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> mbrs = md.getAllMbrs(conn);
		
		if(mbrs.isEmpty()) {
			mv.printMsg("회원이 존재하지 않습니다.");
		} else {
			
			mv.printColumns();
			
			for(Member m : mbrs) {
				mv.printMsg(m.toString());
			}
		}
		JDBCTemplate.close(conn);
	}
	
	public void printMbr(String keyWord) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String key = mv.askKey(keyWord);
		
		ArrayList<Member> mbrs  = md.getMbr(keyWord,key,conn);
		
		if(mbrs.isEmpty()) {
			mv.printMsg("찾으시는 회원이 없습니다.");
			
		} else {
			mv.printColumns();
			for(Member m : mbrs) {
				mv.printMsg(m.toString());				
			}
		}		
		JDBCTemplate.close(conn);
	}
	
	public void deleteMbr() {
		
		String key = mv.askKey("삭제할 회원 ID : ");
		
		
		
		// 트랜잭션 작업을 위해서 Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// MEMBER 테이블에서 해당하는 ROW를 삭제
		int result1 = md.deleteMbr(key, conn);
		int result2 = md.insertDelMbr(key, conn); 
		
		if(result1 > 0 && result2 > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
//		if(result1 > 0) {
//			// DEL_MEMBER 테이블에 추가
//			int result2 = md.insertDelMbr(key, conn); 
//			
//			if(result2 > 0) {
//				JDBCTemplate.commit(conn);
//				
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
//			
//			mv.printResult(result2, "회원 삭제");			
//		} else {
//			JDBCTemplate.rollback(conn);
//		}
		
		JDBCTemplate.close(conn);
		
	}

	public void modifyMbr() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String key = mv.askKey("수정할 회원 ID : ");
		
		ArrayList<Member> mbrs = md.getMbr("ID", key, conn);
		
		Member m = null;
		
		if(mbrs.isEmpty()) {
			System.out.println("해당하는 회원이 없습니다.");
			
		} else {
			m = mv.getModInfo(mbrs.get(0));
			
			m.setMemberId(key);
			
			int result = md.modifyMbr(m,conn);
			
			JDBCTemplate.commitOrRollback(result, conn);
			
			mv.printResult(result, "수정");
						
		}
		
		JDBCTemplate.close(conn);
	}
}
