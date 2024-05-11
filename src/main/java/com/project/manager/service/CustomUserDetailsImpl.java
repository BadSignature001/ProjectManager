package com.project.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.manager.modal.User;
import com.project.manager.repository.UserRepository;

@Service
public class CustomUserDetailsImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository ;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username) ;
		
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found with this email" +user) ;
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>() ;
		
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
