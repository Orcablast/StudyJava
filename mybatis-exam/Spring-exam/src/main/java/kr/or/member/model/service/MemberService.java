package kr.or.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service("memberService")
public class MemberService {

	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;

	public int insertMember(Member m) {		
		return dao.insertMember(m);
	}

	public Member selectOneMember(Member m) {
		return dao.selectOneMember(m);
	}
	
}
