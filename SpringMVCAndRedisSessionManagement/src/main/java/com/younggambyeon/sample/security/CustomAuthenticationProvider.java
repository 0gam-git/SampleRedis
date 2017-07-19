package com.younggambyeon.sample.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		return super.authenticate(arg0);
	}
}
