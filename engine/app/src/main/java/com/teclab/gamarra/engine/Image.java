package com.teclab.gamarra.engine;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;


public class    Image extends DisplayObject {
     String key;
     Resources resources;
     Bitmap a;
    Frame frame;
  public Image(String _key, String _tag,int source, Resources _resources) {
      this.resources=_resources;
      this.key =_key;
      _resources.loadTexture(_key,source);
      a = resources.getTexture(key);
      this.width=a.getWidth();
      this.height=a.getHeight();
      }

    public void onDraw() {
        Point pos = this.transformation.globalPosition();
        PointF myScale = this.transformation.getAcumulatedScale();
        float myOpacity = this.transformation.getAcumulatedOpacity();
        int myRotation = this.transformation.getAcumulatedRotation();
                Paint p = new Paint();
                p.setAlpha((int) (opacity*255));
                float px;
                float py;
                Canvas canvas = resources.canvas;
                canvas.rotate(rotation);
                if(myScale.x<0||myScale.y<0){
                    Matrix matrix = new Matrix();
                    matrix.preScale(myScale.x ,myScale.y);
                    a = Bitmap.createBitmap(resources.getTexture(key),frame.x,frame.y,this.width,this.height,matrix,false);
                    px =x-a.getWidth()*0.5F;
                    py =y-a.getHeight()*0.5F;
                    canvas.drawBitmap(a,px,py,p);
                }
                else {
                    px =x-this.width*0.5F;
                    py =y-this.height*0.5F;
                    canvas.drawBitmap(a, new Rect(0, 0, this.width, this.height), new RectF(px, py, this.frame.width * myScale.x, this.frame.height * myScale.y), p);
                }
                canvas.rotate(-rotation);
            }
         public void dispose(){
             if(this.a != null)
                 this.a.recycle();
             this.a=null;
             this.a=null;
             super.dispose();
         }
         public void setBmp (Bitmap _a){
             this.a=_a;
         }

}