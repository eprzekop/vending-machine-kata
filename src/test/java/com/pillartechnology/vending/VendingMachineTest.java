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
}
