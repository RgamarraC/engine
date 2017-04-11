package com.teclab.gamarra.engine;

import java.util.Objects;

/**
 * Created by Alumno on 11/04/2017.
 */

public class Event {
    public Event(String _type){
        type=_type;
    }
    public Event(String _type, Object _data)
    {
        type = _type;
        data = _data;
    }
    public EventDispatcher currentTarget;
    public EventDispatcher target;
    public String type;
    public Object data;
}
