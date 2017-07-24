package com.younggambyeon.sample.component;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ResourceComponent {

	private ConcurrentHashMap<String, WebSocketSession> wSessionMap;

	public ResourceComponent() {
		this.wSessionMap = new ConcurrentHashMap<String, WebSocketSession>();
	}

	public ConcurrentHashMap<String, WebSocketSession> getwSessionMap() {
		return wSessionMap;
	}

}
