package com.bankapp.dao.exceptions;

public class AccountNotFoundException extends RuntimeException{

	public AccountNotFoundException(String string) {
		super(string);
	}

}
