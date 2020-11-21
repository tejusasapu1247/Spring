package com.demo;

public class Car {
	private Tyre tyre;
	private Engine engine;
	private String pname;
	
	
	public Tyre getTyre() {
		return tyre;
	}
	public Engine getEngine() {
		return engine;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public void travel() {
		tyre.rotate();
		engine.move();
		System.out.println("travelling...");
	}
	
	
}
