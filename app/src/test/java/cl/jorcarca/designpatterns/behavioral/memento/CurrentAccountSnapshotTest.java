package cl.jorcarca.designpatterns.behavioral.memento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CurrentAccountSnapshotTest {
	private String currency;
	private Integer initialAmount;

	private CurrentAccount currentAccount;

	@Before
	public void setup() {
		this.currency = "CLP";
		this.initialAmount = 0;
		currentAccount = new CurrentAccount(currency, initialAmount);
	}

	@Test
	public void shouldRestoreSnapshot() {
		String expectedCurrency = "CLP";
		Integer expectedInitialAmount = 0;
		Integer expectedCurrentAmount = 0;
		List<Integer> expectedTransactions = new ArrayList<>();
		boolean expectIsBlocked = true;

		Snapshot snapshot = currentAccount.takeSnapshot();

		currentAccount.addTransaction(500);
		currentAccount.unblockAccount();

		assertEquals(expectedCurrency, currentAccount.getCurrency());
		assertEquals(expectedInitialAmount, currentAccount.getInitialAmount());
		assertNotEquals(expectedCurrentAmount, currentAccount.getCurrentAmount());
		assertNotEquals(expectedTransactions, currentAccount.getTransactions());
		assertNotEquals(expectIsBlocked, currentAccount.isBlocked());

		snapshot.restore();

		assertEquals(expectedCurrency, currentAccount.getCurrency());
		assertEquals(expectedInitialAmount, currentAccount.getInitialAmount());
		assertEquals(expectedCurrentAmount, currentAccount.getCurrentAmount());
		assertEquals(expectedTransactions, currentAccount.getTransactions());
		assertEquals(expectIsBlocked, currentAccount.isBlocked());
	}
}
