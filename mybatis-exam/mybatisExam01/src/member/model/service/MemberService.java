package member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public int insertMember(Member m) {
		
		SqlSession session = SqlSessionTemplate.getSqlSessioon();
		
		int result = new MemberDao().insertMember(session,m);
		
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public Member selectOneMember(Member m) {
		
		SqlSession session = SqlSessionTemplate.getSqlSessioon();
		
		Member member = new MemberDao().selectOneMember(session, m);
		
		session.close();
		
		return member;
	}

}
