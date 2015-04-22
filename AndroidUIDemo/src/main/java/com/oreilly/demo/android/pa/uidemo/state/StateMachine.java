package com.oreilly.demo.android.pa.uidemo.state;

/**
 * Created by Salomon on 4/22/15.
 */
abstract class State {
    public void start()  { }
    public void tap()  { }
    public void tick()  { }
    public void save() {  }
    public void load() {  }
}
