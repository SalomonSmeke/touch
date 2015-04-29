package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.CircleF;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Line;

import java.util.Vector;

/**
 * Created by Salomon on 4/26/15.
 */
public class difficultyDisplay {

    private Vector<DrawableObj> drawMe = new Vector<DrawableObj>();

    //Screen dimensions
    private int width;
    private int height;

    //Box
    private CircleF [] circles;

    //Locations
    private int gridLocation = 0;

    //Values
    private float percBorder = (float).1;
    private int circlePosY;
    private int circlePosX;
    private int circleSize;


    public difficultyDisplay(int width, int height, int difficulty){
        this.width = width;
        this.height = height;

        int gridSize = 0;

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            gridLocation = (int)(width/2.0 - gridSize/2.0);

            circleSize = (int)(height * percBorder / 4);
            circlePosY = (int)(height/2.0) - circleSize;
            circlePosX = gridLocation + gridSize + gridSize/2;
            circles = new CircleF[difficulty+1];
            for (int i = 0; i < difficulty+1; i++){
                circles[i] = new CircleF(circleSize,circlePosX,circlePosY+circleSize*i,new int[]{255,255,100,100});
            }
        } else {
            gridSize = (int)(width - width * percBorder);
            gridLocation = (int)(height/2.0 - gridSize/2.0);
            circlePosY = (int)(width/2.0);
            circleSize = (int)(width * percBorder / 2);
            circlePosX = gridLocation + gridSize + gridSize/2;
            for (int i = 0; i < difficulty+1; i++){
                circles[i] = new CircleF(circleSize,circlePosX,circlePosY+circleSize*i,new int[]{255,255,100,100});
            }
        }
        for (int i = 0; i<circles.length; i++){
            drawMe.add(circles[i]);
        }
    }

    public Vector<DrawableObj> tap(){
        return drawMe;
    }

    public Vector<DrawableObj> tick(){
        return drawMe;
    }

}
