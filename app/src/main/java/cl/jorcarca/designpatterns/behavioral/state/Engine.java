package cl.jorcarca.designpatterns.behavioral.state;

import java.util.logging.Logger;

public class Engine {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private State state;

    public Engine() {
        this.state = new Stopped(this);
    }

    public Engine(Stopped stopped) {
        this.state = stopped;
    }

    public void turnOn() {
        state.turnOn();
    }

    public void doWork() {
        state.doWork();
    }

    public void stop() {
        state.stop();
    }

    public void emergencyStop() {
        state.emergencyStop();
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
