package cl.jorcarca.designpatterns.behavioral.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Subscriber implements Observer {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private String name;
    private String newsTitle;

    public Subscriber(String name) {
        this.name = name;
        this.newsTitle = "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(Observable observable) {
        logger.log(Level.INFO, "Updating from observable: {0}", observable);
        newsTitle = ((Publisher) observable).getTitle();
        logger.log(Level.INFO, "Updated title: {0}", this.getNewsTitle());
    }

    public String getNewsTitle() {
        return this.newsTitle;
    }

}
