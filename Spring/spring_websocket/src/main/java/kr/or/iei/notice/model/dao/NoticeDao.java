package kr.or.iei.notice.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.iei.notice.model.vo.Notice;

@Repository("noticeDao")
public class NoticeDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public int insertNotice(Notice n) {
		
		return session.insert("notice.insertNotice",n);
	}

	public int countNotice() {
		return session.selectOne("notice.countNotice");
	}

	public List selectNoticeList(HashMap<String, Integer> map) {
		return session.selectList("notice.selectNoticeList", map);
	}

	public Notice selectOneNotice(Notice n) {
		return session.selectOne("notice.selectOneNotice", n);
	}

	public int deleteNotice(Notice n) {
		return session.delete("notice.deleteNotice",n);
	}

	public int updateNotice(Notice n) {
		return session.update("notice.updateNotice", n);
	}

}
