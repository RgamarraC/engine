package com.teclab.gamarra.engine;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.EventLog;
import android.view.MotionEvent;
import android.view.animation.Transformation;

/**
 * Created by Heat on 01/11/2016.
 */
public abstract class DisplayObject extends EventDispatcher {

    public int height;
    public float opacity;
    public float scaleX,scaleY;
    public int rotation;
    public int pivotX,pivotY;
    public int x,y;
    public DisplayObject parent;
    public Resources resources;
    public  int width;
    public boolean visible;
    //public  Transformation;
    DisplayObject(){}

    public DisplayObject(Resources resources){
        this.resources = resources;
    }

   // public abstract void onDraw(){    }

    public void update(){
    }
    public  void primaryOperations(){}
    public Point localToGlobal(Point p){
        return  p;
    }
    public Point globalToLocal(Point p){
        return  p;
    }
    //public void dispatchEvent(Event e){}
    public void dispatchEvent(String type){}
    public void touchDown(Point p,int index){}
    public void touchMove(Point p,int index){}
    public void touchUp(Point p,int index){}
    public void dispose(){}
}
