package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.SquareF;

import java.util.Vector;

/**
 * Created by Salomon on 4/26/15.
 */
public class progressBar {

    //Screen dimensions
    private int width;
    private int height;

    //Box
    private SquareF line;

    //Locations
    public int gridLocation = 0;

    //Values
    public float percBorder = (float).1;
    public int lineX;
    public int minY;
    public int maxY;
    public int lineSize;

    public progressBar(int width, int height){
        this.width = width;
        this.height = height;

        int gridSize = 0;

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            gridLocation = (int)(width/2.0 - gridSize/2.0);
            minY = (int)(height * percBorder / 2);
            maxY = (int)(height - height * percBorder / 2);

        } else {
            gridSize = (int)(width - width * percBorder);
            gridLocation = (int)(height/2.0 - gridSize/2.0);
            minY = (int)(width * percBorder / 2);
            maxY = (int)(width - width * percBorder / 2);
        }

        lineX = gridLocation/2;




    }

    public Vector<DrawableObj> tap(){
        Vector<DrawableObj> d = new Vector<DrawableObj>();
        d.clear();
        d.add(line);
        return d;
    }

    public Vector<DrawableObj> tick(){
        Vector<DrawableObj> d = new Vector<DrawableObj>();
        d.clear();
        d.add(line);
        return d;
    }

}
