package com.beanfactoryPP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("bfpp.xml");
		AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("bfpp.xml");
		Foo foo=ctx.getBean("foo",Foo.class);
		System.out.println(foo);
		ctx.registerShutdownHook();
		
	}

}
