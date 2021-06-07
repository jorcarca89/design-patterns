package cl.jorcarca.designpatterns.behavioral.memento;

import java.util.logging.Logger;

public abstract class BaseSnapshot implements Snapshot {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private final SnapshotMetadata metadata;

    protected BaseSnapshot(SnapshotMetadata metadata) {
        this.metadata = metadata;
    }

    public SnapshotMetadata getMetadata() {
        return metadata;
    }
}
