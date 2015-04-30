package com.oreilly.demo.android.pa.uidemo.gameBits;

import com.oreilly.demo.android.pa.uidemo.draw.DrawableObj;

import java.util.Random;
import java.util.Vector;

/**
 * Grid draws the grid on the game screen with a 5x5 set of squares.
 * It does this by iterating through the possible dimensions and then drawing
 * them to the screen. It also generates the enemies inside of the grid as well
 * as removes them when their box is tapped.
 *
 * Created by Salomon on 4/26/15.
 */
public class grid {

    private int[][] clrs = new int[][]{

            new int[]{255,184,125,143,0},
            new int[]{255,185,125,143,1},
            new int[]{255,186,125,143,2},
            new int[]{255,187,125,143,3},
            new int[]{255,188,125,143,4},
            new int[]{255,189,125,143,5},
            new int[]{255,190,125,143,6},
            new int[]{255,191,125,143,7},
            new int[]{255,192,125,143,8},
            new int[]{255,193,125,143,9},
            new int[]{255,194,125,143,10},
            new int[]{255,195,125,143,11},
            new int[]{255,196,125,143,12},
            new int[]{255,197,125,143,13},
            new int[]{255,198,125,143,14},
            new int[]{255,199,125,143,15},
            new int[]{255,200,125,143,16},
            new int[]{255,201,125,143,17},
            new int[]{255,202,125,143,18},
            new int[]{255,203,125,143,19},
            new int[]{255,204,125,143,20},
            new int[]{255,205,125,143,21},
            new int[]{255,206,125,143,22},
            new int[]{255,207,125,143,23},
            new int[]{255,208,125,143,24},
            new int[]{255,209,125,143,25},
            new int[]{255,210,125,143,26},
            new int[]{255,211,125,143,27},
            new int[]{255,212,125,143,28},
            new int[]{255,213,125,143,29},
            new int[]{255,214,125,143,30},
            new int[]{255,215,125,143,31},
            new int[]{255,216,125,143,32},
            new int[]{255,217,125,143,33},
            new int[]{255,218,125,143,34},
            new int[]{255,219,125,143,35},
            new int[]{255,220,125,143,36},
            new int[]{255,221,125,143,37},
            new int[]{255,222,125,143,38},
            new int[]{255,223,125,143,39},
            new int[]{255,224,125,143,40},
            new int[]{255,225,125,143,41},
            new int[]{255,226,125,143,42},
            new int[]{255,227,125,143,43},
            new int[]{255,228,125,143,44},
            new int[]{255,229,125,143,45},
            new int[]{255,230,125,143,46},
            new int[]{255,231,125,143,47},
            new int[]{255,232,125,143,48},
            new int[]{255,233,125,143,49},
            new int[]{255,234,125,143,50},
            new int[]{255,235,125,143,51},
            new int[]{255,236,125,143,52},
            new int[]{255,237,125,143,53},
            new int[]{255,238,125,143,54},
            new int[]{255,239,125,143,55},
            new int[]{255,240,125,143,56},
            new int[]{255,241,125,143,57},
            new int[]{255,242,125,143,58},
            new int[]{255,243,125,143,59},
            new int[]{255,244,125,143,60},
            new int[]{255,245,125,143,61},
            new int[]{255,246,125,143,62},
            new int[]{255,247,125,143,63},
            new int[]{255,248,125,143,64},
            new int[]{255,249,125,143,65},
            new int[]{255,250,125,143,66},
            new int[]{255,250,172,152,67},
            new int[]{255,249,173,154,68},
            new int[]{255,248,174,156,69},
            new int[]{255,247,175,158,70},
            new int[]{255,246,176,160,71},
            new int[]{255,245,177,162,72},
            new int[]{255,244,178,164,73},
            new int[]{255,243,179,166,74},
            new int[]{255,242,180,168,75},
            new int[]{255,241,181,170,76},
            new int[]{255,240,182,172,77},
            new int[]{255,239,183,174,78},
            new int[]{255,238,184,176,79},
            new int[]{255,237,185,178,80},
            new int[]{255,236,186,180,81},
            new int[]{255,235,187,182,82},
            new int[]{255,234,188,184,83},
            new int[]{255,233,189,186,84},
            new int[]{255,232,190,188,85},
            new int[]{255,231,191,190,86},
            new int[]{255,230,192,192,87},
            new int[]{255,229,193,194,88},
            new int[]{255,228,194,196,89},
            new int[]{255,227,195,198,90},
            new int[]{255,226,196,200,91},
            new int[]{255,225,197,202,92},
            new int[]{255,224,198,204,93},
            new int[]{255,223,199,206,94},
            new int[]{255,222,200,208,95},
            new int[]{255,221,201,210,96},
            new int[]{255,220,202,212,97},
            new int[]{255,219,203,214,98},
            new int[]{255,218,204,216,99},
            new int[]{255,217,205,218,100},
            new int[]{255,216,206,220,101},
            new int[]{255,215,207,222,102},
            new int[]{255,214,208,224,103},
            new int[]{255,213,209,226,104},
            new int[]{255,212,210,228,105},
            new int[]{255,211,211,230,106},
            new int[]{255,210,212,232,107},
            new int[]{255,209,213,234,108},
            new int[]{255,208,214,236,109},
            new int[]{255,208,214,236,110},
            new int[]{255,208,219,237,111},
            new int[]{255,208,224,238,112},
            new int[]{255,208,229,239,113},
            new int[]{255,208,234,240,114},
            new int[]{255,208,239,241,115},
            new int[]{255,208,244,242,116},
            new int[]{255,208,247,244,117},
            new int[]{255,207,242,240,118},
            new int[]{255,206,237,236,119},
            new int[]{255,205,232,232,120},
            new int[]{255,204,227,228,121},
            new int[]{255,203,222,224,122},
            new int[]{255,202,217,220,123},
            new int[]{255,201,212,216,124},
            new int[]{255,200,207,212,125},
            new int[]{255,199,202,208,126},
            new int[]{255,198,197,204,127},
            new int[]{255,197,192,200,128},
            new int[]{255,196,187,196,129},
            new int[]{255,195,182,192,130},
            new int[]{255,194,177,188,131},
            new int[]{255,193,172,184,132},
            new int[]{255,192,167,180,133},
            new int[]{255,191,162,176,134},
            new int[]{255,190,157,172,135},
            new int[]{255,189,152,168,136},
            new int[]{255,188,147,164,137},
            new int[]{255,187,142,160,138},
            new int[]{255,186,137,156,139},
            new int[]{255,185,132,152,140},
            new int[]{255,184,127,148,141},
            new int[]{255,184,127,147,142},
            new int[]{255,184,127,146,143},
            new int[]{255,184,127,145,144},
            new int[]{255,184,127,144,145},
            new int[]{255,184,127,143,146},


    };

