package design.patterns.behavior.event;

public class LoggingHandler implements Observer{
    @Override
    public void update() {
        System.out.println("Logger: Logging event...");
    }
}
