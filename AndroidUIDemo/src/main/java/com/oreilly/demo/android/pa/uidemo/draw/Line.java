package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Description of Line
 * Line is a basic class that draws a line from coordinate to coordinte of any color
 * <p/>
 * Created by Salomon on 4/22/15.
 */
public class Line implements DrawableObj {

    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;
    private int[] c;

    /**
     * @param x1 x coordinate 1
     * @param x2 x coordinate 2
     * @param y1 y coordinate 1
     * @param y2 y coordinate 2
     * @param c  color
     */
    public Line(int x1, int x2, int y1, int y2, int[] c) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.c = c;
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
     * @param x1 x coordinate 1
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @param x2 x coordinate 2
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @param y1 y coordinate 1
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @param y2 y coordinate 2
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @return x coordinate 1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @return x coordinate 2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @return y coordinate 1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @return y coordinate 2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @return color
     */
    public int[] getC() {
        return c;
    }


    /**
     * @param v        visitor
     * @param <Result> object type
     * @return visitor object
     */
    public <Result> Result accept(final Visitor<Result> v) {
        return v.onLine(this);
    }
}
