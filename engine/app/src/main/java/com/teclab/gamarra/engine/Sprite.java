package com.teclab.gamarra.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

 

public class Sprite extends DisplayObject{

       // direction = 0 up, 1 left, 2 down, 3 right,

       // animation = 3 back, 1 left, 0 front, 2 right

       int[] DIRECTION_TO_ANIMATION_MAP = { 3, 1, 0, 2 };

       private static final int BMP_ROWS = 4;
       private static final int BMP_COLUMNS = 3;
       private static final int MAX_SPEED = 5;
       private Bitmap bmp;
       public int xSpeed;
       public int ySpeed;
       private int currentFrame = 0;
       private int width;
       private int height;

 

       public Sprite(String id, Resources resources) {
           super(resources);
           bmp = this.resources.getBmp(id);
           this.width = bmp.getWidth() / BMP_COLUMNS;
           this.height = bmp.getHeight() / BMP_ROWS;
       }

 
        @Override
       public void update() {


             currentFrame = ++currentFrame % BMP_COLUMNS;

       }

 

       public void onDraw(Canvas canvas) {

             super.onDraw(canvas);

             int srcX = currentFrame * width;
             int srcY = getAnimationRow() * height;
             Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
             Rect dst = new Rect(x, y, x + width, y + height);
             canvas.drawBitmap(bmp, src, dst, null);

       }



       private int getAnimationRow() {

             double dirDouble = (Math.atan2(xSpeed, ySpeed) / (Math.PI / 2) + 2);

             int direction = (int) Math.round(dirDouble) % BMP_ROWS;

             return DIRECTION_TO_ANIMATION_MAP[direction];

       }

 

       public boolean isCollition(float x2, float y2) {

             return x2 > x && x2 < x + width && y2 > y && y2 < y + height;

       }



}

 