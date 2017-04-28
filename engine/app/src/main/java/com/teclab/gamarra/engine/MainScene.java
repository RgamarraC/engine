package com.teclab.gamarra.engine;

import android.graphics.BitmapFactory;

/**
 * Created by Heat on 01/11/2016.
 */
public class MainScene extends DisplayContainer{


    Resources res;
    Image img, img2;
    public MainScene(Resources res){
        super();
        this.res = res;
        img = new Image("bad","bad",R.drawable.bad1,res);
        img2 = new Image("blood","blood",R.drawable.blood1,res);
img2.scaleX=20;
        img2.scaleY=5;
                img.x=150;
        img.y=6;
        img2.rotation = 45;
        this.addChild(img2);
        this.addChild(img);


    }


    @Override
    public void update() {


    }

}
