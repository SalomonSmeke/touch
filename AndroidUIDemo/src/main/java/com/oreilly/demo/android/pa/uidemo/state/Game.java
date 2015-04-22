package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Vector;

/**
 * Created by Salomon on 4/22/15.
 */
public class Game extends State {
    public Vector<DrawableObj> start(int width, int height)  { return null; }
    public void tap()  { }
    public void tick()  { }
    public Bundle save(Bundle bundle) { return bundle; }
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { return null; }
}
