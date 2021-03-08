package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView error404(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("404");
		return mv;	
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView dataAccessError(HttpServletRequest req,Exception ex){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("dataAccessError");
		mv.addObject("error", ex.getMessage());
		return mv;	
	}
	
	
	
}
