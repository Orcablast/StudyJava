package kh.java.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.java.member.dao.MemberDao;
import kh.java.member.vo.Member;

public class MemberService {

	MemberDao dao = new MemberDao();
	
	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.insertMember(conn,m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result ;
	}

	public ArrayList<Member> selectAll() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = dao.selectAll(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}

	public Member searchMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		m = dao.searchMember(conn, m);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	public int modifyMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.modifyMember(conn,m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
				
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.deleteMember(conn,m);
		
		if(result > 0) {
			
			result = dao.addDelMember(conn,m);
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
				
			} else {
				JDBCTemplate.rollback(conn);
			}
			
			
		} else {
			JDBCTemplate.rollback(conn);			
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}	
}
