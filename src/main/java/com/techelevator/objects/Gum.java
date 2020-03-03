package com.techelevator.objects;

import java.math.BigDecimal;

public class Gum extends VendingItem {


	public Gum(String name, BigDecimal price) {
		super(name, price);
	}
	
	@Override
	public String getNoise() {
		return "Chew Chew, Yum!";
	}

}
