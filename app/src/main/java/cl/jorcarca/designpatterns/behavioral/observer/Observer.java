package cl.jorcarca.designpatterns.behavioral.observer;

public interface Observer {
    String getName();
    void update(Observable observable);
}
