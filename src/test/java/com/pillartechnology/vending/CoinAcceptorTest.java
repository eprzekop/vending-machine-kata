package com.pillartechnology.vending;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CoinAcceptorTest {
	CoinAcceptor acceptor;

	@Before
	public void setUp() {
		acceptor = new CoinAcceptor();
	}

	@Test
	public void whenNickelInsertedCoinIsAccepted() {
		assertThat(acceptor.receiveCoin(Coin.NICKEL), is(true));
	}

	@Test
	public void whenPennyInsertedCoinIsRejected() throws Exception {
		assertThat(acceptor.receiveCoin(Coin.PENNY), is(false));
	}

	@Test
	public void whenDimeInsertedCoinIsAccepted() throws Exception {
		assertThat(acceptor.receiveCoin(Coin.DIME), is(true));
	}

	@Test
	public void whenQuarterInsertedCoinIsAccepted() throws Exception {
		assertThat(acceptor.receiveCoin(Coin.QUARTER), is(true));
	}

}
