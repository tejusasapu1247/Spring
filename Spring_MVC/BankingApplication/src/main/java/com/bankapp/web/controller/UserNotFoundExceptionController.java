package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.exceptions.UserNotFoundException;
@ControllerAdvice
public class UserNotFoundExceptionController {

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView ExceptionHandler(Exception ex,HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("usertNotFound");
		mv.addObject("key",ex.getMessage());
		return mv;
	}
	
}
