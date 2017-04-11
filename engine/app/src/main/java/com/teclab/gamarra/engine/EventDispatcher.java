package com.teclab.gamarra.engine;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Alumno on 04/04/2017.
 */






public class EventDispatcher {

    private List listeners;

    public EventDispatcher(){
        listeners = new Arraylist();
    }
    public void addEventListener(String type)
    {
        listerner.add(type);
    }
    public void dispatchEvent(Event e)
{
    if(e.target == null)
        e.target = this;
    for (int i=0;i<listeners.size();i++)
        if(((String)listeners.get(i)).equals(e.type))
            recieveEvent(e);
}
    public void dispatchEvent(String type){

        Event e=new Event(type);
        if (e.target == null)
            e.target = this;
        for (int i=0;i<listeners.size();i++)
            if(((String)listeners.get(i)).equals(e.type))
                recieveEvent(e);
    }
    public void removeEventListener(String type){
        listeners.remove(type);
    }
    public void removeEventListener(){
        listeners.clear();
    }
    public void reciveEvent(Event event)
    {}
    public  void dispose(){
        listeners.clear();
    }

}
