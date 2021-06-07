package cl.jorcarca.designpatterns.behavioral.memento;

import java.time.LocalDateTime;
import java.util.Objects;

import cl.jorcarca.designpatterns.common.TimeProvider;

public class SnapshotMetadata {
    private LocalDateTime dateTime;
    private String name;
    private String data;

    public SnapshotMetadata(String name, String data) {
        this.name = name;
        this.data = data;
        dateTime = TimeProvider.now();
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public String getName() {
        return this.name;
    }

    public String getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "{" + " dateTime='" + getDateTime() + "'" + ", name='" + getName() + "'" + ", data='" + getData() + "'"
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SnapshotMetadata)) {
            return false;
        }
        SnapshotMetadata snapshotMetadata = (SnapshotMetadata) o;
        return Objects.equals(dateTime, snapshotMetadata.dateTime) && Objects.equals(name, snapshotMetadata.name)
                && Objects.equals(data, snapshotMetadata.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, name, data);
    }

}
