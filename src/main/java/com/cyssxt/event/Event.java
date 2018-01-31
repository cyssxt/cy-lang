package com.cyssxt.event;

public interface Event<T> {
    void execute(EventData<T> data);
}
