package com.ishan.security.demo.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.ishan.security.demo.domain.User;

public class CustomUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = -3079896714970913691L;

	public CustomUserDetails() {
		
	}
	public CustomUserDetails(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
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

}
