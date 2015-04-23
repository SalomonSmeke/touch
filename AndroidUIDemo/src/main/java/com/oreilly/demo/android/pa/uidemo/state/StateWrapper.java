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
    private State currentState = new Menu(this);
    private Painter painter;
    private int width;
    private int height;

    public StateWrapper(Painter painter, int width, int height){
        this.painter = painter;
        this.width = width;
        this.height = height;
        start(width, height);
    }

    //State actions
    public void start(int width, int height)  { draw(currentState.start(width, height));}
    public void tap() { currentState.tap(0,0);}
    public void tick() { currentState.tick();}
    public Bundle save(Bundle bundle) { return currentState.save(bundle);}
    public void load(Bundle bundle) { currentState.load(width, height, bundle);}
    public void draw(Vector<DrawableObj> DrawMe){
        for (int i = 0; i < DrawMe.size(); i++){
            DrawMe.get(i).accept(painter);
        }
    };

    private State state;

    private final State MENU     = new Menu(this);
    private final State SELECT     = new Select(this);
    private final State GAME = new Game(this);
    private final State END = new End(this);

    protected void setState(final State state) {
        this.state = state;
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