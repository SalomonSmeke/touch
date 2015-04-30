package com.oreilly.demo.android.pa.uidemo.draw;

/** Description of Sprite
 * Sprite is used to create an object using a created sprite file
 *
 * Created by Salomon on 4/22/15.
 */
public class Sprite implements DrawableObj {

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     * @return
     */
    public boolean hit(int x, int y){
        return false;
    }

    /**
     *
     * @param v visitor
     * @param <Result> object type
     * @return visitor object
     */
    public <Result> Result accept(final Visitor<Result> v) {
        return v.onSprite(this);
    }
}
