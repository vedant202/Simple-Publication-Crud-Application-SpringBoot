package com.Publication.Publication.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Publication.Publication.Model.UserPublications;

public class CustomUsers implements UserDetails {
	private UserPublications userPublications;

	public CustomUsers(UserPublications userPublications) {
		// TODO Auto-generated constructor stub
		this.userPublications = userPublications;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userPublications.getRole());

		return List.of(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userPublications.getPass();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userPublications.getEmail();
	}

}
