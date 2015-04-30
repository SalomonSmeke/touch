package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import android.view.View;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;
import com.oreilly.demo.android.pa.uidemo.draw.Painter;

import java.util.Vector;


/**
 * StateWrapper to easily transition from state to state
 *
 * Created by Salomon on 4/22/15.
 */
public class StateWrapper implements StateOverlord {
    //Initial State
    private State currentState;
    private static Painter painter;
    private int width;
    private int height;
    private Vector<DrawableObj> DrawMe = null;
    private int difficulty;
    private int frame = 0;
    private boolean inGame = false;

    /**
     *
     * @param painter painter object
     * @param width width of device
     * @param height height of device
     */
    public StateWrapper (Painter painter, int width, int height){
        currentState = MENU;
        this.painter = painter;
        this.width = width;
        this.height = height;
        start(width, height);
    }

    //State actions

    /**
     *
     * @param width width of device
     * @param height height of device
     */
    public void start(int width, int height)  { DrawMe = currentState.start(width, height);}

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public void tap(int x, int y) { currentState.tap(x,y);}

    /**
     * draw the state per tick
     */
    public void tick() {if (inGame)frame++;
        DrawMe = currentState.tick();
    if (DrawMe==null){
        toSelect();
    }
    }

    /**
     *
     * @param bundle THE Bundle bundle
     * @return save the bundle
     */
    public Bundle save(Bundle bundle) { return currentState.save(bundle);}

    /**
     *
     * @param bundle THE Bundle bundle
     */
    public void load(Bundle bundle) { currentState.load(width, height, bundle);}

    /**
     * draw stuff to the painter
     */
    public void draw(){
        for (int i = 0; i < DrawMe.size(); i++){
            DrawMe.get(i).accept(painter);
        }
    };

    /**
     *
     * @param painter painter object
     */
    public void setPainter(Painter painter){
        this.painter = painter;
    }

    private State MENU = new Menu(this);
    private State SELECT = new Select(this);
    private State GAME = new Game(this);
    private State END = new End(this);

    /**
     *
     * @param state which state to set it as
     */
    protected void setState(final State state) {
        this.currentState = state;
        this.start(width,height);
    }


    //State transitions
    public void toMenu(){
        inGame = false;
        MENU = new Menu(this);
        setState(MENU);
    }

    public void toSelect(){
        inGame = false;
        SELECT = new Select(this);
        setState(SELECT);
    }

    public void toGame(int difficulty){
        frame = 0;
        inGame = true;
        GAME = new Game(this);
        GAME.setVar(new int[]{difficulty});
        this.difficulty = difficulty;
        setState(GAME);
    }

    public void toEnd(int difficulty, int barwidth){
        inGame = false;
        END = new End(this);
        END.setVar(new int[]{difficulty,barwidth});
        setState(END);
    }

    public State getState(){
        return currentState;
    }

    //State saving
    //TODO Loading & Saving States
    //State loading
}