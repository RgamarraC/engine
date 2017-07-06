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
    public void setFrame()
    {
        this.frame = new Frame(0, 0, this.a.getWidth(), this.a.getHeight());
    }
    public void onDraw() {
        Point pos = this.transformation.globalPosition();
        PointF myScale = this.transformation.getAcumulatedScale();
        float myOpacity = this.transformation.getAcumulatedOpacity();
        int myRotation = this.transformation.getAcumulatedRotation();
        Paint p = new Paint();
        p.setAlpha((int) (opacity*255));
        Matrix matrix = new Matrix();
        matrix.preScale(myScale.x ,myScale.y);
        int px;
        boolean Invert = false;
        if(myScale.x<0){
            px = ((int)(width/2 - this.frame.width + this.frame.offsetX * myScale.x));
        Invert =true  ;}
            else {px = ((int)(width/2 + this.frame.offsetX * myScale.x));
                }
        int py;
        if(myScale.y<0){
            px = ((int)(width/2 - this.frame.height + this.frame.offsetY * myScale.y));
            Invert =true;
                }
                else {
            px = ((int)(width/2 + this.frame.offsetX * myScale.y));
                }
        Rect src;
        Rect dst;
        if(!Invert)
        {
            src = new Rect(this.frame.x, this.frame.y, this.frame.x + this.frame.width, this.frame.y + this.frame.height);
            dst = new Rect(pos.x - px, pos.y - py, (int)(pos.x - px + this.frame.width * myScale.x), (int)(pos.y - despY + this.frame.height * myScale.y));
       if (myRotation !=0)
       {
           this.resources.canvas.save();
           this.resources.canvas.rotate(-myRotation,pos.x,pos.y);
           if (this.a == null) {
               this.resources.canvas.drawBitmap(this.resources.getTexture(this.key), src, dst, p);
           } else {
               this.resources.canvas.drawBitmap(this.a, src, dst,p);
           }
           if (myRotation != 0) {
               this.resources.canvas.restore();
           }
       }
        }
        else {
            Matrix m = new Matrix();
            m.preScale(Math.signum(myScale.x), Math.signum(myScale.y));
            src = new Rect(0, 0, this.frame.width, this.frame.height);
            dst = new Rect(pos.x - px, pos.y - py, (int)(pos.x - px + this.frame.width * Math.abs(myScale.x)), (int)(pos.y - py + this.frame.height * Math.abs(myScale.y)));
            if (myRotation != 0)
            {
                this.resources.canvas.save();
                this.resources.canvas.rotate(-myRotation, pos.x, pos.y);
            }
            if (this.a == null)
            {
                Bitmap baux = Bitmap.createBitmap(this.resources.getTexture(this.key), this.frame.x, this.frame.y, this.frame.width, this.frame.height, m, true);
                this.resources.canvas.drawBitmap(baux, src, dst, p);
                baux = null;
            }
            else
            {
                Bitmap baux = Bitmap.createBitmap(this.a, this.frame.x, this.frame.y, this.frame.width, this.frame.height, m, true);
                this.resources.canvas.drawBitmap(baux, src, dst, p);
                baux = null;
            }
            if (myRotation != 0) {
                this.resources.canvas.restore();
            }
        }
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
         }}

