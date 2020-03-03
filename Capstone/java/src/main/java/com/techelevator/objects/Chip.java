package com.techelevator.objects;

import java.math.BigDecimal;

public class Chip extends VendingItem {

	public Chip(String name, BigDecimal price) {
		super(name, price);
		
	}
	
	@Override
	public String getNoise() {
		return "Crunch Crunch, Yum!";
	}

}
