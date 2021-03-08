package com.bankapp.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@GetMapping("/")
	public ModelAndView entry() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}
	
}
	
	
