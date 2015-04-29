package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import android.util.Log;

import com.oreilly.demo.android.pa.uidemo.draw.CircleF;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.SquareF;
import com.oreilly.demo.android.pa.uidemo.draw.Square;

import java.util.Vector;

/**
 * Created by Salomon on 4/22/15.
 */
public class Select implements State {


    public Select(final StateView sm) {
        this.sm = sm;
    }

    private final StateView sm;

    private boolean preventInterruption = true;

    private int choice = -1;
    private int frame = 0;

    public Vector<DrawableObj> start(int width, int height)  { this.width = width; this.height = height; DrawSelect(); return toDraw;  }
    public Vector<DrawableObj>  tap(int x, int y)  {
        if (preventInterruption) {
            switch (InArea(x, y)) {
                case 0:
                    choice = 0;
                    preventInterruption = false;
                    break;
                case 1:
                    choice = 1;
                    preventInterruption = false;
                    break;
                case 2:
                    choice = 2;
                    preventInterruption = false;
                    break;
                default:
            }
        }
        return null;
    }
    public Vector<DrawableObj>  tick()  {
        if (frame == 45){
            sm.toGame(choice);
        }
        if (choice > -1){
            ExpandTransition();
        }
        return toDraw;
    }

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
        clrs.add(new int[]{255, 184, 125, 143});
        clrs.add(new int[]{255, 250, 172, 152});
        clrs.add(new int[]{255, 208, 247, 244});

        toDraw.clear();
        toDraw.add(new SquareF(width,height,0,0,new int[]{255,243,206,180}));
        for (int i = 0; i < 3; i++){
            toDraw.add(new SquareF((int)(width-used),(int)(height-used)/3,(int)(used2*percBorder),(int)(used2*percBorder)+((int)(height-used)/3*(i)),clrs.get(i)));
        }

        DrawDots(255);
    }

    public void DrawDots(int alpha){
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
        for (int i = 0; i < 3; i++) {
            for (int z = -1; z < i; z++) {
                toDraw.add(new CircleF((int) used / 4, width / 2 + ((int) used)*z, (int) ((used2 * percBorder) + ((height - used) / 3 * (i)) + (height - used) / 6), new int[]{alpha, 243, 142, 150}));
            }
        }
    }

    public int InArea(int x, int y){
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
        int uw = (int)(width-used);
        int uh = (int)(height-used);

        int [] zero = new int[]{(int)used2,(int)(used2+uw),(int)(used2),(int)(used2)+((int)uh/3)};
        int [] one = new int[]{(int)used2,(int)(used2+uw),(int)(used2)+((int)(uh)/3),(int)(used2)+((int)(2*uh)/3)};
        int [] two = new int[]{(int)used2,(int)(used2+uw),(int)(used2)+((int)(2*(uh))/3),(int)(used2)+((int)(3*uh)/3)};

        if (x>zero[0] && x<zero[1] && y>zero[2] && y<zero[3]){
            return 0;
        }
        if (x>one[0] && x<one[1] && y>one[2] && y<one[3]){
            return 1;
        }
        if (x>two[0] && x<two[1] && y>two[2] && y<two[3]){
            return 2;
        }

        return -1;
    }

    public boolean ExpandTransition(){
        frame++;

        int dotsTransitionFrames = 10;
        int dotsSpacingFrames = 5;
        int blockTransitionBegin = dotsTransitionFrames+dotsSpacingFrames;

        boolean done = false;
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
        clrs.add(new int[]{255, 184, 125, 143});
        clrs.add(new int[]{255, 250, 172, 152});
        clrs.add(new int[]{255, 208, 247, 244});

        toDraw.clear();
        toDraw.add(new SquareF(width,height,0,0,new int[]{255,243,206,180}));

        for (int i = 0; i < 3; i++){
            if (frame < blockTransitionBegin) {
                toDraw.add(new SquareF((int) (width - used), (int) (height - used) / 3, (int) (used2 * percBorder), (int) (used2 * percBorder) + ((int) (height - used) / 3 * (i)), clrs.get(i)));
            } else {
                if (i!=choice){
                    int[] temp = clrs.get(i);
                    temp[0] = 255-(255/30)*(frame-blockTransitionBegin);
                    toDraw.add(new SquareF((int) (width - used), (int) (height - used) / 3, (int) (used2 * percBorder), (int) (used2 * percBorder) + ((int) (height - used) / 3 * (i)), temp));
                }
            }
        }
        if (frame>=blockTransitionBegin){
            int [] transSQ = getDimensionsTransition((int) (width - used), (int) (height - used) / 3, (int) (used2 * percBorder), (int) (used2 * percBorder) + ((int) (height - used) / 3 * (choice)));
            toDraw.add(new SquareF(transSQ[0],transSQ[1],transSQ[2],transSQ[3], clrs.get(choice)));
        }

        int dotsAlpha;

        if (frame < dotsTransitionFrames){
            dotsAlpha = 255 - (255/10 * frame);
        } else {
            dotsAlpha = 0;
        }


        DrawDots(dotsAlpha);
        return  done;
    }

    public int[] getDimensionsTransition(int wide, int tall, int x, int y){
        int blockTransitionFrames = 30;
        int offsetFrame = frame-15;

        double transitionalY = y-(y/blockTransitionFrames)*(offsetFrame+1);

        if (offsetFrame>=blockTransitionFrames){
            frame = blockTransitionFrames+15;
            offsetFrame=blockTransitionFrames;
            transitionalY = 0;
        }

        double wideChange = ((width-wide)/blockTransitionFrames)*(offsetFrame+1);
        double tallChange = ((height-tall)/blockTransitionFrames)*(offsetFrame+1);

        double transitionalX = x-(wideChange/2);

        return new int[]{(int)(wideChange+wide),(int)(tallChange+tall),(int)transitionalX,(int)transitionalY};
    }

    public void setVar(int x){}
}

