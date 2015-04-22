package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Created by Salomon on 4/22/15.
 */
public class Square implements DrawShape {


    public <Result> Result accept(final Visitor<Result> v) {
        return v.onSquare(this);
    }
}
