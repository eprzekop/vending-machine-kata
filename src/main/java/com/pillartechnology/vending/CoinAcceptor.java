package com.pillartechnology.vending;

public class CoinAcceptor {

	public boolean receiveCoin(Coin coin) {
		if (coin == Coin.PENNY) {
			return false;
		} else {
			return true;
		}
	}

}
