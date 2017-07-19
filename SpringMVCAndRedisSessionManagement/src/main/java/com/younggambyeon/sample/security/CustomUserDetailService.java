package com.younggambyeon.sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.younggambyeon.sample.vo.Account;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetail customUserDetail = new CustomUserDetail();

		// if used database. username validation .

		// default settings.
		String password = "sample12";
		password = passwordEncoder.encode(password);

		Account account = new Account(username, password);
		customUserDetail.setAccount(account);

		return customUserDetail;
	}

}
