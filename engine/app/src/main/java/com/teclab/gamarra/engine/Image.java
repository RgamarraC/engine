package com.teclab.gamarra.engine;


import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Image extends DisplayObject {
String key;
Resources resources;

  public Image(String _key, String _tag,int source, Resources _resources) {
            this.resources=_resources;
            this.key =_key;
             _resources.loadTexture(_key,source);
           Bitmap aux = resources.getTexture(key);
              this.width=aux.getWidth();
              this.height=aux.getHeight();

       }
            public void onDraw() {
                Canvas canvas = resources.canvas;
                canvas.scale(scaleX,scaleY);
                canvas.rotate(rotation);
                canvas.drawBitmap(resources.getTexture(key),this.x-(this.width*0.5f) ,this.y-(this.height*0.5f) ,null);
                canvas.scale(scaleX/(scaleX/2),scaleY/(scaleY/2));
                canvas.rotate(-rotation);
            }

}