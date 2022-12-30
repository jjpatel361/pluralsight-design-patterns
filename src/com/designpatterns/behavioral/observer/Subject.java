package com.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<CustomObserver> observers = new ArrayList<CustomObserver>();

    abstract void setState();
    abstract String getState();

    public void attach(CustomObserver observer) {
        this.observers.add(observer);
    }

    public void detach(CustomObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (CustomObserver observer: observers) {
              observer.update();
        }
    }


}
