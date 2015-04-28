package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.Square;

/**
 * Created by Thomas on 4/26/15.
 */
public class gridBlock {
    //Screen dimensions
    private int width;
    private int height;

    //Locations
    private int gridLocationX = 0;
    private int gridLocationY = 0;
    private int x = 0;
    private int y = 0;

    private Square square;

    //Values
    private float percBorder = (float).1;
    private int boxDimension;
    private int[] c;

    public void setPlaces(int width, int height, int cordinateX, int cordinateY){
        this.width = width;
        this.height = height;

        int gridSize = 0;

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            gridLocationX = (int)(width/2.0 - gridSize/2.0);
            gridLocationY = (int)(height * percBorder);

            calcBoxLocation(height, cordinateX, cordinateY);
        } else {
            gridSize = (int)(width - width * percBorder);
            gridLocationX = (int)(height/2.0 - gridSize/2.0);
            gridLocationY = (int)(width * percBorder);

            calcBoxLocation(width, cordinateX, cordinateY);
        }

        square = new Square(boxDimension, boxDimension, x, y, c);
    }

    private void calcBoxLocation(int dimension, int cordinateX, int cordinateY){
        boxDimension = (int)((dimension - (dimension * percBorder) * 2)/5);
        x = gridLocationX + boxDimension * cordinateX;
        y = gridLocationY + boxDimension * cordinateY;
    }

    public Square getDrawable(){

        return square;
    }

    public void setColor(int[]colors){
        c = colors;
    }
}
