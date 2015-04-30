package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Description of Square
 * Square is designed to draw a square object of defined width and height beginning at (x,y) and of color c
 * Created by Salomon on 4/22/15.
 */
public class Square implements DrawableObj {

    private int width;
    private int height;
    private int x;
    private int y;
    private int[] c;

    /**
     * @param width  square width
     * @param height square height
     * @param x      x coordinate
     * @param y      y coordinate
     * @param c      color
     */
    public Square(int width, int height, int x, int y, int[] c) {
        this.width = width;
        this.height = height;
        this.c = c;
        this.x = x;
        this.y = y;
    }

    /**
     * @param width width of square
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height height of square
     */
    public void setHeight(int height) {
        this.height = height;
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
     * @return width of square
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return height of square
     */
    public int getHeight() {
        return height;
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
     * @return visitor object
     */
    public <Result> Result accept(final Visitor<Result> v) {
        return v.onSquare(this);
    }
}
