package com.oreilly.demo.android.pa.uidemo.draw;

/** Description of CircleF
 * CircleF is a class designed to create a circle with a fill
 *
 * @author Salomon Smeke
 *
 */
public class CircleF implements DrawableObj {

    private int radius;
    private int x;
    private int y;
    private int[] c;

    public CircleF(int radius, int x, int y, int[] c){
        this.radius = radius;
        this.c = c;
        this.x = x;
        this.y = y;
    }

    public void setRadius (int radius){
        this.radius = radius;
    }

    public void setX (int x){
        this.x = x;
    }

    public void setY (int y){
        this.y = y;
    }

    public void setC (int[] c) { this.c = c; }

    public int getRadius (){
        return radius;
    }

    public int getY (){
        return y;
    }

    public int getX (){
        return x;
    }

    public int[] getC () { return c; }

    public boolean hit(int x, int y){
        return false;
    }

    public <Result> Result accept(final Visitor<Result> v) {
        return v.onCircleF(this);
    }
}
