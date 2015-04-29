package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.CircleF;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

/**
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

    public enemy(int [] c){
        this.c = c;
    }

    public void setDraw(int [] coordinates, int boxSize, int [] baseCoordinates){
        this.baseCoordinates = baseCoordinates;
        this.boxSize = boxSize;
        x = (coordinates[0]*boxSize)+boxSize/2+baseCoordinates[0];
        y = (coordinates[1]*boxSize)+boxSize/2+baseCoordinates[1];

        r = boxSize/4;

        circle = new CircleF(r,x,y,c);
    }

    public boolean collide(int xin, int yin){
        if (xin>this.x-boxSize/2 && xin<this.x+boxSize/2 && yin<this.y+boxSize/2 && yin>this.y-boxSize/2){
            return true;
        }
        return false;
    }

    public int[] getColor(){
        return c;
    }

    public void setColor(int [] c){
        this.c = c;
    }

    public DrawableObj getDrawable(){
        return circle;
    }
}
