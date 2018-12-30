package com.cc.design.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 具体的观察对象
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        Iterator<Observer> itr = observerList.iterator();
        while (itr.hasNext()) {
            Observer one = itr.next();
            if (one.equals(observer)) {
                itr.remove();
            }
        }
    }

    @Override
    public void notifyObservers() {

        observerList.forEach(one -> {
            one.onSubjectCall();
        });
    }
}
