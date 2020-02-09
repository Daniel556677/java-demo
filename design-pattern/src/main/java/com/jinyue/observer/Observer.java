package com.jinyue.observer;

public interface Observer {
    /**
     * update(String commentary), method is called by the subject on the observer in order to notify it, when there is a change in the
     * state of the subject.
     * @param commentary
     */
    void update(String commentary);

    /**
     * subscribe(), method is used to subscribe itself with the subject.
     */
    void subscribe();

    /**
     * unsubscribe(), method is used to unsubscribe itself with the subject.
     */
    void unSubcribe();
}
