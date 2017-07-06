package com.teclab.gamarra.engine;

import android.graphics.Point;
import android.graphics.PointF;

import java.security.cert.PolicyNode;

import Jama.Matrix;


/**
 * Created by Alumno on 13/06/2017.
 */

public class Transformation extends java.lang.Object {

    private DisplayObject _displayobjet;
    private Matrix TrasnformM;
    private PointF acumulatedScale;
    private int acumulatedRotation;
    private float acmulatedOpacidad;


    public Transformation(DisplayObject displayObject) {
        this._displayobjet = displayObject;
    }

    public void setIdentity() {
        this.TrasnformM = Matrix.identity(3, 3);
    }

    public void CreateMTrasnformations() {
        Matrix TrasnfomMaux = new Matrix(new double[][]{{Math.cos(Math.toRadians(_displayobjet.rotation)), -Math.sin(Math.toRadians(_displayobjet.rotation)), _displayobjet.x}, {Math.sin(Math.toRadians(_displayobjet.rotation)), Math.cos(Math.toRadians(_displayobjet.rotation)), _displayobjet.y}, {0, 0, 1}});
        this.TrasnformM = TrasnfomMaux;
        this.acumulatedScale = new PointF(this._displayobjet.scaleX, _displayobjet.scaleY);
        this.acumulatedRotation = this._displayobjet.rotation;
        this.acmulatedOpacidad = this._displayobjet.opacity;

    }

    public void product() {
        CreateMTrasnformations();
        if (this._displayobjet.parent != null) {
            Matrix prductoT = this._displayobjet.parent.transformation.TrasnformM;
            this.acumulatedRotation += this._displayobjet.parent.transformation.getAcumulatedRotation();
            this.acumulatedScale.x *= this._displayobjet.parent.transformation.getAcumulatedScale().x;
            this.acumulatedScale.y *= this._displayobjet.parent.transformation.getAcumulatedScale().y;
            this.acmulatedOpacidad *= this._displayobjet.parent.transformation.getAcumulatedOpacity();
            this.TrasnformM = prductoT.times(this.TrasnformM);

        }
    }

    public PointF getAcumulatedScale() {
        return this.acumulatedScale;
    }

    public void setAcumulatedScale(PointF acumulatedScale) {
        this.acumulatedScale = acumulatedScale;
    }

    public int getAcumulatedRotation() {
        return this.acumulatedRotation;
    }

    public void setAcumulatedRotation(int acumulatedRotation) {
        this.acumulatedRotation = acumulatedRotation;
    }

    public float getAcumulatedOpacity() {
       return this.acmulatedOpacidad;
    }
    public void setAcumulatedOpacity(float acmulatedOpacidad ) {
         this.acmulatedOpacidad=acmulatedOpacidad;
    }
    public Point localToGlobal(int x, int y){
        double [][] corde={{x},{y},{1}};
        Matrix gPoint = this.TrasnformM.times(new Matrix(corde));
        corde=gPoint.getArray();
        return  new Point((int)corde[0][0],(int)corde[1][0]);
    }
    public Point globalToLocal(int x,int y){
        double [][] corde={{x},{y},{1}};
        Matrix lPonit = this.TrasnformM.inverse().times(new Matrix(corde));
        corde=lPonit.getArray();
        return  new Point((int)corde[0][0],(int)corde[1][0]);
    }
public Point globalPosition(){
    double [][] cord =  this.TrasnformM.getArray();
    return new Point((int)cord[0][2],(int)cord[1][2] );
}
public void dispose(){
    this.TrasnformM=null;
}

}

