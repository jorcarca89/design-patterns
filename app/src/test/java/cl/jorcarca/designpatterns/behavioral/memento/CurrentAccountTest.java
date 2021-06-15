package cl.jorcarca.designpatterns.behavioral.memento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import cl.jorcarca.designpatterns.common.TimeProvider;

@RunWith(MockitoJUnitRunner.class)
public class CurrentAccountTest {
	private String currency = "CLP";
	private Integer initialAmount = 0;

	private CurrentAccount currentAccount;

	@Before
	public void setup() {
		this.currentAccount = new CurrentAccount(currency, initialAmount);
	}

	@Test
	public void shouldTakeSnapshot() {
		String fixedDate = "2021-01-01 00:00:00";
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		TimeProvider.fixClockAt(LocalDateTime.parse(fixedDate, DateTimeFormatter.ofPattern(dateFormat)));
		Snapshot currentAccountSnapshot = currentAccount.takeSnapshot();

		assertTrue("The snapshot must be instance of CurrentAccountSnapshot",
				currentAccountSnapshot instanceof CurrentAccount.CurrentAccountSnapshot);
	}

	@Test
	public void shouldTakeDifferentSnapshots() {
		Snapshot initialSnapshot = currentAccount.takeSnapshot();
		currentAccount.addTransaction(500);
		Snapshot nextSnapshot = currentAccount.takeSnapshot();

		assertNotEquals("Snapshots must be differents when internal state of snapshotable changes", initialSnapshot,
				nextSnapshot);
	}

	@Test
	public void shouldAddTransactionAndUpdateCurrentAmount() {
		Integer amount = 1000;
		Integer expectedCurrentAmount = 1000;
		Integer currentAmount = currentAccount.addTransaction(amount);

		assertEquals("Retrieved current amount wasn\'t match", expectedCurrentAmount, currentAmount);
		assertEquals("Amount couldn\'t be added to transaction list", amount,
				currentAccount.getTransactions().get(currentAccount.getTransactions().size() - 1));
		assertEquals("Current amount couldn\'t be updated", expectedCurrentAmount, currentAccount.getCurrentAmount());
	}

	@Test
	public void shouldBlockAccount() {
		currentAccount.blockAccount();

		assertTrue("Account couldn\'t be blocked", currentAccount.isBlocked());
	}

	@Test
	public void shouldUnblockAccount() {
		currentAccount.unblockAccount();

		assertFalse("Account couldn\'t be unblocked", currentAccount.isBlocked());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldGetImmutableTransactionList() {
		List<Integer> transactionList = currentAccount.getTransactions();
		transactionList.add(0);

		fail("Retrieve transaction list must be umodifiable");
	}

}
