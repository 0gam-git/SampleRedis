package com.younggambyeon.sample.Listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

public class EventListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());
		System.out.println(headerAccessor.getSessionAttributes().get("sessionId").toString());
	}*/

}
