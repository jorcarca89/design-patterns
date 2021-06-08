package cl.jorcarca.designpatterns.behavioral.state;

import java.util.logging.Logger;

public class Stopped implements State{
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private Engine engine;

    public Stopped(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void turnOn() {
        logger.info("Turning on...");
        engine.setState(new Ready(engine));
    }

    @Override
    public void doWork() {
        logger.info("Can\'t do work");
    }

    @Override
    public void stop() {
        logger.info("Is already stopped");
    }

    @Override
    public void emergencyStop() {
        logger.info("Is already stopped");
    }
}
