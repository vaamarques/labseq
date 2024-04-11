package design.patterns.creational.absctractFactory;


import design.patterns.behavior.event.EventHandler;
import design.patterns.behavior.event.EventManager;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainAbstractFactory {

    public static void main(String[] args) {

        final GUIFactory gUIFactory = new WindowsFactory();

        final Button windowsButton = gUIFactory.createButton();
        windowsButton.render();
        Random r = new Random();
        ReentrantReadWriteLock re = new ReentrantReadWriteLock();
        re.readLock();

        AtomicBoolean d = new AtomicBoolean();

    }


    private static class CS extends Thread{


    }
}
