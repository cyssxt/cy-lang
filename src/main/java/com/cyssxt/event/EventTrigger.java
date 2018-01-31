package com.cyssxt.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventTrigger {
    private final static Map<String,List<Event>> eventMap = new HashMap<String,List<Event>>();

    /**
     * 绑定事件
     * @param msg
     * @param event
     * @return
     */
    public static int on(String msg,Event event){
        List<Event> eventList = eventMap.get(msg);
        if(eventList==null){
            eventList = new ArrayList<Event>();
            eventMap.put(msg,eventList);
        }
        eventList.add(event);
        return eventList.size();
    }

    /**
     * 解绑
     * @param msg
     */
    public void unbind(String msg){
        eventMap.remove(msg);
    }

    /**
     * 触发事件
     * @param msg
     * @param eventData
     * @return
     */
    public static int emit(String msg,EventData eventData){
        List<Event> eventList = eventMap.get(msg);
        int i = 0;
        for(Event event:eventList){
            event.execute(eventData);
            i++;
        }
        return i;
    }
}
