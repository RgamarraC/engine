package com.teclab.gamarra.engine;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * Created by Heat on 01/11/2016.
 */
public class MainScene extends Sprite{


    Resources res;
    Sprite Myimg=new Sprite();
    Sprite sce =new Sprite();

    double yDelta=0.0;

    public MainScene(Resources res){
        super();
        this.res = res;
      Image imgc =new Image("cielo",R.drawable.cielo,res);
      Image img = new Image("goku",R.drawable.goku,res);
        sce.addChild(imgc);
        Myimg.addChild(img);
     imgc.x=-960;
        sce.y=-540;
        sce.scaleX=1.3f;
        sce.scaleY=1.3f;

        Myimg.y = -600;
        this.addChild(sce);
        this.addChild(Myimg);
    }


    @Override
    public void update() {


        yDelta +=0.25;

        Myimg.y=(int)(50*Math.sin(yDelta)-600.0);
        System.out.println( Myimg.y);

    }

}
