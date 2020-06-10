package kr.or.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MessageDao;
import kr.or.member.model.vo.DirectMsg;

@Service(value = "messageService")
public class MessageService {
	
	@Autowired
	@Qualifier("messageDao")
	private MessageDao dao;

	public int insertMsg(DirectMsg msg) {
		return dao.insertMsg(msg);
	}

	public int selectMsgChkCount(String msgReceiver) {
		return dao.selectMsgChkCount(msgReceiver);
	}
}
