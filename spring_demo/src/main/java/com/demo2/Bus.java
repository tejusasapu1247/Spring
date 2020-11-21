package com.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Bus implements Vehicle{
	@Value("RedBus")
	String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void move() {
		System.out.println("Moving in a "+name);
	}

}
