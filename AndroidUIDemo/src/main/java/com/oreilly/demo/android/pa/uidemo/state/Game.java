package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import android.util.Log;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.gameBits.objectMaster;

import java.util.Vector;

/**
 * Game state is the state that controls the drawing of the game as well as the
 * gameplay itself.
 *
 * Created by Salomon on 4/22/15.
 */
public class Game implements State {

    int difficulty = 0;

    private Vector<DrawableObj> list = new Vector<DrawableObj>();

    /**
     *
     * @param sm state machine
     */
    public Game(final StateView sm) {
        this.sm = sm;
    }

    private final StateView sm;
    private int frame;

    private objectMaster gameView;

    /**
     *
     * @param width width of device
     * @param height height of device
     * @return list of drawable objects
     */
    public Vector<DrawableObj> start(int width, int height)  {
        gameView = new objectMaster(width,height,difficulty);
        list = gameView.init();
        return list;
    }

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return list of drawable objects
     */
    public Vector<DrawableObj> tap( int x, int y)  {
        list.clear();
        list = gameView.tap(x,y);
        if (list == null){
            sm.toEnd(difficulty,frame);
        }
        return list; }

    /**
     *
     * @return list of drawable objects
     */
    public Vector<DrawableObj> tick()  {
        frame ++;
        list.clear();
        list = gameView.tick();
        if (list == null){
            sm.toSelect();
        }
        return list; }

    /**
     *
     * @param bundle bundle, state machine saving
     * @return bundle
     */
    public Bundle save(Bundle bundle) { return bundle; }

    /**
     *
     * @param width width of device
     * @param height height of device
     * @param bundle THE Bundle bundle
     * @return null
     */
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { return null; }

    public void setVar(int []difficulty){this.difficulty = difficulty[0];}
}
