package com.pillartechnology.vending;

public class VendingMachine {

	private static final String INSERT_COINS = "INSERT COINS";
	private static final String THANK_YOU = "THANK YOU";
	private static final String PRICE = "PRICE";
	private String display;
	private CoinAcceptor acceptor;
	private int moneyIn = 0;

	public VendingMachine() {
		display = INSERT_COINS;
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
		String returnValue = display;
		if (display.contains(PRICE)) {
			display = "Total inserted: " + Integer.toString(moneyIn);
		}
		if (display.contains(THANK_YOU)) {
			display = INSERT_COINS;
		}
		return returnValue;
	}

	public void selectProduct(Product product) {
		if (enoughMoney(product.price)) {
			display = THANK_YOU;
			giveProduct(product);
			returnChange(product.price);
		} else {
			display = PRICE + " " + product.price;
		}
	}

	private void giveProduct(Product product) {
		// Hardware interaction to give the product
	}

	private void returnChange(int productPrice) {
		// Hardware interaction to return moneyIn-product.price
	}

	private boolean enoughMoney(int productPrice) {
		if ((moneyIn - productPrice) >= 0) {
			return true;
		}
		return false;
	}

}
