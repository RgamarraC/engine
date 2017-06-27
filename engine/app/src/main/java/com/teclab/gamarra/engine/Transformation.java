package com.teclab.gamarra.engine;

import android.graphics.Point;
import android.graphics.PointF;
import Jama.Matrix;


/**
 * Created by Alumno on 13/06/2017.
 */

public class Transformation extends java.lang.Object {

    private DisplayObject _displayobjet;
    private Matrix TrasnfomM;
    private int acumulatedScale;
    private int acumulatedRotation;


    public Transformation(DisplayObject _invoker)
    {
        _displayobjet = _invoker;
    }
    public void setIdentity()
    {
    this.TrasnfomM =  Matrix.identity(3,3);
    }
    public void CreateMTrasnformations()
    {
        double [][] TrasnfomMaux={{1,0,0},{0,1,0},{0,0,1}};
        Matrix MTraslate = new Matrix (new double[][] {{ 1,0, _displayobjet.x},{  0, 1, _displayobjet.y},  {0,  0, 1}});
        Matrix MRotate   = new Matrix (new double[][]{{Math.cos(_displayobjet.rotation),-Math.sin(_displayobjet.rotation)},{Math.sin(_displayobjet.rotation),Math.cos(_displayobjet.rotation)}});
        Matrix MScale    = new Matrix (new double[][] {{_displayobjet.scaleX,0 },{0,_displayobjet.y }});
        //Matrix Resultante= new Matrix
    }
    public void product(){
        CreateMTrasnformations();
        if(this._displayobjet.parent != null){


        }
    }
    public PointF getAcumulatedScale(){
        PointF Paux=new PointF(_displayobjet.scaleX,_displayobjet.scaleY);
        Paux.x *=_displayobjet.parent.scaleX;
        Paux.y *=_displayobjet.parent.scaleY;
        return  Paux;
    }
    public void setAcumulatedScale(PointF acumulatedScale ){
       _displayobjet.scaleX= acumulatedScale.x;
        _displayobjet.scaleY=acumulatedScale.y;

    }
    public int getAcumulatedRotation(){
        int aux= _displayobjet.rotation;
        aux +=_displayobjet.parent.rotation;
        if(aux>=360)
            aux-=360;
        return  aux;
    }
    public void setAcumulatedRotation(int acumulatedRotation){
    _displayobjet.rotation=acumulatedRotation;
    }

}
