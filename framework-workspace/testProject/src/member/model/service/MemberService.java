package member.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Check;
import member.model.vo.Member;
import member.model.vo.MemberData;
import member.model.vo.Search;

public class MemberService {

	public Member selectOneMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();

		Member member = new MemberDao().selectOneMember(session, m);

		session.close();
		return member;
	}

	public int insertMember(Member m) {

		SqlSession session = SqlSessionTemplate.getSqlSession();

		int result = new MemberDao().insertMember(session, m);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public ArrayList<Member> selectAllMember() {

		SqlSession session = SqlSessionTemplate.getSqlSession();

		List list = new MemberDao().selectAllMember(session);

		session.close();

		return (ArrayList<Member>) list;
	}

	public int updateMember(Member m) {

		SqlSession session = SqlSessionTemplate.getSqlSession();

		int result = new MemberDao().updateMember(session, m);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public int deleteMember(String memberId) {

		SqlSession session = SqlSessionTemplate.getSqlSession();

		int result = new MemberDao().deleteMember(session, memberId);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public MemberData selectAllMemberPage(int reqPage) {

		// 한 페이지당 게시물 수 numPerPage -> 개발자지정
		// 총 게시물 수 totalCount -> DB 조회
		// 해당 페이지의 게시물 시작번호, 끝번호 start,end -> totalPage, reqPage로 계산
		// 페이징 길이 pageNaviSize -> 개발자 지정

		SqlSession session = SqlSessionTemplate.getSqlSession();

		int totalCount = new MemberDao().totalCount(session);

		int numPerPage = 5;
		int totalPage = 0;

		// 페이지 수 연산

		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = (totalCount / numPerPage) + 1;
		}

		// 조회해올 게시물 시작번호와 끝번호 조회
		// 시작번호
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);

		List list = new MemberDao().selectAllMemberPage(session, map);

		// 페이지 네비게이션 작성

		StringBuffer pageNavi = new StringBuffer();

		// 페이지 네비 길이
		int pageNaviSize = 3;

		// 페이지 네비 시작번호 연산
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		if (pageNo != 1) {
			pageNavi.append("<a href='/allMemberPage?reqPage=" + (pageNo - 1) + "'>[이전]</a>");
		}

		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a href='/allMemberPage?reqPage=" + pageNo + "'>" + pageNo + "</a>");
			}
			pageNo++;

			if (pageNo > totalPage) {
				break;
			}
		}

		if (pageNo <= totalPage) {
			pageNavi.append("<a href='allMemberPage?reqPage=" + pageNo + "'>다음</a>");
		}

		session.close();

		return new MemberData((ArrayList<Member>) list, pageNavi.toString());
	}

	public ArrayList<Member> memberInfo(Check ck) {

		SqlSession session = SqlSessionTemplate.getSqlSession();

		List list = new MemberDao().memberInfo(session, ck);

		session.close();

		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> search(Search search) {
		SqlSession session = SqlSessionTemplate.getSqlSession();

		List list = new MemberDao().search(session, search);
		session.close();
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> search(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();

		List list = new MemberDao().search(session, m);
		session.close();
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> search(String[] memberId) {

		SqlSession session = SqlSessionTemplate.getSqlSession();

		List list = new MemberDao().search(session, memberId);
		session.close();

		return (ArrayList<Member>) list;
	}

}
