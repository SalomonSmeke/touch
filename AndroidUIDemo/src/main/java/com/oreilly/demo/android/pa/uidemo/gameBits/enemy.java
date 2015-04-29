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

    public enemy(int [] c){
        this.c = c;
    }

    public void setDraw(int [] coordinates, int boxSize, int [] baseCoordinates){
        x = (coordinates[0]*boxSize)+boxSize/2+baseCoordinates[0];
        y = (coordinates[1]*boxSize)+boxSize/2+baseCoordinates[1];

        r = boxSize/4;

        circle = new CircleF(r,x,y,c);
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
