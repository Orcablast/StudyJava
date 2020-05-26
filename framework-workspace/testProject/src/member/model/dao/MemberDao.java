package member.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Check;
import member.model.vo.Member;
import member.model.vo.Search;

public class MemberDao {

	public Member selectOneMember(SqlSession session, Member m) {
				
		return session.selectOne("member.selectOneMember",m);
	}

	public int insertMember(SqlSession session, Member m) {
		return session.insert("member.insertMember",m);
	}

	public List selectAllMember(SqlSession session) {
		return session.selectList("member.selectAllMember");
	}

	public int updateMember(SqlSession session, Member m) {
				
		return session.update("member.updateMember",m);
	}

	public int deleteMember(SqlSession session, String memberId) {
		return session.delete("member.deleteMember", memberId);
	}

	public int totalCount(SqlSession session) {
		
		return session.selectOne("member.totalCount");
	}

	public List selectAllMemberPage(SqlSession session, HashMap<String, Integer> map) {

		return session.selectList("member.allMemberListPage",map);
	}

	public List memberInfo(SqlSession session, Check ck) {
		// 
		return session.selectList("member.memberInfo",ck);
	}

	public List search(SqlSession session, Search search) {
		
		return session.selectList("member.search",search);
	}

	public List search(SqlSession session, Member m) {
		return session.selectList("member.search2",m);
	}

	public List search(SqlSession session, String[] memberId) {
		return session.selectList("member.search3",memberId);
	}

}
