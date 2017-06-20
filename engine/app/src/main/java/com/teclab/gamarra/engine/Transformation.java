package com.teclab.gamarra.engine;

import org.ejml.simple.SimpleMatrix;

/**
 * Created by Alumno on 13/06/2017.
 */

public class Transformation extends java.lang.Object {

   private DisplayObject _displayobjet;

    public Transformation(DisplayObject _invoker){
        _displayobjet=_invoker;
    }
void CreateMTrasnformations(){
    SimpleMatrix traslate=new SimpleMatrix() { { 1, 0, _displayobjet.x }, { 0, 1, _displayobjet.y },  { 0,  0, 1 } });

    SimpleMatrix rotate=new SimpleMatrix(3,3);
}

}
