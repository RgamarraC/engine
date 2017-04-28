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
    public int width;
    public float opacity;
    public float scaleX,scaleY;
    public int rotation;
    public int pivotX,pivotY;
    public int x,y;
    public DisplayObject parent;


    public boolean visible;
    //Transformation  transformation;
    DisplayObject(){
        x=y=0;
        scaleX=scaleY=1.0f;
        rotation=0;
        pivotX=pivotY=0;
        opacity=1.0f;
        width=height=0;
        visible=true;
        parent=null;
        //transformation= new Transformation(this);

    }



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
    public  void onDraw(){}
}
