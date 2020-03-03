package com.techelevator.objects;

import java.math.BigDecimal;

public class Candy extends VendingItem {


	public Candy(String name, BigDecimal price) {
		super(name, price);
	}
	
	@Override
	public String getNoise() {
		return "Munch Munch, Yum!";
	}

}
