package com.bfpp.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAccount {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("account.xml");
		Account account=ctx.getBean("account",Account.class);
		System.out.println(account);
	}

}
