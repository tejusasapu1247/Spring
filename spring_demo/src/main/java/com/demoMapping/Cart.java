package com.demoMapping;

import java.util.Map;

public class Cart {
private String cartHolderName;
private Map<Integer,Product> products;

public String getCartHolderName() {
	return cartHolderName;
}

public void setCartHolderName(String cartHolderName) {
	this.cartHolderName = cartHolderName;
}



public Map<Integer, Product> getProducts() {
	return products;
}



public void setProducts(Map<Integer, Product> products) {
	this.products = products;
}



public void print() {
	products.forEach((i,p)->System.out.println(i + " : " +p));
}
}
