package com.ymbj.observer;

public interface Subject {
    /**
     *  subscribeObserver, which is used to subscribe observers or we can say register the observers so that if there is a change
     * in the state of the subject, all these observers should get notified.
     * @param observer
     */
    public void subscribeObserver(Observer observer);

    /**
     * unSubscribeObserver, which is used to unsubscribe observers so that if there is a change in the state of the subject, this
     * unsubscribed observer should not get notified.
     * @param observer
     */
    public void unSubscribeObserver(Observer observer);

    /**
     *  notifyObservers, this method notifies the registered observers when there is a change in the state of the subject.
     */
    public void notifyObservers();

    String subjectDetails();
}
