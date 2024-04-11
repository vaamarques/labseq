package design.patterns.behavior.event;


public class MainEvent {

    public static void main(String[] args) {

        final EventManager eventManager = new EventManager();
        final EventHandler eventHandler = new EventHandler();
        eventManager.addObserver(eventHandler);

        eventManager.notifyObservers();
    }
}
