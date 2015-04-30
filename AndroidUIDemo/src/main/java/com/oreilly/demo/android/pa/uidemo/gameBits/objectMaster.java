package com.oreilly.demo.android.pa.uidemo.gameBits;

import android.util.Log;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.SquareF;

import java.util.Vector;

/**
 *The objectMaster takes care of adding all of the objects in the game
 *
 * Created by Salomon on 4/26/15.
 */
public class objectMaster {
    private int difficulty = 0;
    private int width = 0;
    private int height = 0;

    private Vector<DrawableObj> drawList = new Vector<DrawableObj>();

    private Vector<int []> clrs = new Vector<int[]>();

    private SquareF Background;
    private grid Grid;
    private progressBar Bar;
    private difficultyDisplay Difficulty;

    public objectMaster(int width, int height, int difficulty){
        this.difficulty = difficulty;
        this.width = width;
        this.height = height;
        clrs.add(new int[]{255, 184, 125, 143});
        clrs.add(new int[]{255, 250, 172, 152});
        clrs.add(new int[]{255, 208, 247, 244});
        Background = new SquareF(width,height,0,0,clrs.get(difficulty));
    }

    public Vector<DrawableObj> init() {
        Grid = new grid (width, height, difficulty);
        Bar = new progressBar (width, height,new int[]{255, 243, 142, 150});

        drawList.add(Background);

        drawList.addAll(Bar.tap());
        Log.i("Made it to init", "");
        Difficulty = new difficultyDisplay(width, height, difficulty);
        return drawList;
    }

    public Vector<DrawableObj> tap(int x, int y){
        drawList.clear();
        drawList.add(Background);
        Vector<DrawableObj> temp = Grid.tap(x,y);
        if (temp == null){
            return null;
        }
        drawList.addAll(temp);
        drawList.addAll(Bar.tap());
        drawList.addAll(Difficulty.tap());
        return drawList;
    }

    public Vector<DrawableObj> tick(){
        drawList.clear();
        drawList.add(Background);
        drawList.addAll(Grid.tick());
        Vector<DrawableObj> temp = Bar.tick();
        if (temp == null){
            return null;
        }
        drawList.addAll(temp);
        drawList.addAll(Difficulty.tick());
        return drawList;
    }
}
