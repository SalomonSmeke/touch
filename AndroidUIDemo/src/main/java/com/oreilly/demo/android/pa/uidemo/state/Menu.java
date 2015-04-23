package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import java.util.Vector;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Square;

/**
 * Created by Salomon on 4/22/15.
 */
public class Menu implements State{


    public Menu(final StateView sm) {
        this.sm = sm;
    }

    private final StateView sm;

    private int width = 0;
    private int height = 0;
    private Vector<DrawableObj> toDraw = new Vector<DrawableObj>();

    public Vector<DrawableObj> start(int width, int height)  { this.width = width; this.height = height; DrawMenu(); return toDraw; }
    public Vector<DrawableObj> tap(double x, double y)  { if (inArea()) {
        sm.toSelect();
    } return null;}
    public Vector<DrawableObj>  tick()  { return null; }
    public Bundle save(Bundle bundle) { return bundle; }
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { this.width = width; this.height = height; DrawMenu(); return toDraw; }

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
        toDraw.add(new Square((int)(width-used),(int)(height-used),(int)(used2*percBorder),(int)(used2*percBorder), new int[]{255,255,255,255}));
    }

    private boolean inArea(){
        return true;
    }

}