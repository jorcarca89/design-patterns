package cl.jorcarca.designpatterns.behavioral.memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class BaseSnapshotManager implements SnapshotManager {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private Snapshotable snapshotable;
    private List<Snapshot> snapshots;

    public BaseSnapshotManager(Snapshotable snapshotable) {
        this.snapshotable = snapshotable;
        snapshots = new ArrayList<>();
    }

    @Override
    public void takeSnapshot() {
        logger.info("Taking snapshot and adding it to snapshots list");
        Snapshot snapshot = snapshotable.takeSnapshot();
        snapshots.add(snapshot);
    }

    @Override
    public void undo() {
        logger.info("Restoring snapshot and deleting it from snapshots list");
        snapshots.remove(snapshots.size() - 1).restore();
    }

    public List<Snapshot> getSnapshots() {
        return Collections.unmodifiableList(snapshots);
    }

}
