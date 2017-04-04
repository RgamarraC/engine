package com.teclab.gamarra.engine;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;


/**
 * Created by ptemoche on 3/14/2017.
 */

public class npc extends Sprite {

public Image blood;

    public npc(String id, Resources resources){
        super(id,resources);
        this.xSpeed = (int)(Math.random()*2);
        this.ySpeed = (int)(Math.random()*2);
        blood = new Image("blood1",resources);

    }

    @Override
    public void update(){
        super.update();
        this.x+=xSpeed;
        this.y+=ySpeed;

    }

    @Override
    public void onTouchEvent(MotionEvent event){

        float x = event.getX();

        float y = event.getY();

        if (this.isCollition(x,y)){

            System.out.println("DEAD");
            this.xSpeed =0;
            this.ySpeed =0;
            this.addChild(blood);
            blood.x = this.x;
            blood.y = this.y;

            }
        }





}
