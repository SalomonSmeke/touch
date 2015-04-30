package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Vector;

/**
 * interface for state
 *
 * Created by Salomon on 4/22/15.
 */
interface State {
    /**
     *
     * @param width width of device
     * @param height height of device
     * @return drawable obj
     */
    Vector<DrawableObj> start(int width, int height);

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return drawable obj
     */
    Vector<DrawableObj>  tap(int x, int y);

    /**
     *
     * @return tick
     */
    Vector<DrawableObj>  tick();

    /**
     *
     * @param bundle THE Bundle bundle
     * @return bundle for saving
     */
    Bundle save(Bundle bundle);

    /**
     *
     * @param width width of device
     * @param height height of device
     * @param bundle THE Bundle bundle
     * @return drawable object
     */
    Vector<DrawableObj> load(int width, int height, Bundle bundle);

    /**
     *
     * @param var for saving
     */
    void setVar(int var);
}
