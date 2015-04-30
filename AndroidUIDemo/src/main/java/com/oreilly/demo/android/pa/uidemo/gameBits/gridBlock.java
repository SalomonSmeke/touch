package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.Square;

/**
 * gridBlock is used to calculate the necessary size of each block in the grid
 * based on the screen size (also manages what to do in case of rotation).
 *
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

    /**
     *
     * @param width width of device
     * @param height height of device
     * @param cordinateX x coordinate
     * @param cordinateY y coordinate
     * @param c
     */
    public gridBlock(int width, int height, int cordinateX, int cordinateY, int [] c){
        this.width = width;
        this.height = height;

        int gridSize = 0;

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            gridLocationX = (int)(width/2.0 - gridSize/2.0);
            gridLocationY = (int)(height/2.0 - gridSize/2.0);

            calcBoxLocation(height, cordinateX, cordinateY);

        } else {
            gridSize = (int)(width - width * percBorder);
            gridLocationX = (int)(width/2.0 - gridSize/2.0);
            gridLocationY = (int)(height/2.0 - gridSize/2.0);

            calcBoxLocation(width, cordinateX, cordinateY);
        }

        this.c = c;
        square = new Square(boxDimension, boxDimension, x, y, c);
    }

    /**
     *
     * @param dimension dimension of the larger grid
     * @param cordinateX x coordinate
     * @param cordinateY y coordinate
     */
    private void calcBoxLocation(int dimension, int cordinateX, int cordinateY){
        boxDimension = (int)((dimension - (dimension * percBorder))/5.0);
        x = gridLocationX + boxDimension * cordinateX;
        y = gridLocationY + boxDimension * cordinateY;
    }

    /**
     *
     * @return drawable square
     */
    public Square getDrawable(){

        return square;
    }

    /**
     *
     * @return base
     */
    public int[] getBase(){
        return new int[]{gridLocationX, gridLocationY};
    }

    /**
     *
     * @return color
     */
    public int [] getColor(){
        return c;
    }
}
