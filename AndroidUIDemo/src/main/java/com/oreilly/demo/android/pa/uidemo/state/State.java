package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Vector;

/**
 * Created by Salomon on 4/22/15.
 */
interface State {
    Vector<DrawableObj> start(int width, int height);
    Vector<DrawableObj>  tap(int x, int y);
    Vector<DrawableObj>  tick();
    Bundle save(Bundle bundle);
    Vector<DrawableObj> load(int width, int height, Bundle bundle);
}
