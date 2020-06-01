package kr.or.iei.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

	public Member selectOneMember(Member m) {

		return dao.selectOneMember(m);
	}
//
//	public int insertMember(Member m) {
//		
//		return dao.insertMember(m);
//	}
//
//	public int updateMember(Member m) {
//		return dao.updateMember(m);
//	}
//
//	public int deleteMember(Member m) {		
//		return dao.deletMember(m);
//	}
//
//	public Member checkId(String memberId) {
//		
//		List list = dao.checkId(memberId);
//		
//		Member member = null;
//		
//		if(!list.isEmpty()) {
//			member = (Member)list.get(0);
//		}
//		
//		return member;
//	}
//
//	public ArrayList<Member> selectAllMember() {
//		
//		List list = dao.selectAllMember();
//		
//		return (ArrayList<Member>)list;
//	}

}
