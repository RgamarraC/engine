package com.teclab.gamarra.engine;

import android.graphics.Point;
import android.graphics.PointF;

import org.ejml.simple.SimpleMatrix;


/**
 * Created by Alumno on 13/06/2017.
 */

public class Transformation extends java.lang.Object {

   private DisplayObject _displayobjet;

    public Transformation(DisplayObject _invoker)
    {
        _displayobjet=_invoker;
    }
   public void CreateMTrasnformations()
    {
        SimpleMatrix Traslate = new SimpleMatrix (new double[][] {{ 1,0, _displayobjet.x},{  0, 1, _displayobjet.y},  {0,  0, 1}});
        SimpleMatrix Rotate=new SimpleMatrix(new double[][]{{Math.cos(_displayobjet.rotation),-Math.sin(_displayobjet.rotation)},{Math.sin(_displayobjet.rotation),Math.cos(_displayobjet.rotation)}});
        SimpleMatrix Scale=new SimpleMatrix(new double[][] {{_displayobjet.scaleX,0 },{0,_displayobjet.y }});
    }
    public PointF getAcumulatedScale(int x, int y){

        return   
    }
}
