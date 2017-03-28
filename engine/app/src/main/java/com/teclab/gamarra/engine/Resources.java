package com.teclab.gamarra.engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

/**
 * Created by Heat on 02/11/2016.
 */
public class Resources {

    private GameView view;
    private HashMap<String,Bitmap> pool;

    public Resources(GameView view){
        this.view = view;
        pool  = new HashMap<String, Bitmap>();
    }

    public Bitmap getBmp(String resource){
        if(!this.pool.containsKey(resource)){
            this.pool.put(resource, BitmapFactory.decodeResource(this.view.getResources(),this.view.getResources().getIdentifier(resource , "drawable", this.view.getContext().getPackageName())));
        }

        return this.pool.get(resource);
    }

    public Bitmap removeBmp(String resource){
        return this.pool.remove(resource);
    }

}
