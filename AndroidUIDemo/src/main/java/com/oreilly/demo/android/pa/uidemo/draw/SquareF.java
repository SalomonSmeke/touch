package com.oreilly.demo.android.pa.uidemo.draw;

/** Description of SquareF
 * SquareF is the same as Square, but filed.
 * Created by Salomon on 4/22/15.
 */
public class SquareF implements DrawableObj {

    private int width;
    private int height;
    private int x;
    private int y;
    private int[] c;

    public SquareF(int width, int height, int x, int y, int[] c){
        this.width = width;
        this.height = height;
        this.c = c;
        this.x = x;
        this.y = y;
    }

    public boolean hit(int x, int y){
        return false;
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

    public void setC (int[] c) { this.c = c; }

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

    public int[] getC () { return c; }

    public <Result> Result accept(final Visitor<Result> v) {
        return v.onSquareF(this);
    }
}
