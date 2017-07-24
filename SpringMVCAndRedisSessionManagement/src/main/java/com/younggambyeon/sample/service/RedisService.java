package com.younggambyeon.sample.service;

import java.net.URL;

public interface RedisService {

	public void testConvertAndSend(String channel, String message);

	public void addList(String userId, URL url);

	public Object getValue(String key);

	public void setValue(String key, String value);

	public void deleteKey(String key);

	public void test(String key);
}
