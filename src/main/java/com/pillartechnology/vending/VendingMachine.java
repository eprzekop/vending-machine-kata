package com.pillartechnology.vending;

public class VendingMachine {

	private String display;
	private CoinAcceptor acceptor;
	private int moneyIn = 0;

	public VendingMachine() {
		display = new String();
		acceptor = new CoinAcceptor();
	}

	public void insertMoney(Coin coin) {
		if (acceptor.receiveCoin(coin)) {
			moneyIn += coin.value;
			display = "Total inserted: " + Integer.toString(moneyIn);
		} else {
			rejectCoin(coin);
		}

	}

	private void rejectCoin(Coin coin) {
		// Would tell the hardware to spit the coin out
	}

	public String getDisplay() {
		return display;
	}

}
