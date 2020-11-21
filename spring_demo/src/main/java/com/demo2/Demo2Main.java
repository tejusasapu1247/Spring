package com.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2Main {

	public static void main(String[] args) {
		ApplicationContext cntx=new ClassPathXmlApplicationContext("demo2.xml");
		Person person=cntx.getBean("p",Person.class);
		person.travel();
		person.getName();
		
		
	}

}
