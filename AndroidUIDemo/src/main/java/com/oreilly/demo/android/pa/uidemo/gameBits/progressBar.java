package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Line;

import java.util.Vector;

/**
 * The progressBar is displayed about the grid and is designed to shorten as the game's
 * time winds down. It remains centered while it shortens to indicate how much gameplay
 * time is left.
 *
 * Created by Salomon on 4/26/15.
 */
public class progressBar {

    //Screen dimensions
    private int width;
    private int height;

    //Box
    private Line line;

    //Locations
    private int gridLocation = 0;

    //Values
    private float percBorder = (float).1;
    private int linePos;
    private int minLengthLine;
    private int maxLengthLine;
    private int lineSize;

    public final int fps = 50;

    private int frame = 0;
    private int cycle = 0;

    private int maxCycle = 50;

    /**
     *
     * @param width width of device
     * @param height height of device
     * @param c color for the bar
     */
    public progressBar(int width, int height, int []c, int difficulty){
        this.width = width;
        this.height = height;

        maxCycle = maxCycle - difficulty*10;

        int gridSize = 0;

        if (width > height){
            gridSize = (int)(height - height * percBorder);
            gridLocation = (int)(width/2.0 - gridSize/2.0);
            minLengthLine = (int)(height * percBorder / 2);
            maxLengthLine = (int)(height - height * percBorder / 2);
            linePos = gridLocation/3;
            line = new Line(linePos,linePos,minLengthLine,maxLengthLine,c);
        } else {
            gridSize = (int)(width - width * percBorder);
            gridLocation = (int)(height/2.0 - gridSize/2.0);
            minLengthLine = (int)(width * percBorder / 2);
            maxLengthLine = (int)(width - width * percBorder / 2);
            linePos = gridLocation/3;
            line = new Line(minLengthLine,maxLengthLine,linePos,linePos,c);
        }
    }

    /**
     *
     * @return drawable object
     */
    public Vector<DrawableObj> tap(){
        Vector<DrawableObj> d = new Vector<DrawableObj>();
        d.clear();
        d.add(line);
        return d;
    }

    /**
     *
     * @return tick the screen frames per tick
     */
    public Vector<DrawableObj> tick(){
        frame++;
        if (cycle >= maxCycle-1){
            return null;
        }
        if (frame > maxCycle){
            cycle++;
            resize();
            frame = 0;
        }
        Vector<DrawableObj> d = new Vector<DrawableObj>();
        d.clear();
        d.add(line);
        return d;
    }

    /**
     * resize the bar depending on tick cycle
     */
    public void resize(){
        if (line.getX1() == line.getX2()){
            line.setY1(line.getY1() + maxLengthLine/maxCycle/2);
            line.setY2(line.getY2() - maxLengthLine / maxCycle / 2);
        } else {
            line.setX1(line.getX1() + (maxLengthLine / maxCycle) / 2);
            line.setX2(line.getX2() - (maxLengthLine / maxCycle) / 2);
        }
    }

}
