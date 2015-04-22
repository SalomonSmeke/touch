package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Created by Salomon on 4/22/15.
 */
public class Sprite implements DrawableObj {


    public <Result> Result accept(final Visitor<Result> v) {
        return v.onSprite(this);
    }
}
