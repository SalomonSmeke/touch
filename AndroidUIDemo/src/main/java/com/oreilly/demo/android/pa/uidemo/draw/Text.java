package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Description of Text
 * Text is designed to print text to the screen
 * <p/>
 * Created by Salomon on 4/22/15.
 */
public class Text implements DrawableObj {

    /**
     * @param x x coordinate
     * @param y y coordinate
     * @return false
     */
    public boolean hit(int x, int y) {
        return false;
    }

    /**
     * @param v        visitor
     * @param <Result> object type
     * @return visitor object
     */
    public <Result> Result accept(final Visitor<Result> v) {
        return v.onText(this);
    }
}
