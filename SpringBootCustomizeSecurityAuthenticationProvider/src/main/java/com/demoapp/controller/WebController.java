package com.demoapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping(value={"/","home"})
	public String home(){
		return "home";
	}
	
	@RequestMapping(value={"/welcome"})
	public String welcome(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(principal);
		return "welcome";
	}

	@RequestMapping(value="/admin")
	public String admin(){
		return "admin";
	}
	
	@RequestMapping(value={"/login"})
	public String login(){
		return "login";
	}
	
	
	@RequestMapping(value="/403")
	public String Error403(){
		return "403";
	}
}
