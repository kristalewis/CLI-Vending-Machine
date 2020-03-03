package com.techelevator.objects;

import java.math.BigDecimal;


public abstract class VendingItem {
	
	private String name;
	private BigDecimal price;
	private int numOfItem = 5;
	private int numOfSales = 0;

	
	public VendingItem(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public int getNumOfSales() {
		return numOfSales;
	}
	
	public void setNumOfSales(int numOfSales) {
		this.numOfSales = numOfSales;
	}
	
	public void setNumOfItem(int numOfItem) {
		this.numOfItem = numOfItem;
	}
	
	public int getNumOfItem() {
		return numOfItem;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public abstract String getNoise();
	
}
