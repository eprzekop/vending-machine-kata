package com.pillartechnology.vending;

public enum Product {
	COLA(100), CHIPS(50), CANDY(65);

	final int price;

	Product(int price) {
		this.price = price;
	}
}
