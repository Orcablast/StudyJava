package kr.or.iei.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.iei.common.LogAdvice;
import kr.or.iei.common.SHA256Util;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

@Service("memberService")
public class MemberService {

	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;

	public MemberService() {
		super();
		System.out.println("멤바서비스 생성");
	}

	public Member selectOneMember(Member m){
		return dao.selectOneMember(m);
	}

	@Transactional
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	@Transactional
	public int updateMember(Member m) {
		return dao.updateMember(m);
	}

	public int deleteMember(Member m) {
		return dao.deletMember(m);
	}

	public int checkId(String memberId) {
				
		return dao.checkId(memberId);
	}

	public ArrayList<Member> selectAllMember() {
		List list = dao.selectAllMember();
		
		return (ArrayList<Member>)list;
	}

}
