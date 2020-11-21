package com.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="p")
public class Person {
	@Value("teju")
	private String name;
	@Autowired
	private Vehicle vehical;
//
//	public Person(String name, Vehicle vehical) {
//		this.name = name;
//		this.vehical = vehical;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehical() {
		return vehical;
	}

	public void setVehical(Vehicle vehical) {
		this.vehical = vehical;
	}

	public void travel() {
		System.out.println("My name is :" + name);
		vehical.move();
	}
}
