package cl.jorcarca.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseObservable implements Observable {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private List<Observer> observers;
    private String name;

    protected BaseObservable(){
        observers = new ArrayList<>();
    }

    public BaseObservable(String name) {
        this();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void attachObserver(Observer observer) {
        logger.log(Level.INFO, "Attaching observer: {0}", observer.getName());
        observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        logger.log(Level.INFO, "Detaching observer: {0}", observer.getName());
        observers.remove(observer);
    }

    @Override
    public void notifyChanges() {
        logger.info("Notifying changes to subscribers");
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
