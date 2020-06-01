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

//	public int insertMember(Member m) {
//		
//		String query = "insert into member values(member_seq.nextval, ?, ?, ?, ?, sysdate)";
//		
//		Object[] params = {m.getMemberId(), m.getMemberPw(), m.getMemberName(), m.getAge()};
//		
//		return jdbcTemplate.update(query, params);
//	}
//
//	public int updateMember(Member m) {
//		
//		String query = "update member set member_pw = ?, member_name = ?, age = ? where member_id = ?";
//		
//		Object[] params = {m.getMemberPw(), m.getMemberName(), m.getAge(), m.getMemberId()};
//		
//		return jdbcTemplate.update(query, params);
//	}
//
//	public int deletMember(Member m) {
//		
//		String query = "delete from member where member_id = ?";		
//		
//		return jdbcTemplate.update(query, m.getMemberId());
//	}
//
//	public List checkId(String memberId) {
//
//		String query = "select * from member where member_id = ?";
//		Object[] params = {memberId};
//		
//		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
//		
//		return list;
//	}
//
//	public List selectAllMember() {
//		String query = "select * from member";
//		
//		List list = jdbcTemplate.query(query, new MemberRowMapper());
//		
//		return list;
//	}


	
	
}
