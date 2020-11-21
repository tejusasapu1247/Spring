package com.lifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleMain {

	public static void main(String[] args) {
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("life.xml");
		AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("life.xml");
		Foo foo=ctx.getBean("foo",Foo.class);
		System.out.println(foo);
		ctx.registerShutdownHook();
		

		
	}

}
