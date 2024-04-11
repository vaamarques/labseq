package design.patterns.behavior.event;

import java.util.ArrayList;
import java.util.List;

public class EventManager implements Subject{

    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(final Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update();
        }

    }
}
