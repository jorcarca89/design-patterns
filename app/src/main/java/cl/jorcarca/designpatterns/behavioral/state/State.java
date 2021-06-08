package cl.jorcarca.designpatterns.behavioral.state;

public interface State {
    void turnOn();
    void doWork();
    void stop();
    void emergencyStop();
}
