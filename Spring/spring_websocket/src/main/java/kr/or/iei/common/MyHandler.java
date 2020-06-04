package kr.or.iei.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Component("myHandler")
public class MyHandler extends TextWebSocketHandler {
	private ArrayList<WebSocketSession> members;
	private HashMap<String, WebSocketSession> map;
	
	public MyHandler() {
		members = new ArrayList<WebSocketSession>();
		map = new HashMap<String, WebSocketSession>();
	}
	
	// 소켓이 생성되어 연결되었을때 실행되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결 성공!!");
		members.add(session);
	}
	
	
	// 메세지를 수신하면 동작하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message.getPayload());
		String type = element.getAsJsonObject().get("type").getAsString();
		
		if(type.equals("register")) {
			String memberId = element.getAsJsonObject().get("memberId").getAsString();
			map.put(memberId, session);
		} else {
			String target = element.getAsJsonObject().get("target").getAsString();
			String msg = element.getAsJsonObject().get("msg").getAsString();
			WebSocketSession ws = map.get(target);
			if(ws != null) {
				ws.sendMessage(new TextMessage(msg));
			}
		}
	}
	
	// 연결이 끊기면 동작하는 메소드 
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 종료!!");
		members.remove(session);
	}	
}
