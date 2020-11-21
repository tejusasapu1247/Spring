package com.demo;

public class PowerEngine implements Engine {
    private String brand;
    private int HorsePower;
	public void setBrand(String brand) {
		this.brand=brand;
	}

	public void setHorsePower(int i) {
		this.HorsePower=HorsePower;
	}

	public void move() {
	System.out.println("thos is car powered bt PE of brand :"+brand+ " with Horse Power : "+HorsePower);
	}

}
