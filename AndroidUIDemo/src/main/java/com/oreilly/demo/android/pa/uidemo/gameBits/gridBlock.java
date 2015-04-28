package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.Line;

/**
 * Created by Thomas on 4/26/15.
 */
public class gridBlock {
    //Screen dimensions
    private int width;
    private int height;

    //Locations
    public int gridLocationX = 0;
    public int gridLocationY = 0;
    public int x = 0;
    public int y = 0;

    //Values
    public float percBorder = (float).1;

    public void setPlaces(int width, int height, int cordinateX, int cordinateY){
        this.width = width;
        this.height = height;

        int gridSize = 0;

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            gridLocationX = (int)(width/2.0 - gridSize/2.0);
            gridLocationY = (int)(percBorder);

            calcBoxLocation(height, cordinateX, cordinateY);
        } else {
            gridSize = (int)(width - width * percBorder);
            gridLocationX = (int)(height/2.0 - gridSize/2.0);
            gridLocationY = (int)(percBorder);

            calcBoxLocation(width, cordinateX, cordinateY);
        }
    }

    private void calcBoxLocation(int dimension, int cordinateX, int cordinateY){
        int boxDimension = (int)((dimension - (dimension * percBorder) * 2)/5);
        if(cordinateX == 0){
            x = 0;
            y = boxDimension*cordinateY;
        }
        else{
            x = boxDimension*cordinateX;
            y = 0;
        }
    }
}
