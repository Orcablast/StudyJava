package kr.or.iei.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.iei.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {

//	@Autowired
//	@Qualifier("jdbcTemplate")
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SqlSessionTemplate session;
	
	public MemberDao() {
		super();
		System.out.println("DAO 객체 생성");
	}

	public Member selectOneMember(Member m) {		
		return session.selectOne("member.selectOneMember",m);
	}

	public int insertMember(Member m) {
		return session.insert("member.insertMember", m);
	}

	public int updateMember(Member m) {
		
		return session.update("member.updateMember",m);
	}

	public int deletMember(Member m) {	
		
		return session.delete("member.deleteMember",m);
	}

	public int checkId(String memberId) {
		
		return session.selectOne("member.checkId",memberId);
	}

	public List selectAllMember() {
		
		return session.selectList("member.selectAllMember");
	}	
}
