package com.teclab.gamarra.engine;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

 

public class GameView extends SurfaceView {

    private GameLoopThread gameLoopThread;
    private long lastClick;
    private MainScene myScene;
    public Resources resources;

    public GameView(Context context) {

        super(context);
        resources = new Resources(this);
        myScene = new MainScene(this.resources);
        gameLoopThread = new GameLoopThread(this);

        getHolder().addCallback(new SurfaceHolder.Callback() {



            public void surfaceDestroyed(SurfaceHolder holder) {

                   boolean retry = true;

                   gameLoopThread.setRunning(false);

                   while (retry) {

                          try {

                                gameLoopThread.join();

                                retry = false;

                          } catch (InterruptedException e) {}

                   }

            }





            public void surfaceCreated(SurfaceHolder holder) {

                   gameLoopThread.setRunning(true);
                   gameLoopThread.start();

            }





            public void surfaceChanged(SurfaceHolder holder, int format,

                          int width, int height) {

            }

        });

    }



    @Override

    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.BLACK);
        myScene.onDraw(canvas);
    }



    @Override

    public boolean onTouchEvent(MotionEvent event) {

         if (System.currentTimeMillis() - lastClick > 300) {

                lastClick = System.currentTimeMillis();

                float x = event.getX();

                float y = event.getY();

                synchronized (getHolder()) {
                    myScene.onTouchEvent(event);
                }

         }

         return true;

    }

}