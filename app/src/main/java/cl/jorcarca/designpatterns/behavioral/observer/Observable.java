package cl.jorcarca.designpatterns.behavioral.observer;

public interface Observable {
    String getName();
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
    void notifyChanges();
}
