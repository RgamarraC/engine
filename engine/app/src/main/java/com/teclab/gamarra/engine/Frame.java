package com.teclab.gamarra.engine;

/**
 * Created by Alumno on 27/06/2017.
 */

public class Frame extends java.lang.Object {
    int	offsetX;//Medida extra que se le debe agregar a width para tener la medida real del ancho del frame.
    int	offsetY;//Medida extra que se le debe agregar a height para tener la medida real del ancho del frame.
    int	height;//alto del frame
    int	width;//ancho del frame
    int	x;
    int	y;
    Frame(int _x, int _y, int _width, int _height){
        x=_x;
        y=_y;
        width=_width;
        height=_height;
    }
    Frame(int _x, int _y, int _width, int _height, int _offsetX, int _offsetY){
        x=_x;
        y=_y;
        width=_width;
        height=_height;
        offsetX=_offsetX;
        offsetY=_offsetY;
    }

}
