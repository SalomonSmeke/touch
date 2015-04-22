package com.oreilly.demo.android.pa.uidemo.state;

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
    public void save() { currentState.save();}
    public void load() { currentState.load();}

    //State transitions
    public void toMenu(){ currentState = new Menu(); }
    public void toSelect(){ currentState = new Select(); }
    public void toGame(){ currentState = new Game(); }
    public void toEnd(){ currentState = new End(); }
}