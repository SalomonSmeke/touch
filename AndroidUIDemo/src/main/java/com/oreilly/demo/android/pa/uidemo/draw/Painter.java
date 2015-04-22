package com.oreilly.demo.android.pa.uidemo.draw;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Salomon on 4/22/15.
 */
public class Painter implements Visitor<Void>{

    private final Canvas canvas;
    private final Paint paint = new Paint();

    public Painter(final Canvas canvas){
        this.canvas = canvas;
        paint.setStyle(Paint.Style.STROKE);
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
        canvas.drawRect(left,top,right,bottom,paint);

        return null;
    }

    public Void onText(Text t){


        return null;
    }


}
