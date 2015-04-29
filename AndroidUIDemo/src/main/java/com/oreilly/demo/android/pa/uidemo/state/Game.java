package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import android.util.Log;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.gameBits.objectMaster;

import java.util.Vector;

/**
 * Created by Salomon on 4/22/15.
 */
public class Game implements State {
    //Pass In
    int difficulty = 0;

    //FrameCounter

    //EnemyArrays

    //Grid

    //TouchControls

    //Drawings
    private Vector<DrawableObj> list = new Vector<DrawableObj>();

    public Game(final StateView sm) {
        this.sm = sm;
    }

    private final StateView sm;

    private objectMaster gameView;

    public Vector<DrawableObj> start(int width, int height)  {
        gameView = new objectMaster(width,height,difficulty);
        list = gameView.init();
        return list;
    }
    public Vector<DrawableObj> tap( int x, int y)  {
        list = gameView.tap(x,y);
        if (list == null){
            sm.toSelect();
        }
        return list; }
    public Vector<DrawableObj> tick()  {
        list = gameView.tick();
        return list; }
    public Bundle save(Bundle bundle) { return bundle; }
    public Vector<DrawableObj> load(int width, int height, Bundle bundle) { return null; }

    public void setVar(int difficulty){this.difficulty = difficulty;}
}
