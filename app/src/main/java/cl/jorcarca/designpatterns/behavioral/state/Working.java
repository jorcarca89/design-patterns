package cl.jorcarca.designpatterns.behavioral.state;

import java.util.logging.Logger;

public class Working implements State {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private Engine engine;

    public Working(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void turnOn() {
        logger.info("Is already working...");
    }

    @Override
    public void doWork() {
        logger.info("Is already working...");
    }

    @Override
    public void stop() {
        logger.info("Stopping engine...");
        engine.setState(new Stopped(engine));

    }

    @Override
    public void emergencyStop() {
        logger.info("Emergency stop!!!");
        engine.setState(new Stopped(engine));
    }

}
