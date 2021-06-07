package cl.jorcarca.designpatterns.behavioral.memento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseSnapshotManagerTest {
	BaseSnapshotManager snapshotManager;
	CurrentAccount currentAccount;
	String currency;
	Integer initialAmount;

	@Before
	public void setup() {
		currency = "CLP";
		initialAmount = 0;

		currentAccount = new CurrentAccount(currency, initialAmount);
		snapshotManager = new BaseSnapshotManager(currentAccount);
	}

	@Test
	public void shouldTakeSnapshot() {
		int expectedSnapshotsSize = 1;
		snapshotManager.takeSnapshot();
		assertEquals(expectedSnapshotsSize, snapshotManager.getSnapshots().size());
	}

	@Test
	public void shouldUndo() {
		int expectSnapshotSize = 0;
		snapshotManager.takeSnapshot();
		currentAccount.addTransaction(500);
		snapshotManager.undo();
		assertEquals(expectSnapshotSize, snapshotManager.getSnapshots().size());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldGetImmutableSnapshotsList() {
		List<Snapshot> snapshots = snapshotManager.getSnapshots();
		snapshots.add(currentAccount.takeSnapshot());

		fail("Retrieve transaction list must be umodifiable");
	}

}
