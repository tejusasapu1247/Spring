package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@GetMapping("hello")
	public ModelAndView hello() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("key", "hello to spring mvc");
		return mv;
}
}
