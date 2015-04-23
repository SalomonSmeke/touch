package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import java.util.Vector;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Square;

/**
 * Created by Salomon on 4/22/15.
 */
public class Menu extends State {

    private int width = 0;
    private int height = 0;

    public Vector<DrawableObj> start(int width, int height)  { this.width = width; this.height = height; DrawMenu(); return toDraw; }
    public void tap()  { }
    public void tick()  { }
    public Bundle save(Bundle bundle) { return bundle; }
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { this.width = width; this.height = height; DrawMenu(); return toDraw;  }

    private Vector<DrawableObj> toDraw = new Vector<DrawableObj>();

    //TODO What the screen will contain.
    private void DrawObjects(){
        double percBorder = .1;
        toDraw.add(new Square((int)(width-2*(width*percBorder)),(int)(height-2*(width*percBorder)),(int)(width*percBorder),(int)(width*percBorder)));

    }

    private void DrawMenu(){
        double percBorder = .1;
        double widthBased = 2*(width*percBorder);
        double heightBased = 2*(height*percBorder);
        double used;
        int used2;
        if (widthBased > heightBased){
            used = heightBased;
            used2 = height;
        } else {
            used = widthBased;
            used2 = width;
        }
        toDraw.clear();
        toDraw.add(new Square((int)(width-used),(int)(height-used),(int)(used2*percBorder),(int)(used2*percBorder)));

    }


}