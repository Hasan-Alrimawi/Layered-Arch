package com.jpa.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InMemoryDetailsService implements UserDetailsService {
	private final List<UserDetails> users;

	public InMemoryDetailsService(List<UserDetails> users) {
		this.users = users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("************************** LOADED BY USER NAME **************************");
		return users.stream().filter(u -> u.getUsername().equals(username)).findFirst()
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

}
