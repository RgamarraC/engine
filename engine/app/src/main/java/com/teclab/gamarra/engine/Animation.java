package com.teclab.gamarra.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 13/06/2017.
 */

public class Animation extends DisplayObject {

   public int currentFrame;
   public int frameReturn;
   public int numFrames;
   public boolean ended;
   public boolean loop;
   public boolean pause;
   public boolean reverse;
    private List<Frame> frames= new ArrayList<>();
   private Resources resources;



}
