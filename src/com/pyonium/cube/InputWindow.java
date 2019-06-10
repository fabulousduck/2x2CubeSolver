package com.pyonium.cube;

import java.awt.*;
import java.util.HashMap;

public class InputWindow extends Frame {

    /*
     * A solved cube has the string "yyyyggggwwwwbbbbrrrroooo". Flat projection, first top to bottom, then left to right.
     */

    static HashMap<Integer, Button> buttons = new HashMap<>();

    Container[] columns = new Container[6];

    public InputWindow(){
        Panel p = new Panel();
        add(p);
        p.setLayout(new GridLayout(1,6));
        for(int i = 0; i < 6; i++){
            columns[i] = new Container();
            columns[i].setLayout(new GridLayout(8,1));
            p.add(columns[i]);
        }
        for(int i = 0; i <= 14; i = i + 2){
            CubeButton c = new CubeButton(i, 0);
            columns[2].add(c);
        }
        for(int i = 1; i <= 15; i = i + 2){
            CubeButton c = new CubeButton(i, 0);
            columns[3].add(c);
        }
    }

    public static void main(String[] args){
        InputWindow w = new InputWindow();
        w.setTitle("kut");
        w.setSize(400, 600);
        w.setVisible(true);
        Cube c = new Cube("ooggwwgorbwrbyybgrryowyb");
        c.solve();
    }

}
