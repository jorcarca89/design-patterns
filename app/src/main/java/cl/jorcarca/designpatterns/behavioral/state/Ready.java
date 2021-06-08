package cl.jorcarca.designpatterns.behavioral.state;

import java.util.logging.Logger;

public class Ready implements State {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private Engine engine;

    public Ready(Engine engine){
        this.engine = engine;
    }

    @Override
    public void turnOn() {
        logger.info("Is already turned on...");        
    }

    @Override
    public void doWork() {
        logger.info("Starting work...");
        engine.setState(new Working(engine));
    }

    @Override
    public void stop() {
        logger.info("Stopping...");        
        engine.setState(new Stopped(engine));
    }

    @Override
    public void emergencyStop() {
        logger.info("Can\'t do emergency stop, the engine isn\'t working");        
    }
    
}
