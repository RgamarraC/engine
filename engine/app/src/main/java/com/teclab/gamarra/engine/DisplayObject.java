package com.teclab.gamarra.engine;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by Heat on 01/11/2016.
 */
public class DisplayObject {

    public int x,y;
    public DisplayObject parent;
    public Resources resources;

    public DisplayObject(Resources resources){
        this.resources = resources;
    }

    public void onDraw(Canvas canvas){
        this.update();
    }

    public void update(){

    }

    public void onTouchEvent(MotionEvent event) {

    }
}
