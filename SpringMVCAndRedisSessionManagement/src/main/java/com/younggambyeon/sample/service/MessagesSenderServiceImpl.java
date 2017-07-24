package com.younggambyeon.sample.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.younggambyeon.sample.component.ResourceComponent;

@Service
public class MessagesSenderServiceImpl implements MessagesSenderService {

	@Autowired
	private RedisService redisService;

	@Autowired
	private ResourceComponent resourceComponent;

	@Override
	public void send(String username, String message) throws IOException {
		WebSocketSession wSession = resourceComponent.getwSessionMap().get(username);

		wSession.sendMessage(new TextMessage("username : " + username + " = msg : " + message));

	}

}
