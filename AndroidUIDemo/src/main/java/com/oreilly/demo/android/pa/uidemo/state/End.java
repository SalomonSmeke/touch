package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.Circle;
import com.oreilly.demo.android.pa.uidemo.draw.CircleF;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Vector;

/**
 * The end state is the end of the game.
 *
 * Created by Salomon on 4/22/15.
 */
public class End implements State {

    public End(final StateView sm) {
        this.sm = sm;
    }
    private int width;
    private int height;
    private int difficulty;
    private int remainingFrames = 0;

    private DrawableObj[] circles;

    private Vector<DrawableObj> drawMe = new Vector<DrawableObj>();

    private final StateView sm;

    /**
     *
     * @param width width of screen
     * @param height height of screen
     * @return null
     */
    public Vector<DrawableObj> start(int width, int height)  {
        this.width = width;
        this.height = height;
        float percBorder = .1f;
        int gridSize = 0;

        circles = new DrawableObj[difficulty+1];

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            int gridLocation = (int)(width/2.0 - gridSize/2.0);

            int circleSize = (int)(gridSize/5/4);
            int circlePosY = (int)(height/2.0);
            int circlePosX = gridLocation + gridSize + gridLocation/2;

            if (circles.length == 1){
                circles[0] = new CircleF(circleSize,circlePosX,circlePosY,new int[]{255,250,172,152});
            }
            if (circles.length == 2){
                circles[0] = new CircleF(circleSize,circlePosX,circlePosY-gridSize/10,new int[]{255,184,125,143});
                circles[1] = new CircleF(circleSize,circlePosX,circlePosY+gridSize/10,new int[]{255,208,247,244});
            }
            if (circles.length == 3){
                circles[0] = new CircleF(circleSize,circlePosX,circlePosY-gridSize/5,new int[]{255,184,125,143});
                circles[1] = new Circle(circleSize,circlePosX,circlePosY+gridSize/5,new int[]{255,255,255,255});
                circles[2] = new CircleF(circleSize,circlePosX,circlePosY,new int[]{255,250,172,152});
            }
        } else {
            gridSize = (int)(width - width * percBorder);
            int gridLocation = (int)(height/2.0 - gridSize/2.0);

            int circleSize = (int)(width * percBorder/2);
            int circlePosY = (int)(width/2.0);
            int circlePosX = gridLocation + gridSize + gridLocation/2;

            if (circles.length == 1){
                circles[0] = new CircleF(circleSize,circlePosY,circlePosX,new int[]{255,250,172,152});
            }
            if (circles.length == 2){
                circles[0] = new CircleF(circleSize,circlePosY-gridSize/10,circlePosX,new int[]{255,184,125,143});
                circles[1] = new CircleF(circleSize,circlePosY+gridSize/10,circlePosX,new int[]{255,208,247,244});
            }
            if (circles.length == 3){
                circles[0] = new CircleF(circleSize,circlePosY-gridSize/5,circlePosX,new int[]{255,184,125,143});
                circles[1] = new Circle(circleSize,circlePosY+gridSize/5,circlePosX,new int[]{255,255,255,255});
                circles[2] = new CircleF(circleSize,circlePosY,circlePosX,new int[]{255,250,172,152});
            }
        }
        for (int i = 0; i<circles.length; i++){
            drawMe.add(circles[i]);
        }
        return drawMe;
    }

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return null
     */
    public Vector<DrawableObj> tap( int x, int y)  { return drawMe; }

    /**
     *
     * @return null
     */
    public Vector<DrawableObj> tick()  { return drawMe; }

    /**
     * used for saving the state
     *
     * @param bundle THE Bundle bundle
     * @return bundle
     */
    public Bundle save(Bundle bundle) { return bundle; }

    /**
     *
     * @param width width of screen
     * @param height height of screen
     * @param bundle THE Bundle bundle
     * @return null
     */
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { return null; }

    /**
     *
     * @param x x coordinate
     */
    public void setVar(int []x){
        difficulty = x[0];
        remainingFrames = x[1];


    }
}
