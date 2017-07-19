package com.younggambyeon.sample.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.younggambyeon.sample.vo.Account;

public class CustomUserDetail implements UserDetails {

	private Account account;

	public CustomUserDetail() {
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return authorities;
	}

	@Override
	public String getPassword() {
		return this.account.getPassword();
	}

	@Override
	public String getUsername() {
		return this.account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
