package kr.or.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kr.or.member.model.service.MessageService;
import kr.or.member.model.vo.DirectMsg;

@Component(value = "msgHandler")
public class MsgHandler extends TextWebSocketHandler {
	private ArrayList<WebSocketSession> members;
	private HashMap<String, WebSocketSession> map;

	@Autowired
	@Qualifier("messageService")
	private MessageService service;

	public MsgHandler() {
		members = new ArrayList<WebSocketSession>();
		map = new HashMap<String, WebSocketSession>();
	}

	// 소켓 생성시
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("메시지 웹소켓 생성");
		members.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		System.out.println(message.getPayload());
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message.getPayload());
		String type = element.getAsJsonObject().get("type").getAsString();

		if (type.equals("msg")) {
			String msgContent = element.getAsJsonObject().get("msgContent").getAsString();
			String msgSender = element.getAsJsonObject().get("msgSender").getAsString();
			String msgReceiver = element.getAsJsonObject().get("msgReceiver").getAsString();

			DirectMsg msg = new DirectMsg();
			msg.setMsgReceiver(msgReceiver);
			msg.setMsgSender(msgSender);
			msg.setMsgContent(msgContent);

			int result = service.insertMsg(msg);

			if (result > 0) {
				int msgCount = service.selectMsgChkCount(msgReceiver);

				WebSocketSession ws = map.get(msgReceiver);

				if (ws != null) {
					ws.sendMessage(new TextMessage(String.valueOf(msgCount)));
				}
			} 
		}else if (type.equals("register")) {
			String memberId = element.getAsJsonObject().get("memberId").getAsString();
			map.put(memberId, session);
			
			System.out.println("["+memberId+"] 님의 웹소켓 세션 연결 완료");
			
			int msgCount = service.selectMsgChkCount(memberId);
			System.out.println("카운트 : " + msgCount);
			WebSocketSession ws = map.get(memberId);

			if (ws != null) {
				System.out.println("ws 전송 진행");
				ws.sendMessage(new TextMessage(String.valueOf(msgCount)));
			}
			
		} else if (type.equals("exit")) {
			String memberId = element.getAsJsonObject().get("memberId").getAsString();
			map.remove(memberId);				
			System.out.println("["+memberId+"] 님의 웹소켓 세션 제거 완료");
		}
	}

	// 소켓 연결 종료시
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("메시지 웹소켓 해제");
		members.remove(session);
	}
}
