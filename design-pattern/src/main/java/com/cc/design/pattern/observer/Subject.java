package com.cc.design.pattern.observer;

/**
 * 被观察对象抽象类
 */
public interface Subject {
    /**
     * 添加一个观察对象
     * @param observer
     */
    void attachObserver(Observer observer);

    /**
     * 删除一个观察对象
     * @param observer
     */
    void detachObserver(Observer observer);

    /**
     * 通知所有观察对象
     */
    void notifyObservers();

}
