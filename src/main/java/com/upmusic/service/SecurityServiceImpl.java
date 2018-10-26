package com.upmusic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired(required=true)
	private AuthenticationManager authenticationManager;
	@Autowired
	UserDetailsService userDetailsService;
	private static final Logger logger=LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Override
	public String findLoggerInusername() {
		Object userDetails=SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}
		return null;
	}

	@Override
	public void autoLoggin(String usename, String password) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(usename);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
		=new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());
         authenticationManager.authenticate(usernamePasswordAuthenticationToken);
         if (usernamePasswordAuthenticationToken.isAuthenticated()) {
		 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		 logger.debug("autologin successfully!",usename);
		}
	}

}
