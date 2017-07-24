package com.younggambyeon.sample.service;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.MapSession;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Override
	public void testConvertAndSend(String channel, String message) {
		redisTemplate.convertAndSend(channel, message);
	}

	@Override
	public void addList(String userId, URL url) {
		listOps.leftPush(userId, url.toExternalForm());
	}

	@Override
	public Object getValue(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void setValue(String key, String value) {
		redisTemplate.opsForValue().set(key, value);

		// set a expire for a message
		redisTemplate.expire(key, 30, TimeUnit.MINUTES);
	}

	@Override
	public void deleteKey(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void test(String key) {
		List<Object> result = null;

		List<Object> list = redisTemplate.opsForHash()
				.multiGet("spring:session:sessions:1e231cd2-64ee-46ea-b9a4-edda2abd5a95", result);

		for (Object object : list) {
			
		}
		
		System.out.println("!");
	}
}
