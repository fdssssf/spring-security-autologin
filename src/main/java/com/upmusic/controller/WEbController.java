package com.upmusic.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WEbController extends AbstracstController {
	
    @GetMapping(value="/login")
	public String login(Model mm,String error,String logout) {
    	if (error!=null) {
			mm.addAttribute("error", " Your Username and password is invalid!");
		}
    	if(logout!=null) {
    	    mm.addAttribute("message", " Your Username and password is invalid!");
    	}
		return "login";
	}
    
    @GetMapping(value="/wellcome")
    public String info(Model model ){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("user", userService.findByUsername(auth.getName()));
    	return  "welcome";
    }
    
    @GetMapping(value="/error")
    public String info( ){
    	
    	return  "error";
    }
    @GetMapping(value="/logout")
    public String logout(){
    	
    	return  "redirect:/";
    }
}
