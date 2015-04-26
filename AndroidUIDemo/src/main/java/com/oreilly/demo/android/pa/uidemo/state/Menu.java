package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import java.util.Vector;

import com.oreilly.demo.android.pa.uidemo.draw.CircleF;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Square;
import com.oreilly.demo.android.pa.uidemo.draw.SquareF;

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

    private boolean tapped = false;
    private boolean growthToggle = false;

    int frameNo = 0;
    double animate = 0;

    public Vector<DrawableObj> start(int width, int height)  { this.width = width; this.height = height; DrawMenu(); return toDraw; }
    public Vector<DrawableObj> tap(int x, int y)  { if (inArea(x,y)) {
        tapped = true;
    } return null;}
    public Vector<DrawableObj>  tick() {
        if (frameNo == 6){
            sm.toSelect();
        } else {
            if (tapped) {
                DrawTransition();
            } else {
                DrawBreath();
            }
        }
        return toDraw;
    }
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
        toDraw.add(new Square((int)(width-used + 20),(int)(height-used + 20),(int)(used2*percBorder - 10),(int)(used2*percBorder - 10), new int[]{255, 255, 251, 212}));
        toDraw.add(new Square((int) (width - used), (int) (height - used), (int) (used2 * percBorder), (int) (used2 * percBorder), new int[]{255, 153, 251, 212}));
        toDraw.add(new Square((int)(width-used - 20),(int)(height-used - 20),(int)(used2*percBorder + 10),(int)(used2*percBorder + 10), new int[]{255, 51, 251, 212}));
    }

    private void DrawTransition(){
        frameNo++;
        double percBorder = .1;
        double widthBased = 2*(width*percBorder);
        double heightBased = 2*(height*percBorder);
        double used;
        double used2;
        if (widthBased > heightBased){
            used = heightBased;
            used2 = height*percBorder;
        } else {
            used = widthBased;
            used2 = width*percBorder;
        }
        int alpha = 255/6 * frameNo;
        int subAlpha = 255-alpha;

        toDraw.clear();
        double wm = width-used;
        double hm = height-used;
        toDraw.add(new Square((int)(wm + 20),(int)(hm + 20),(int)(used2- 10),(int)(used2 - 10), new int[]{subAlpha, 255, 251, 212}));
        toDraw.add(new Square((int) (wm), (int) (hm), (int) (used2), (int) (used2), new int[]{subAlpha, 153, 251, 212}));
        toDraw.add(new Square((int)(wm - 20),(int)(hm - 20),(int)(used2 + 10),(int)(used2 + 10), new int[]{subAlpha, 51, 251, 212}));

        Vector<int []> clrs = new Vector<int[]>();

        clrs.add(new int[]{alpha, 255, 251, 212});
        clrs.add(new int[]{alpha, 153, 251, 212});
        clrs.add(new int[]{alpha, 51, 251, 212});
        for (int i = 0; i < 3; i++){
            toDraw.add(new SquareF((int)(width-used),(int)(height-used)/3,(int)(used2),(int)(used2)+((int)(height-used)/3*(i)),clrs.get(i)));
        }
        for (int i = 0; i < 3; i++) {
            for (int z = -1; z < i; z++) {
                toDraw.add(new CircleF((int) used / 4, width / 2 + ((int) used)*z, (int) ((used2) + ((height - used) / 3 * (i)) + (height - used) / 6), new int[]{alpha, 255, 100, 100}));
            }
        }
    }

    private void DrawBreath(){
        if (animate > 30) growthToggle = true;
        if (animate < - 30) growthToggle = false;

        if (growthToggle){
            animate --;
        } else {
            animate ++;
        }

        double percBorder = .1;
        double widthBased = 2*(width*percBorder);
        double heightBased = 2*(height*percBorder);
        double used;
        double used2;
        if (widthBased > heightBased){
            used = heightBased;
            used2 = height*percBorder;
        } else {
            used = widthBased;
            used2 = width*percBorder;
        }
        double wm = width-used;
        double hm = height-used;
        int alpha = (int)((160 - (animate*3)));
        toDraw.clear();
        toDraw.add(new Square((int)(wm + 20),(int)(hm + 20),(int)(used2- 10),(int)(used2 - 10), new int[]{255, 255, 251, 212}));
        toDraw.add(new Square((int) (wm), (int) (hm), (int) (used2), (int) (used2), new int[]{255, 153, 251, 212}));
        toDraw.add(new Square((int)(wm - 20),(int)(hm - 20),(int)(used2 + 10),(int)(used2 + 10), new int[]{255, 51, 251, 212}));


        toDraw.add(new CircleF((int) (((used / 4) * (1.0 + animate/200))), width / 2, height/2, new int[]{alpha, 255, 251, 212}));

    }

    private boolean inArea(int x, int y){
        double percBorder = .1;
        double widthBased = 2*(width*percBorder);
        double heightBased = 2*(height*percBorder);
        double used;
        if (widthBased > heightBased){
            used = heightBased;
        } else {
            used = (((widthBased / 4) * (1.0 + animate/200)));
        }
        double xAreaL = width/2 - used;
        double xAreaR = width/2 + used;
        double yAreaT = height/2 - used;
        double yAreaB = height/2 + used;
        if (x<xAreaL || x>xAreaR || y<yAreaT || y>yAreaB){
            return false;
        }
        return true;
    }

}