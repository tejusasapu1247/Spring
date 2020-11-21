package com.bankapp.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		//ApplicationContext cnt= new ClassPathXmlApplicationContext("bean.xml");
		AbstractApplicationContext cnt= new ClassPathXmlApplicationContext("bean.xml");
		AccountService as=(AccountService) cnt.getBean("accountService");
		System.out.println("....getting all accounts...");
		as.getAllAccounts().forEach(System.out::println);
		System.out.println("....getting by id...");
		System.out.println( as.findAccountById(2));  
		System.out.println("....after transferring...");
		as.transfer(1, 2, 300);
		as.getAllAccounts().forEach(System.out::println);
	}

}
