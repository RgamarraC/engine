package com.teclab.gamarra.engine;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heat on 01/11/2016.
 */
public class DisplayContainer extends DisplayObject{

    private List<DisplayObject> children;

    public DisplayContainer(Resources resources){
        super(resources);
        children = new ArrayList();

    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for (DisplayObject child:children){
            child.onDraw(canvas);
        }
    }
    public void addChild(DisplayObject child){
        child.parent = this;
        children.add(child);
    }


    public void onTouchEvent(MotionEvent event) {
        for (DisplayObject child:children){
            child.onTouchEvent(event);
        }
    }

}
