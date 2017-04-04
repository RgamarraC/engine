package com.teclab.gamarra.engine;

import android.graphics.BitmapFactory;

/**
 * Created by Heat on 01/11/2016.
 */
public class MainScene extends DisplayContainer{

    npc bad;
    public MainScene(Resources resources){

        super(resources);
        for(int i=1; i<7;++i){
            bad = new npc("bad"+i, resources);
            bad.x = (int)(Math.random()*500.0f);
            addChild(bad);
        }


    }


    @Override
    public void update() {


    }

}
