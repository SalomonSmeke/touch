package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Created by Salomon on 4/22/15.
 */
public interface DrawableObj {
    boolean hit(int x, int y);
    <Result> Result accept(Visitor<Result> v);
}
