package com.teclab.gamarra.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Image extends DisplayObject {

       private Bitmap bmp;


       public Image(String id, Resources resources) {
            super(resources);
            bmp = this.resources.getBmp(id);

       }

 

       public void onDraw(Canvas canvas) {
              super.onDraw(canvas);
              canvas.drawBitmap(bmp, x, y, null);

       }


}