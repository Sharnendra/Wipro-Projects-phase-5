package com.javatechie.spring.security.api.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/rest/auth")
public class EmployeeController {

	
	@RequestMapping("/welcome")
	public ModelAndView firstPage(@SuppressWarnings("deprecation") @AuthenticationPrincipal final UserDetails userDetails) {
		userDetails.getAuthorities().stream().forEach(x->System.err.println("value "+x));
		System.err.println("welcome "+userDetails.getUsername());
		return new ModelAndView("welcome","name", userDetails.getUsername());
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", null);
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest() {
		
		ModelAndView model = new ModelAndView("getEmployees");
		//model.addObject("employees", null);
		return model;
	}

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		
		ModelAndView model = new ModelAndView("getEmployees");
		//model.addObject("employees", null);
		return model;
	}
	
	@GetMapping("/processor")
	public String processor() {
		return "processing..";
	}

}
