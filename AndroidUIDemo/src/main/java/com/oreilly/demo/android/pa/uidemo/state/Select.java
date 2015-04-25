package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.SquareF;

import java.util.Vector;

/**
 * Created by Salomon on 4/22/15.
 */
public class Select implements State {


    public Select(final StateView sm) {
        this.sm = sm;
    }

    private final StateView sm;

    public Vector<DrawableObj> start(int width, int height)  { this.width = width; this.height = height; DrawSelect(); return toDraw;  }
    public Vector<DrawableObj>  tap(double x, double y)  { return null; }
    public Vector<DrawableObj>  tick()  { return  null; }
    public Bundle save(Bundle bundle) { return bundle; }
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { this.width = width; this.height = height; DrawSelect(); return toDraw;  }

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

        Vector<int []> clrs = new Vector<int[]>();
        clrs.add(new int[]{255,46,250,170});
        clrs.add(new int[]{255,26,211,246});
        clrs.add(new int[]{255,255,105,85});

        toDraw.clear();
        toDraw.add(new SquareF(width,height,0,0,new int[]{255,255,255,255,255}));
        for (int i = 0; i < 3; i++){
            toDraw.add(new SquareF((int)(width-used),(int)(height-used)/3,(int)(used2*percBorder),(int)(used2*percBorder)+((int)(height-used)/3*(i)),clrs.get(i)));
//
        }
    }
}
