package com.javatechie.spring.security.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

	private String targetUrl;

	@GetMapping("/process")
	public String process() {
		return "processing..";
	}
	
	@GetMapping(value = "/logout")
	public ModelAndView login(HttpServletRequest request) {
		targetUrl = "";
		HttpSession session = request.getSession(false);
		
		if(session!=null){
			targetUrl = "/login";
			System.err.println("done");
		}
		return new ModelAndView(targetUrl);

	}
}
