package com.teclab.gamarra.engine;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;


public class Image extends DisplayObject {
String key;
Resources resources;
Bitmap a;
  public Image(String _key, String _tag,int source, Resources _resources) {
            this.resources=_resources;
            this.key =_key;
             _resources.loadTexture(_key,source);
           a = resources.getTexture(key);
              this.width=a.getWidth();
              this.height=a.getHeight();

      }
            public void onDraw() {
                Paint p = new Paint();
                p.setAlpha((int) (opacity*255));
                float n;
                float m;
                Canvas canvas = resources.canvas;
                canvas.rotate(rotation);
                if(scaleY<0||scaleX<0){
                    Matrix matrix = new Matrix();
                    matrix.preScale(scaleX,scaleY);
                    a = Bitmap.createBitmap(resources.getTexture(key),0,0,this.width,this.height,matrix,false);
                    n =x-a.getWidth()*0.5F;
                    m =y-a.getHeight()*0.5F;
                    canvas.drawBitmap(a,n,m,p);
                }
                else {
                    n =x-this.width*0.5F;
                    m =y-this.height*0.5F;
                    canvas.drawBitmap(a, new Rect(0, 0, this.width, this.height), new RectF(n, m, this.width * this.scaleX, this.height * this.scaleY), p);
                }
                canvas.rotate(-rotation);


            }

}