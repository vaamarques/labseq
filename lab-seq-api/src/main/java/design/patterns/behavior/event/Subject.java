package design.patterns.behavior.event;

interface Subject {
    void addObserver(final Observer observer);
    void removeObserver(final Observer observer);
    void notifyObservers();
}
