package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Vector;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * @author laufer
 */
interface StateView{

    // Transitions
    void toSelect();
    void toMenu();
    void toGame();
    void toEnd();

    // Actions
//    Vector<DrawableObj> start(int width, int height);
//    Vector<DrawableObj> tap( double x, double y);
//    Vector<DrawableObj> tick();
//    Bundle save(Bundle bundle);
//    Vector<DrawableObj> load(int width, int height, Bundle bundle);

}
