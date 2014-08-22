package com.pillartechnology.vending;

public enum Coin {
	PENNY(false, 0), NICKEL(true, 5), DIME(true, 10), QUARTER(true, 25);

	final boolean valid;
	final int value;

	Coin(boolean valid, int value) {
		this.valid = valid;
		this.value = value;
	}
}
