package com.teclab.gamarra.engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;

import java.util.HashMap;

/**
 * Created by Heat on 02/11/2016.
 */
public class Resources {



    private HashMap texturePool;
    public  SoundManager sounds;
    public Context mContext;
    private int fps;
    public Canvas canvas;
    public PointF aspect;
    private String hashKey;


    public Resources(Context _context){
        fps = 32;
        hashKey ="";
        mContext = _context;
        texturePool = new HashMap();
        sounds = new SoundManager(_context);
    }
public void loadTexture(String key,int resource){
    if (!texturePool.containsKey(key)){
        Bitmap bmp = null;
        bmp = BitmapFactory.decodeResource(mContext.getResoursces(),resource);
        texturePool.put(key,bmp);
    }
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
