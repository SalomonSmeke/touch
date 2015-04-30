package com.oreilly.demo.android.pa.uidemo.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Description of Painter
 * Painter is designed to paint the different objects that the visitor accepts to the canvas
 * <p/>
 * Created by Salomon on 4/22/15.
 */
public class Painter implements Visitor<Void> {

    private static Canvas canvas;
    private Paint paint = new Paint();

    /**
     * @param canvas painting canvas for the whole app
     */
    public Painter(final Canvas canvas) {
        this.canvas = canvas;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(android.graphics.Color.WHITE);
    }

    /**
     * @param l line
     * @return state machine stuff
     */
    public Void onLine(Line l) {
        int[] c = l.getC();
        paint.setARGB(c[0], c[1], c[2], c[3]);
        paint.setStrokeWidth(25);
        canvas.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2(), paint);
        paint.setStrokeWidth(5);
        return null;
    }

    /**
     * @param sp sprite
     * @return state machine stuff
     */
    public Void onSprite(Sprite sp) {


        return null;
    }

    /**
     * @param sq square
     * @return state machine stuff
     */
    public Void onSquare(Square sq) {
        float top = sq.getY();
        float bottom = sq.getY() + sq.getHeight();
        float left = sq.getX();
        float right = sq.getX() + sq.getWidth();
        int[] c = sq.getC();
        paint.setStyle(Paint.Style.STROKE);
        paint.setARGB(c[0], c[1], c[2], c[3]);
        canvas.drawRect(left, top, right, bottom, paint);
        return null;
    }

    /**
     * @param sq square with fill
     * @return state machine stuff
     */
    public Void onSquareF(SquareF sq) {
        float top = sq.getY();
        float bottom = sq.getY() + sq.getHeight();
        float left = sq.getX();
        float right = sq.getX() + sq.getWidth();
        int[] c = sq.getC();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setARGB(c[0], c[1], c[2], c[3]);
        canvas.drawRect(left, top, right, bottom, paint);
        return null;
    }

    /**
     * @param ci circle with fill
     * @return state machine stuff
     */
    public Void onCircleF(CircleF ci) {
        int[] c = ci.getC();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setARGB(c[0], c[1], c[2], c[3]);
        canvas.drawCircle(ci.getX(), ci.getY(), ci.getRadius(), paint);
        return null;
    }

    /**
     * @param ci circle
     * @return state machine stuff
     */
    public Void onCircle(Circle ci) {
        int[] c = ci.getC();
        paint.setStyle(Paint.Style.STROKE);
        paint.setARGB(c[0], c[1], c[2], c[3]);
        canvas.drawCircle(ci.getX(), ci.getY(), ci.getRadius(), paint);
        return null;
    }

    /**
     * @param t text
     * @return state machine stuff
     */
    public Void onText(Text t) {
        int [] c = t.getC();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setARGB(c[0], c[1], c[2], c[3]);
        paint.setTextSize(t.getTextSize());
        canvas.drawText(t.getText(), t.getX(), t.getY(), paint);
        return null;
    }


}
