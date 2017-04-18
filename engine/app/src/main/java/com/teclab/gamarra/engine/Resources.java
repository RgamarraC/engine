package com.teclab.gamarra.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Heat on 4/9/2017.
 */

public class Resources {

    private HashMap texturePool;
    public SoundManager sounds;
    public Context mContext;
    public int fps;
    public Canvas canvas;
    public PointF aspect;
    private String hashKey;

    public Resources(Context _context)
    {
        fps = 32;
        hashKey = "";
        mContext = _context;
        texturePool = new HashMap();
        sounds = new SoundManager(_context);
    }

    public void loadTexture(String key, int source)
    {
        if(!texturePool.containsKey(key))
        {
            Bitmap bmp = null;
            bmp = BitmapFactory.decodeResource(mContext.getResources(), source);
            texturePool.put(key, bmp);
        }
    }

    public void unloadTexture(String key)
    {
        ((Bitmap)texturePool.get(key)).recycle();
        texturePool.remove(key);
    }

    public Bitmap getTexture(String key)
    {
        return (Bitmap)texturePool.get(key);
    }

    public boolean isOnline()
    {
        ConnectivityManager cm = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void setContext(Context _mContext)
    {
        mContext = _mContext;
        sounds.setmContext(_mContext);
    }

    public String getHashKey()
    {
        return hashKey;
    }

    public void setHashKey(String hashKey)
    {
        this.hashKey = hashKey;
    }

    public void clearPool()
    {

        Iterator it = texturePool.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            ((Bitmap)e.getValue()).recycle();
        }

        texturePool.clear();
    }

}