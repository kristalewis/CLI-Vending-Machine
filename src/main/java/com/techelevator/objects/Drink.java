package com.techelevator.objects;

import java.math.BigDecimal;

public class Drink extends VendingItem {


	public Drink(String name, BigDecimal price) {
		super(name, price);
		
	}
	
	@Override
	public String getNoise() {
		return "Glug Glug, Yum!";
	}

}
