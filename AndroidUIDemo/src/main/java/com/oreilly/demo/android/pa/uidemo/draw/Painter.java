package com.oreilly.demo.android.pa.uidemo.draw;

import android.graphics.Canvas;

/**
 * Created by Salomon on 4/22/15.
 */
public class Painter implements Visitor<Void>{


    public Painter(){

    }

    public Void onLine(Line l){


        return null;
    }

    public Void onSprite(Sprite sp){


        return null;
    }

    public Void onSquare(Square sq){


        return null;
    }

    public Void onText(Text t){


        return null;
    }

}
