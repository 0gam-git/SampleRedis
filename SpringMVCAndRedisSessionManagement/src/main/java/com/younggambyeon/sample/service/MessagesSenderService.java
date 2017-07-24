package com.younggambyeon.sample.service;

import java.io.IOException;

public interface MessagesSenderService {

	public void send(String username, String message) throws IOException;
}
