package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

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

    private final StateView sm;

    /**
     *
     * @param width width of screen
     * @param height height of screen
     * @return null
     */
    public Vector<DrawableObj> start(int width, int height)  { return null; }

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return null
     */
    public Vector<DrawableObj> tap( int x, int y)  { return null; }

    /**
     *
     * @return null
     */
    public Vector<DrawableObj> tick()  { return null; }

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
    public void setVar(int x){}
}
