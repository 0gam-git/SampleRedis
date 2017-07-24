package com.younggambyeon.sample.repository;

import org.springframework.session.Session;
import org.springframework.stereotype.Repository;

public interface SessionRepository<S extends Session> {

	S createSession();

	void save(S session);

	S getSession(String id);

	void delete(String id);
}
