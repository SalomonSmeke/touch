package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Description of DrawableObj
 * DrawableObj is an interface for objects that are drawn on the canvas
 * It also accepts for 'hits' for where the object is in relation to a tap
 * <p/>
 * Created by Salomon on 4/22/15.
 */
public interface DrawableObj {
    boolean hit(int x, int y);

    <Result> Result accept(Visitor<Result> v);
}
