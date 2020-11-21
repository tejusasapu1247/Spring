package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args) {
		
		
		//configuration of spring:
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
		
		
		Car car=(Car) ctx.getBean("car");
		
		car.travel();
		
		System.out.println("car 1= :"+car.hashCode());
		System.out.println("engine of car 1= "+car.getEngine().hashCode());
		System.out.println("tyre of car 1= "+car.getTyre().hashCode());
		System.out.println("person of car 1 "+car.getPname());
		
		
		Car car2=(Car) ctx.getBean("car2");
		System.out.println("car 2= :"+car2.hashCode());
		System.out.println("engine of car 2= "+car2.getEngine().hashCode());
		System.out.println("tyre of car 2= "+car2.getTyre().hashCode());
		System.out.println("person of car 2 "+car2.getPname());
		
		
		
		//car.travel();
		
//		MrfTyre tyre=new MrfTyre();
//		tyre.setPrice(4000);
//		PowerEngine engine=new PowerEngine();
//		engine.setBrand("L and T");
//		engine.setHorsePower(3000);
//		
//		
//		Car car=new Car();
//		car.setEngine(engine);
//		car.setTyre(tyre);
//		car.travel();
	}

}
