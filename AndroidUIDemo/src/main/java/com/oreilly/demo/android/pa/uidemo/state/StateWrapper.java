package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import android.view.View;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Painter;

import java.util.Vector;


/**
 * Created by Salomon on 4/22/15.
 */
public class StateWrapper {
    //Initial State
    private State currentState = new Menu();
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
    public void tap() { currentState.tap();}
    public void tick() { currentState.tick();}
    public Bundle save(Bundle bundle) { return currentState.save(bundle);}
    public void load(Bundle bundle) { currentState.load(width, height, bundle);}
    public void draw(Vector<DrawableObj> DrawMe){
        for (int i = 0; i < DrawMe.size(); i++){
            DrawMe.get(i).accept(painter);
        }
    };

    //State transitions
    public void toMenu(){ currentState = new Menu();
    currentState.start(width, height);}
    public void toSelect(){ currentState = new Select();
    currentState.start(width, height);}
    public void toGame(){ currentState = new Game();
    currentState.start(width, height);}
    public void toEnd(){ currentState = new End();
    currentState.start(width, height);}

    //State saving
    //TODO Loading & Saving States
    //State loading
}