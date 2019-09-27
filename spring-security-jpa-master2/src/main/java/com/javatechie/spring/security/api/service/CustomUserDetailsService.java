package com.javatechie.spring.security.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javatechie.spring.security.api.model.LoginInfoMaster;
import com.javatechie.spring.security.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginInfoMaster user = repository.findByUsername(username);
		CustomUserAuthentication userDetails = null;
		if (user != null) {
			userDetails = new CustomUserAuthentication();
			userDetails.setUser(user);
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return userDetails;

	}

}
