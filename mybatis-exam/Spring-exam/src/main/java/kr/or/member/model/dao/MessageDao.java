package kr.or.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.DirectMsg;

@Repository(value = "messageDao")
public class MessageDao {
	
	@Autowired
	private SqlSessionTemplate session;

	public int insertMsg(DirectMsg msg) {
		return session.insert("message.insertMsg",msg);
	}

	public int selectMsgChkCount(String msgReceiver) {
		return session.selectOne("message.selectMsgChkCount",msgReceiver);
	}
	
}
