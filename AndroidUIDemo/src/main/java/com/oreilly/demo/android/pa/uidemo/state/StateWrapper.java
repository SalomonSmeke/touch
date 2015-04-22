package com.oreilly.demo.android.pa.uidemo.state;

/**
 * Created by Salomon on 4/22/15.
 */
public class StateWrapper {
    private State[] states     = { new A(), new B(), new C() }; // 2. states
    private int[][] transition = { {2,1,0}, {0,2,1}, {1,2,2} }; // 4. transitions
    private int     current    = 0;                             // 3. current
    private void next( int msg ) { current = transition[current][msg]; }

    // 5. All client requests are simply delegated to the current state object
    public void start()  { states[current].start();}
    public void tap() { states[current].tap();}
    public void tick() { states[current].tick();}
    public void save() { states[current].save();}
    public void load() { states[current].load();}
}