package com.oreilly.demo.android.pa.uidemo.draw;

/** Description of Text
 * Text is designed to print text to the screen
 *
 * Created by Salomon on 4/22/15.
 */
public class Text implements DrawableObj {


    public boolean hit(int x, int y){
        return false;
    }
    public <Result> Result accept(final Visitor<Result> v) {
        return v.onText(this);
    }
}
