package cl.jorcarca.designpatterns.behavioral.memento;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class BaseSnapshotManagerTest {
	@Mock
	Snapshotable snapshotable;
	BaseSnapshotManager snapshotManager;

	@Before
	public void setup() {
		snapshotManager = new BaseSnapshotManager(snapshotable);
	}

	@Test
	public void shouldTakeSnapshot() {
		int expectedSnapshotsSize = 1;
		snapshotManager.takeSnapshot();
		assertEquals(expectedSnapshotsSize, snapshotManager.getSnapshots().size());
	}

	@Test
	public void shouldUndo() {
		Snapshot snapshot = mock(Snapshot.class);
		when(snapshotable.takeSnapshot()).thenReturn(snapshot);

		int expectSnapshotSize = 0;
		snapshotManager.takeSnapshot();
		snapshotManager.undo();
		assertEquals(expectSnapshotSize, snapshotManager.getSnapshots().size());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void shouldGetImmutableSnapshotsList() {
		Snapshot snapshot = mock(Snapshot.class);
		List<Snapshot> snapshots = snapshotManager.getSnapshots();
		snapshots.add(snapshot);

		fail("Retrieve transaction list must be umodifiable");
	}

}
