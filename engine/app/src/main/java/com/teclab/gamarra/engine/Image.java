package com.teclab.gamarra.engine;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;


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
                Paint p = new Paint();
                float n =x-this.width*0.5F;
                float m =y-this.height*0.5F;
                Canvas canvas = resources.canvas;
                canvas.rotate(rotation);
                canvas.drawBitmap(resources.getTexture(key),new Rect(0,0,this.width,this.height),new RectF(n,m,this.width*this.scaleX,this.height*this.scaleY),p);
                canvas.rotate(-rotation);


            }

}