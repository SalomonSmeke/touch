package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Created by Salomon on 4/22/15.
 */
public class Square implements DrawableObj {

    private int width;
    private int height;
    private int x;
    private int y;

    public Square(int width, int height, int x, int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void setWidth (int width){
        this.width = width;
    }

    public void setHeight (int height){
        this.height = height;
    }

    public void setX (int x){
        this.x = x;
    }

    public void setY (int y){
        this.y = y;
    }

    public int getWidth (){
        return width;
    }

    public int getHeight (){
        return height;
    }

    public int getY (){
        return y;
    }

    public int getX (){
        return x;
    }

    public <Result> Result accept(final Visitor<Result> v) {
        return v.onSquare(this);
    }
}
