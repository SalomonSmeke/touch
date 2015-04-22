package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Created by Salomon on 4/22/15.
 */
public class Square implements DrawableObj {

    private int width;
    private int height;

    public Square(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setWidth (int width){
        this.width = width;
    }

    public void setHeight (int height){
        this.height = height;
    }

    public int getWidth (){
        return width;
    }

    public int getHeight (){
        return height;
    }

    public <Result> Result accept(final Visitor<Result> v) {
        return v.onSquare(this);
    }
}
