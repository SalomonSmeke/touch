package com.oreilly.demo.android.pa.uidemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import android.view.Window;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.TextView;

import com.oreilly.demo.android.pa.uidemo.model.Dot;
import com.oreilly.demo.android.pa.uidemo.model.Dots;
import com.oreilly.demo.android.pa.uidemo.view.DotView;



/**
 * Android UI demo program
 */
public class TouchMe extends Activity {


    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;

    long updatedTime = 0L;

    /** Dot diameter */
    public static final int DOT_DIAMETER = 6;


    /** The application model */
    final Dots dotModel = new Dots();

    /** The application view */
    DotView dotView;

    boolean pointerDown = false;

    /** Listen for taps. */
    private final class TrackingTouchListener
        implements View.OnTouchListener
    {
        private final Dots mDots;

        TrackingTouchListener(Dots dots) { mDots = dots; }

        @Override public boolean onTouch(View v, MotionEvent evt) {
            int action = evt.getAction();
            if (action == MotionEvent.ACTION_POINTER_DOWN || action == MotionEvent.ACTION_DOWN){
                pointerDown = true;
            }

            if (action == MotionEvent.ACTION_POINTER_UP || action == MotionEvent.ACTION_UP){
                if (pointerDown){
                    dotView.invalidate("TAP", (int)evt.getX(), (int)evt.getY());
                }
                pointerDown = false;
            }

            return true;
        }
    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int milliseconds = (int) (updatedTime % 1000);
            onTime(milliseconds);
            customHandler.postDelayed(this, 0);
        }
    };

    private void onTime(int mili){
        if(mili%20 == 0) {
            if (dotView.hasState()) {
                dotView.invalidate("FRAME", 0, 0);
            }
        }
    }


    /** Generate new dots, one per second. */
    private final class DotGenerator implements Runnable {
        final Dots dots;
        final DotView view;
        final int color;

        private final Handler hdlr = new Handler();
        private final Runnable makeDots = new Runnable() {
            @Override public void run() { makeDot(dots, view, color); }
        };

        private volatile boolean done;

        DotGenerator(Dots dots, DotView view, int color) {
            this.dots = dots;
            this.view = view;
            this.color = color;
        }

        public void done() { done = true; }

        @Override
        public void run() {
            while (!done) {
                hdlr.post(makeDots);
                try { Thread.sleep(2000); }
                catch (InterruptedException e) { }
            }
        }
    }

    private final Random rand = new Random();


    /** Called when the activity is first created. */
    @Override public void onCreate(Bundle state) {

        super.onCreate(state);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // install the view
        setContentView(R.layout.main);

        // find the dots view
        dotView = (DotView) findViewById(R.id.dots);
        dotView.setDots(dotModel);

        dotView.setOnCreateContextMenuListener(this);
        dotView.setOnTouchListener(new TrackingTouchListener(dotModel));

        synchronized (updateTimerThread){
            try {
                updateTimerThread.wait(2);

            } catch (InterruptedException e){

            }
            startTime = SystemClock.uptimeMillis();
            customHandler.postDelayed(updateTimerThread, 0);
        }
        dotView.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override public void onFocusChange(View v, boolean hasFocus) {
            }
        });

    }


    /**
     * @param dots the dots we're drawing
     * @param view the view in which we're drawing dots
     * @param color the color of the dot
     */
    void makeDot(Dots dots, DotView view, int color) {
        int pad = (DOT_DIAMETER + 2) * 2;
        dots.addDot(
            DOT_DIAMETER + (rand.nextFloat() * (view.getWidth() - pad)),
            DOT_DIAMETER + (rand.nextFloat() * (view.getHeight() - pad)),
            color,
            DOT_DIAMETER);
    }
}