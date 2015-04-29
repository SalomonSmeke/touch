package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Random;
import java.util.Vector;

/**
 * Created by Salomon on 4/26/15.
 */
public class grid {

    private gridBlock[][] blocks = new gridBlock[5][5];
    private Vector<enemy> enemies;
    private Vector<int []> occupied = new Vector<int[]>();

    private Vector<DrawableObj> backgroundGrid = new Vector<DrawableObj>();
    private Vector<DrawableObj> dynamic = new Vector<DrawableObj>();
    private Vector<DrawableObj> drawMe = new Vector<DrawableObj>();

    private int[] baseCoordinates;

    int boxSize;

    public grid(int width, int height, int difficulty){
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                blocks[x][y] = new gridBlock(width, height, x, y, new int[]{255,243,142,150});
                backgroundGrid.add(blocks[x][y].getDrawable());
            }

        }
        baseCoordinates = blocks[0][0].getBase();
        setBoxSize(width, height);

        generateEnemies(12+difficulty*2);

        drawMe.addAll(backgroundGrid);
        drawMe.addAll(dynamic);
    }

    private int[] getCoordinates(){
        Random rgen = new Random();
        int x = rgen.nextInt(5);
        int y = rgen.nextInt(5);

        while(isContained(x,y)){
            x = rgen.nextInt(5);
            y = rgen.nextInt(5);
        }

        occupied.add(new int[]{x,y});
        return new int[]{x,y};
    }

    private boolean isContained(int x, int y){
        for (int i = 0; i < occupied.size(); i++){
            if (occupied.get(i)[0] == x && occupied.get(i)[1] == y) return true;
        }
        return false;
    }

    private void setBoxSize(int width, int height){
        float percBorder = .1f;
        if (width > height){
            boxSize = (int)((height - (height * percBorder))/5.0);
        } else {
            boxSize = (int)((width - (width * percBorder))/5.0);
        }
    }

    private void generateEnemies(int size){
        enemies = new Vector<enemy>();
        for (int i = 0; i < size; i++){
            enemies.add(i,new enemy(new int[]{255,243,142,150}));//Replace with color changer.
            enemies.get(i).setDraw(getCoordinates(), boxSize, baseCoordinates);
            dynamic.add(enemies.get(i).getDrawable());
        }
    }

    private boolean enemyAt(int x, int y){
        for (int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).collide(x,y)){
                enemies.remove(i);
                return true;
            }
        }
        return false;
    }

    public Vector<DrawableObj> tap(int x, int y){
        if(enemyAt(x,y)) {
            reAdd();
        }
        if (enemies.size() == 0){
            return null;
        }
        return drawMe;
    }

    private void reAdd(){
        dynamic.clear();
        drawMe.clear();
        drawMe.addAll(backgroundGrid);
        for (int i = 0; i < enemies.size(); i++){
            dynamic.add(enemies.get(i).getDrawable());
        }
        drawMe.addAll(dynamic);
    }

    public Vector<DrawableObj> tick(){
        return drawMe;
    }
}
