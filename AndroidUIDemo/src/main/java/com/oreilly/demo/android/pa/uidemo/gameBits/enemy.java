package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.CircleF;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

/**
 * The enemy class is designed to draw and manage the enemies or 'monsters' as they appear
 * and move about the screen.
 *
 * Created by Salomon on 4/26/15.
 */
public class enemy {

    private int [] c;
    private int x;
    private int y;
    private int r;
    private CircleF circle;
    private int []baseCoordinates;
    private int boxSize;

    /**
     *
     * @param c color
     */
    public enemy(int [] c){
        this.c = c;
    }

    /**
     *
     * @param coordinates x and y coordinates
     * @param boxSize size of the box in the grid
     * @param baseCoordinates coordinate of the base
     */
    public void setDraw(int [] coordinates, int boxSize, int [] baseCoordinates){
        this.baseCoordinates = baseCoordinates;
        this.boxSize = boxSize;
        x = (coordinates[0]*boxSize)+boxSize/2+baseCoordinates[0];
        y = (coordinates[1]*boxSize)+boxSize/2+baseCoordinates[1];

        r = boxSize/4;

        circle = new CircleF(r,x,y,c);
    }

    /**
     *
     * @param xin x coordinate
     * @param yin y coordinate
     * @return
     */
    public boolean collide(int xin, int yin){
        if (xin>this.x-boxSize/2 && xin<this.x+boxSize/2 && yin<this.y+boxSize/2 && yin>this.y-boxSize/2){
            return true;
        }
        return false;
    }

    /**
     *
     * @return color
     */
    public int[] getColor(){
        return c;
    }

    /**
     *
     * @param c color
     */
    public void setColor(int [] c){
        circle = new CircleF(r,x,y,c);
        this.c = c;
    }

    /**
     *
     * @return drawable circle object (the enemy itself)
     */
    public DrawableObj getDrawable(){
        return circle;
    }
}
