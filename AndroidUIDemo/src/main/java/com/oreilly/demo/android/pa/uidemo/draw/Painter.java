package com.oreilly.demo.android.pa.uidemo.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Salomon on 4/22/15.
 */
public class Painter implements Visitor<Void>{

    private static Canvas canvas;
    private Paint paint = new Paint();

    public Painter(final Canvas canvas){
        this.canvas = canvas;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(android.graphics.Color.WHITE);
    }

    public Void onLine(Line l){


        return null;
    }

    public Void onSprite(Sprite sp){


        return null;
    }

    public Void onSquare(Square sq){
        float top = sq.getY();
        float bottom = sq.getY()+sq.getHeight();
        float left = sq.getX();
        float right = sq.getX()+sq.getWidth();
        int [] c = sq.getC();
        paint.setStyle(Paint.Style.STROKE);
        paint.setARGB(c[0],c[1],c[2],c[3]);
        canvas.drawRect(left,top,right,bottom,paint);
        return null;
    }

    public Void onSquareF(SquareF sq){
        float top = sq.getY();
        float bottom = sq.getY()+sq.getHeight();
        float left = sq.getX();
        float right = sq.getX()+sq.getWidth();
        int [] c = sq.getC();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setARGB(c[0],c[1],c[2],c[3]);
        canvas.drawRect(left,top,right,bottom,paint);
        return null;
    }

    public Void onCircleF(CircleF ci){
        int [] c = ci.getC();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setARGB(c[0],c[1],c[2],c[3]);
        canvas.drawCircle(ci.getX(),ci.getY(),ci.getRadius(),paint);
        return null;
    }

    public Void onText(Text t){


        return null;
    }


}
