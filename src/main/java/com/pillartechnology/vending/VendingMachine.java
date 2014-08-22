package com.pillartechnology.vending;

public class VendingMachine {

	private static final String PRICE = "PRICE";
	private String display;
	private CoinAcceptor acceptor;
	private int moneyIn = 0;

	public VendingMachine() {
		display = "INSERT COINS";
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
		return returnValue;
	}

	public void selectProduct(Product product) {
		if (enoughMoney(product.price)) {
			display = "THANK YOU";
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
