package com.oreilly.demo.android.pa.uidemo.state;

import android.os.Bundle;
import java.util.Vector;
import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

/**
 * Created by Salomon on 4/22/15.
 */
public class Menu extends State {
    public void start(int width, int height)  { }
    public void tap()  { }
    public void tick()  { }
    public Bundle save(Bundle bundle) { return bundle; }
    public void load(int width, int height, Bundle bundle) {  }

    private Vector<DrawableObj> toDraw = new Vector<DrawableObj>();

    //TODO What the screen will contain.
    private void DrawObjects(){

        toDraw.add(null);
    }


}
