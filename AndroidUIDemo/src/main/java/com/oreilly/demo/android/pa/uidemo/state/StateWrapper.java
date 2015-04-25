package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import android.view.View;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Painter;

import java.util.Vector;


/**
 * Created by Salomon on 4/22/15.
 */
public class StateWrapper implements StateOverlord {
    //Initial State
    private State currentState;
    private static Painter painter;
    private int width;
    private int height;
    private Vector<DrawableObj> DrawMe = null;

    public StateWrapper (Painter painter, int width, int height){
        currentState = MENU;
        this.painter = painter;
        this.width = width;
        this.height = height;
        start(width, height);
    }

    //State actions
    public void start(int width, int height)  { DrawMe = currentState.start(width, height);}
    public void tap() { currentState.tap(0,0);}
    public void tick() { currentState.tick();}
    public Bundle save(Bundle bundle) { return currentState.save(bundle);}
    public void load(Bundle bundle) { currentState.load(width, height, bundle);}
    public void draw(){
        for (int i = 0; i < DrawMe.size(); i++){
            DrawMe.get(i).accept(painter);
        }
    };

    public void setPainter(Painter painter){
        this.painter = painter;
    }

    private final State MENU = new Menu(this);
    private final State SELECT = new Select(this);
    private final State GAME = new Game(this);
    private final State END = new End(this);

    protected void setState(final State state) {
        this.currentState = state;
        this.start(width,height);
    }


    //State transitions
    public void toMenu(){ setState(MENU);}

    public void toSelect(){ setState(SELECT);}

    public void toGame(){ setState(GAME);}

    public void toEnd(){ setState(END);}

    //State saving
    //TODO Loading & Saving States
    //State loading
}