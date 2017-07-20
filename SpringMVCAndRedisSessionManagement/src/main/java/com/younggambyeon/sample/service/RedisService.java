package com.younggambyeon.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void test() {

		redisTemplate.convertAndSend("channel", "message ~~~");

	}
}
