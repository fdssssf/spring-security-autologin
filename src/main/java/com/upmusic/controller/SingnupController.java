package com.upmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.upmusic.entity.User;
import com.upmusic.service.SecurityService;
import com.upmusic.service.UserService;

@Controller
public class SingnupController {
	@Autowired
	UserService userService ;
	@Autowired
	SecurityService securityService ;
	
    @GetMapping(value="/register")
	public String add(Model mm) {
    	mm.addAttribute("user", new User());
		return "singup";
	}

    @PostMapping(value="/register")
	public String add(@ModelAttribute("user") User user) {
    	userService.save(user);
    	securityService.autoLoggin(user.getUsername(), user.getPassword());
		return "redirect:/wellcome";
	}
    
}
