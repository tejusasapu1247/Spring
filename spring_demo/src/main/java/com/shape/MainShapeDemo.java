package com.shape;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainShapeDemo {

	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("pointbean.xml");
		Shape shape=(Shape) c.getBean("shape");
		shape.printPointDetails();
		
	}

}
