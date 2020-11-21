package com.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo implements InitializingBean,DisposableBean {
	private String fooValue;

	public Foo() {
		System.out.println("Foo ctr is called..");
	}
	
	public void setFooValue(String fooValue) {
		System.out.println("Foo setter method is called..");
		this.fooValue = fooValue;
	}
	@PostConstruct
	public void initAnnotation() {
		System.out.println("init of annotation version..");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean after property set method is called..");
	}
	public void xmlInit() {
		System.out.println("xml init is called..");
	}
	
	@Override
	public String toString() {
		return "Foo [Value of Foo = " + fooValue + "]";
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy of DisposableBean is called..");
	}
	
	public void xmlDestroy() {
		System.out.println("xml destory method is called..");
	}
	@PreDestroy
	public void  annoDestroy() {
		System.out.println("annotation destroy is called..");
	}

}
