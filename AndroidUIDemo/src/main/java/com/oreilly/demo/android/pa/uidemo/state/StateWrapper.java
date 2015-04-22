package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

/**
 * Created by Salomon on 4/22/15.
 */
public class StateWrapper {
    //Initial State
    private State currentState = null;


    //State actions
    public void start()  { currentState.start();}
    public void tap() { currentState.tap();}
    public void tick() { currentState.tick();}
    public Bundle save(Bundle bundle) { return currentState.save(bundle);}
    public void load(Bundle bundle) { currentState.load(bundle);}

    //State transitions
    public void toMenu(){ currentState = new Menu();
    currentState.start();}
    public void toSelect(){ currentState = new Select();
    currentState.start();}
    public void toGame(){ currentState = new Game();
    currentState.start();}
    public void toEnd(){ currentState = new End();
    currentState.start();}

    //State saving
    //TODO Loading & Saving States
    //State loading
}