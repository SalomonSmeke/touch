package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Square;

import java.util.Vector;

/**
 * Created by Salomon on 4/22/15.
 */
public class Select extends State {
    public Vector<DrawableObj> start(int width, int height)  { return null; }
    public void tap()  { }
    public void tick()  { }
    public Bundle save(Bundle bundle) { return bundle; }
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { return null; }

    private int width = 0;
    private int height = 0;
    private Vector<DrawableObj> toDraw = new Vector<DrawableObj>();

    private void DrawSelect(){
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

        //TODO: make code for level select menu

    }
}
