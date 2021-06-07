package cl.jorcarca.designpatterns.behavioral.memento;

public interface SnapshotManager {
    void takeSnapshot();
    void undo();
}
