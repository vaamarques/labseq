package design.patterns.behavior.event;

public class EventHandler implements Observer{
    @Override
    public void update() {
        System.out.println("Event Handler: Handling event...");
    }
}
