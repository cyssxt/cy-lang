package com.cyssxt.event;

public class EventData<T> {
    public EventData(T t) {
        this.t = t;
    }

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
