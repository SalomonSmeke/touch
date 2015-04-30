package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * Description of Text
 * Text is designed to print text to the screen
 * <p/>
 * Created by Thomas on 4/22/15.
 */
public class Text implements DrawableObj {


    private int textSize;
    private String text;
    private int x;
    private int y;
    private int[] c;

    /**
     * @param x      coordinate
     * @param y      coordinate
     * @param c      is color
     */
    public Text(String text, int x, int y, int[] c, int textSize) {
        this.text = text;
        this.textSize = textSize;
        this.x = x;
        this.y = y;
        this.c = c;
    }


    public void setText(String text){
        this.text = text;

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

    public String getText() { return text;}

    /**
     * @return textSize
     */
    public int getTextSize() {
        return textSize;
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
        return v.onText(this);
    }
}
