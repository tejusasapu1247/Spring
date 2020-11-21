package com.beanfactoryPP;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Foo {
	@Value("1")
	private int id;
	@Value("foo Vale!!!")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("..............");
		System.out.println("init for foo");
		System.out.println("...............");
	}
	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + "]";
	}
	@PreDestroy
	public void destory() {
		System.out.println("called before the destroying the foo");
	}
	
	
	
}
