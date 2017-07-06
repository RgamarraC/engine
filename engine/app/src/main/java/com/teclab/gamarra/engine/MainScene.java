package com.teclab.gamarra.engine;

import android.graphics.BitmapFactory;

/**
 * Created by Heat on 01/11/2016.
 */
public class MainScene extends DisplayContainer{


    Resources res;
    Image img;
    Image img2;

    public MainScene(Resources res){
        super();
        this.res = res;
        img = new Image("bad","bad",R.drawable.bad1,res);
        img.scaleX=-2;img.x = 0;
        this.addChild(img);
    }


    @Override
    public void update() {


    }

}
