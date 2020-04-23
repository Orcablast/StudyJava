package kh.java.member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import kh.java.member.model.dao.MemberDao;
import kh.java.member.model.vo.Member;

public class MemberService {

	public Member selectOneMember(Member login) {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		
		Member m = dao.selectOneMember(conn, login);	
		
		JDBCTemplate.close(conn);		
		
		return m;
	}

	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		
		int result = dao.insertMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}		
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
