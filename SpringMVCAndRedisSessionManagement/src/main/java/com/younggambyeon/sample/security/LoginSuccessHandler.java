package com.younggambyeon.sample.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.session.Session;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth)
			throws IOException, ServletException {

		HttpSession session = req.getSession();
		String currentUsername = auth.getName();

		// redisService.setValue(currentUsername, session.getId());

		String test = Session.class.getName();
		// PRINCIPAL_NAME_ATTRIBUTE_NAME
		session.setAttribute(Session.class.getName(), currentUsername);

		String contextPath = req.getContextPath();

		resp.sendRedirect(contextPath + "/home");
	}

}
