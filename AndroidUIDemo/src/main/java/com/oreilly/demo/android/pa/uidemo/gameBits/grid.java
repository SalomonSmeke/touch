package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Random;
import java.util.Vector;

/**
 * Created by Salomon on 4/26/15.
 */
public class grid {

    private gridBlock[][] blocks = new gridBlock[5][5];
    private enemy[] enemies;
    private Vector<int []> occupied = new Vector<int[]>();

    private Vector<DrawableObj> backgroundGrid = new Vector<DrawableObj>();
    private Vector<DrawableObj> dynamic = new Vector<DrawableObj>();
    private Vector<DrawableObj> drawMe = new Vector<DrawableObj>();

    public grid(int width, int height, int difficulty){
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                blocks[x][y].setPlaces(width, height, x, y);
                blocks[x][y].setColor();
                backgroundGrid.add(blocks[x][y].getDrawable);
            }
        }
        enemies = new enemy[10+(difficulty*2)];
        for (int i = 0; i < enemies.length; i++){
            enemy.setColor();
            enemy.setDraw(getCoordinates());
            dynamic.add(enemy.getDrawable);
        }
        drawMe.addAll(backgroundGrid);
        drawMe.addAll(dynamic);
    }

    private int[] getCoordinates(){
        Random rgen = new Random();
        int x = rgen.nextInt(4);
        int y = rgen.nextInt(4);
        while (occupied.contains(new int[]{x,y})){
            x = rgen.nextInt(4);
            y = rgen.nextInt(4);
        }
        occupied.add(new int[]{x,y});
        return new int[]{x,y};
    }

    private boolean enemyAt(int x, int y){
        return false;
    }

    private void removeEnemy(int x, int y){

    }

    public Vector<DrawableObj> tap(int x, int y){
        if (enemyAt(x,y)){
            if (enemy.colorMatches()){
                removeEnemy(x,y);
            } else {
                return null; //lose
            }
        }
        return drawMe;
    }

    public Vector<DrawableObj> tick(){
        return drawMe;
    }
}
