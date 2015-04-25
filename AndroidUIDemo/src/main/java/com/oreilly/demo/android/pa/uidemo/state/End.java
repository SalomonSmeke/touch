package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Vector;

/**
 * Created by Salomon on 4/22/15.
 */
public class End implements State {

    public End(final StateView sm) {
        this.sm = sm;
    }

    private final StateView sm;

    public Vector<DrawableObj> start(int width, int height)  { return null; }
    public Vector<DrawableObj> tap( int x, int y)  { return null; }
    public Vector<DrawableObj> tick()  { return null; }
    public Bundle save(Bundle bundle) { return bundle; }
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { return null; }
}
