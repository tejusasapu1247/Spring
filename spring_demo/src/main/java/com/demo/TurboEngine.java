package com.demo;

	public class TurboEngine implements Engine {
	    private String brand;
	    private double HorsePower;
		public void setBrand(String brand) {
			this.brand=brand;
		}

		public void setHorsePower(double HorsePower) {
			this.HorsePower=HorsePower;
		}

		public void move() {
		System.out.println("this is car powered bt TE of brand :"+brand+ " with Horse Power : "+HorsePower);
		}

	}
