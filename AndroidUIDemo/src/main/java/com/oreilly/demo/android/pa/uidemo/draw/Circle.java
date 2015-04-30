package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Created by Salomon on 4/29/15.
 */
public class Circle implements DrawableObj {

    private int radius;
    private int x;
    private int y;
    private int[] c;

    /**
     * @param radius of the circle
     * @param x      coordinate
     * @param y      coordinate
     * @param c      is color
     */
    public Circle(int radius, int x, int y, int[] c) {
        this.radius = radius;
        this.c = c;
        this.x = x;
        this.y = y;
    }

    /**
     * @param radius is the radius of the circle.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * @param x x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param c color
     */
    public void setC(int[] c) {
        this.c = c;
    }

    /**
     * @return radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @return color
     */
    public int[] getC() {
        return c;
    }

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
     * @return circle visitor
     */
    public <Result> Result accept(final Visitor<Result> v) {
        return v.onCircle(this);
    }
}

