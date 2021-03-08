package com.bookApplication.model.dao;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7987843341769026869L;

	public BookNotFoundException(String message) {
		super(message);
		
	}

}
