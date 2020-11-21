package com.demo;

	public class CeatTyre implements Tyre{
	   private double price;
	   
	   public void setPrice(double price) {
		   this.price=price;
	   }
	 
	   public void rotate() {
		System.out.println("rotating...by Ceat with,the price is : "+price);
		
	}
	   
	   
	}
