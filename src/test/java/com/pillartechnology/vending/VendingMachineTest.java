package com.pillartechnology.vending;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine machine;

	@Before
	public void setup() {
		machine = new VendingMachine();
	}

	@Test
	public void displayShowsValueWithSingleCoin() {
		machine.insertMoney(Coin.DIME);
		assertThat(machine.getDisplay(), containsString("10"));
	}

	@Test
	public void displayShowsValueWithMultipleCoins() {
		machine.insertMoney(Coin.DIME);
		machine.insertMoney(Coin.NICKEL);
		machine.insertMoney(Coin.QUARTER);
		assertThat(machine.getDisplay(), containsString("40"));
	}

	@Test
	public void customerDoesNotReceiveProductWithInsufficientMoney() throws Exception {
		machine.insertMoney(Coin.DIME);
		machine.selectProduct(Product.CANDY);
		assertThat(machine.getDisplay(), containsString("PRICE"));
	}

	@Test
	public void promptsWithAmountOnSecondCheckOfDisplay() throws Exception {
		machine.insertMoney(Coin.DIME);
		machine.selectProduct(Product.CANDY);
		machine.getDisplay();
		assertThat(machine.getDisplay(), containsString("10"));
	}

	@Test
	public void promptsWithThankYouWhenSufficientMoneyIn() throws Exception {
		machine.insertMoney(Coin.QUARTER);
		machine.insertMoney(Coin.QUARTER);
		machine.insertMoney(Coin.QUARTER);
		machine.insertMoney(Coin.DIME);
		machine.insertMoney(Coin.DIME);
		machine.insertMoney(Coin.NICKEL);
		machine.selectProduct(Product.COLA);
		assertThat(machine.getDisplay(), containsString("THANK YOU"));
	}

	@Test
	public void resetsMessageAfterSuccessfulProductDelivery() throws Exception {
		machine.insertMoney(Coin.QUARTER);
		machine.insertMoney(Coin.QUARTER);
		machine.insertMoney(Coin.QUARTER);
		machine.insertMoney(Coin.QUARTER);
		machine.selectProduct(Product.COLA);
		machine.getDisplay();
		assertThat(machine.getDisplay(), containsString("INSERT COINS"));

	}

}
