package com.younggambyeon.sample.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.younggambyeon.sample.component.ResourceComponent;
import com.younggambyeon.sample.service.RedisService;

public class SpringTextWebSocketHandler extends TextWebSocketHandler {

	@Autowired
	private RedisService redisService;

	@Autowired
	private ResourceComponent resourceComponent;

	/*
	 * @Override public void handleTextMessage(WebSocketSession session,
	 * TextMessage message) throws IOException { String sessionId = (String)
	 * session.getAttributes().get("sessionId"); String username = (String)
	 * session.getAttributes().get("username");
	 * 
	 * String webSocketSessionId = session.getId();
	 * 
	 * System.out.println("websocket SessionId : " + webSocketSessionId);
	 * 
	 * System.out.println("로그인 한 아이디 : " + username);
	 * 
	 * session.sendMessage(new TextMessage("sessionId : " + sessionId +
	 * " username : " + username)); }
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("클라이언트 접속됨");

		Map<String, Object> map = session.getAttributes();
		String username = (String) map.get("username");
		String url = (String) map.get("path");

		redisService.setValue(username, url);
		resourceComponent.getwSessionMap().put(username, session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		System.out.println("클라이언트 접속해제");

		Map<String, Object> map = session.getAttributes();
		String username = (String) map.get("username");

		redisService.deleteKey(username);
		resourceComponent.getwSessionMap().remove(username);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
		System.out.println("전송오류 발생");
	}

}
