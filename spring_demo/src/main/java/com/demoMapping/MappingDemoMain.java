package com.demoMapping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MappingDemoMain {

	public static void main(String[] args) {
		ApplicationContext ct=new ClassPathXmlApplicationContext("mapping.xml");
		Cart cart=(Cart) ct.getBean("cart");
		cart.print();
	}

}
