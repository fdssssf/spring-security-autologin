package com.upmusic.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import com.upmusic.entity.User;
import com.upmusic.service.UserService;

public abstract class AbstracstController {
	@Autowired
	UserService userService;
	protected User getCrentUser(Principal principal ) {
		if (principal!=null) {
			userService.findByUsername(principal.getName());
		}
		return null;
	}

}
