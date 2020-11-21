package com.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Metro implements Vehicle{
	@Value("metro")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void move() {
		System.out.println("Hello..Moving in a Metro....");
		
	}

}