    private gridBlock[][] blocks = new gridBlock[5][5];
    private Vector<enemy> enemies;
    private Vector<int []> occupied = new Vector<int[]>();

    private Vector<DrawableObj> backgroundGrid = new Vector<DrawableObj>();
    private Vector<DrawableObj> dynamic = new Vector<DrawableObj>();
    private Vector<DrawableObj> drawMe = new Vector<DrawableObj>();

    private int[] baseCoordinates;

    private int frame;
    private int perFrames = 3;

    private int difficulty;

    private int sensitivity;

    int boxSize;

    public grid(int width, int height, int difficulty){

        sensitivity = 18-difficulty*3;

        this.difficulty = difficulty;
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

    private int[] getCoordinatesR(int index){
        Random rgen = new Random();
        int x;
        int y;
        
        int[] temp = occupied.get(index);

        int xplus;
        if (temp[0]+1 > 4){
            xplus = 4;
        } else {
            xplus = temp[0]+1;
        }
        int yplus;
        if (temp[1]+1 > 4){
            yplus = 4;
        } else {
            yplus = temp[1]+1;
        }
        int yless;
        if (temp[1]-1 < 0){
            yless = 0;
        } else {
            yless = temp[1]-1;
        }
        int xless;
        if (temp[0]-1 < 0){
            xless = 0;
        } else {
            xless = temp[0]-1;
        }

        if ((isContained(temp[0],yplus) && isContained(temp[0],yless) && isContained(xless,temp[1]) && isContained(xless,yless) && isContained(xless,yplus) && isContained(xplus,temp[1]) && isContained(xplus,yless) && isContained(xplus,yplus))){
            return new int []{temp[0],temp[1]};
        }
        
        if (rgen.nextBoolean()){
            x = xplus;
        } else {
            x = xless;
        }
        if (rgen.nextBoolean()){
            y = yplus;
        } else {
            y = yless;
        }

        while(isContained(x,y)){
            if (rgen.nextBoolean()){
                x = xplus;
            } else {
                x = xless;
            }
            if (rgen.nextBoolean()){
                y = yplus;
            } else {
                y = yless;
            }
        }
        occupied.add(index,new int[]{x,y});
        occupied.remove(index+1);
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
        Random rgen = new Random();
        for (int i = 0; i < size; i++){
            enemies.add(i,new enemy(new int[]{255,243,142,150}));
            enemies.get(i).setDraw(getCoordinates(), boxSize, baseCoordinates);
            enemies.get(i).setColor(clrs[rgen.nextInt(clrs.length)]);
            dynamic.add(i, enemies.get(i).getDrawable());
        }
    }

    private void moveEnemies(int i){
        Random rgen = new Random();
            enemies.add(i,new enemy(enemies.get(i).getColor()));
            enemies.remove(i+1);
            enemies.get(i).setDraw(getCoordinatesR(i), boxSize, baseCoordinates);
            dynamic.add(i, enemies.get(i).getDrawable());
            dynamic.remove(i+1);
    }

    private boolean enemyAt(int x, int y){
        for (int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).collide(x,y)){

                return true;
            }
        }
        return false;
    }

    private boolean enemyMatch(int x, int y){
        for (int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).collide(x,y)){
                if (difficulty == 0){
                    if (enemies.get(i).getColor()[4]>67-sensitivity && enemies.get(i).getColor()[4]<67+sensitivity){
                        occupied.remove(i);
                        enemies.remove(i);
                        return true;
                    }
                }
                if (difficulty == 1){
                    if ((enemies.get(i).getColor()[4]<147-sensitivity) && enemies.get(i).getColor()[4]<0+sensitivity){
                        occupied.remove(i);
                        enemies.remove(i);
                        return true;
                    }
                    if (enemies.get(i).getColor()[4]>117-sensitivity && enemies.get(i).getColor()[4]<117+sensitivity){
                        occupied.remove(i);
                        enemies.remove(i);
                        return true;
                    }
                }
                if (difficulty == 2){
                    if ((enemies.get(i).getColor()[4]<147-sensitivity) && enemies.get(i).getColor()[4]<0+sensitivity){
                        occupied.remove(i);
                        enemies.remove(i);
                        return true;
                    }
                    if (enemies.get(i).getColor()[4]>67-sensitivity && enemies.get(i).getColor()[4]<67+sensitivity){
                        occupied.remove(i);
                        enemies.remove(i);
                        return true;
                    }
                    if (enemies.get(i).getColor()[4]>117-sensitivity && enemies.get(i).getColor()[4]<117+sensitivity){
                        occupied.remove(i);
                        enemies.remove(i);
                        return true;
                    }

                }


                return true;
            }
        }
        return false;
    }

    public Vector<DrawableObj> tap(int x, int y){
        if(enemyAt(x,y)) {
            if (enemyMatch(x,y)){

            }
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
        if (frame > 100){
            frame = 0;
        }
        frame++;
        if (frame % perFrames == 0) {
            for (int i = 0; i < enemies.size(); i++) {
                nextColor(i);

            }
        }
        if (frame == 99) {
            Random rgen = new Random();
            moveEnemies(rgen.nextInt(enemies.size()));
        }
        reAdd();
        return drawMe;
    }

    private void nextColor(int i){
        int []c = enemies.get(i).getColor();
        int index = c[4];
        if (index == 146){
            c = clrs[0];
            enemies.get(i).setColor(c);
        } else {
            c = clrs[index+1];
            enemies.get(i).setColor(c);
        }
    }
    //0, 67, 117
}
