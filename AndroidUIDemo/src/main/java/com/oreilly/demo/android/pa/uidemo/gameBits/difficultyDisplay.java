package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.CircleF;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

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

        circles = new CircleF[difficulty+1];

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            gridLocation = (int)(width/2.0 - gridSize/2.0);

            circleSize = (int)(gridSize/5/4);
            circlePosY = (int)(height/2.0);
            circlePosX = gridLocation + gridSize + gridLocation/2;

            if (circles.length == 1){
                circles[0] = new CircleF(circleSize,circlePosX,circlePosY,new int[]{255,250,172,152});
            }
            if (circles.length == 2){
                circles[0] = new CircleF(circleSize,circlePosX,circlePosY-gridSize/5,new int[]{255,184,125,143});
                circles[1] = new CircleF(circleSize,circlePosX,circlePosY+gridSize/5,new int[]{255,208,247,244});
            }
            if (circles.length == 3){
                circles[0] = new CircleF(circleSize,circlePosX,circlePosY-gridSize/5,new int[]{255,184,125,143});
                circles[1] = new CircleF(circleSize,circlePosX,circlePosY+gridSize/5,new int[]{255,208,247,244});
                circles[2] = new CircleF(circleSize,circlePosX,circlePosY,new int[]{255,250,172,152});
            }
        } else {
            gridSize = (int)(width - width * percBorder);
            gridLocation = (int)(height/2.0 - gridSize/2.0);

            circleSize = (int)(width * percBorder/2);
            circlePosY = (int)(width/2.0);
            circlePosX = gridLocation + gridSize + gridLocation/2;

            if (circles.length == 1){
                circles[0] = new CircleF(circleSize,circlePosY,circlePosX,new int[]{255,250,172,152});
            }
            if (circles.length == 2){
                circles[0] = new CircleF(circleSize,circlePosY-gridSize/10,circlePosX,new int[]{255,184,125,143});
                circles[1] = new CircleF(circleSize,circlePosY+gridSize/10,circlePosX,new int[]{255,208,247,244});
            }
            if (circles.length == 3){
                circles[0] = new CircleF(circleSize,circlePosY-gridSize/5,circlePosX,new int[]{255,184,125,143});
                circles[1] = new CircleF(circleSize,circlePosY+gridSize/5,circlePosX,new int[]{255,208,247,244});
                circles[2] = new CircleF(circleSize,circlePosY,circlePosX,new int[]{255,250,172,152});
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
