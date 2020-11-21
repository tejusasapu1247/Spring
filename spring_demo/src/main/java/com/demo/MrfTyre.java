package com.demo;

public class MrfTyre implements Tyre{
   private double price;
   
   public void setPrice(double price) {
	   this.price=price;
   }
 
   public void rotate() {
	System.out.println("rotating...by mrf with,the price is : "+price);
	
}
   
   
}
