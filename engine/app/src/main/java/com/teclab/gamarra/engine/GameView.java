package com.teclab.gamarra.engine;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
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
        resources = new Resources(context);
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

        resources.canvas = canvas;
        canvas.drawColor(Color.BLACK);
        myScene.onDraw();
    }



    @Override

    public boolean onTouchEvent(MotionEvent event) {

        if (System.currentTimeMillis() - lastClick > 300) {

            lastClick = System.currentTimeMillis();
            Point EV=new Point();

            EV.x=(int) event.getX();
            EV.y =(int) event.getY();


            switch (event.getAction()) {
                case  MotionEvent.ACTION_DOWN :
                    myScene.touchDown(EV,0);
                case  MotionEvent.ACTION_UP :
                    myScene.touchDown(EV,0);
                case  MotionEvent.ACTION_MOVE :
                    myScene.touchDown(EV,0);

            }
            synchronized (getHolder()) {
                //myScene.onTouchEvent(event);
            }

        }

        return true;

    }

}