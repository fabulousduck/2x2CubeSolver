package com.pyonium.cube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class InputWindow extends Frame {

    /*
     * A solved cube has the string "yyyyggggwwwwbbbbrrrroooo". Flat projection, first top to bottom, then left to right.
     */

    static InputWindow w;
    static HashMap<Integer, CubeButton> buttons = new HashMap<>();

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
            CubeButton c = new CubeButton(i);
            columns[2].add(c);
        }
        for(int i = 1; i <= 15; i = i + 2){
            CubeButton c = new CubeButton(i);
            columns[3].add(c);
        }
        for(int i = 0; i < 8; i++){
            if(i == 2 || i == 3){
                CubeButton c = new CubeButton(12 + 2 * i);
                columns[0].add(c);
            } else {
                JLabel j = new JLabel("");
                columns[0].add(j);
            }
        }
        for(int i = 0; i < 8; i++){
            if(i == 2 || i == 3){
                CubeButton c = new CubeButton(13 + 2 * i);
                columns[1].add(c);
            } else {
                JLabel j = new JLabel("");
                columns[1].add(j);
            }
        }
        for(int i = 0; i < 8; i++){
            if(i == 2 || i == 3){
                CubeButton c = new CubeButton(16 + 2 * i);
                columns[4].add(c);
            } else {
                JLabel j = new JLabel("");
                columns[4].add(j);
            }
        }
        for(int i = 0; i < 7; i++){
            if(i == 2 || i == 3){
                CubeButton c = new CubeButton(17 + 2 * i);
                columns[5].add(c);
            } else {
                JLabel j = new JLabel("");
                columns[5].add(j);
            }
        }
        Button b = new Button("Solve!");
        b.addActionListener(e -> {
            Cube.makeCube().solve();
        });
        columns[5].add(b);

        for(int i = 0; i < 24; i++){
            buttons.get(i).addActionListener(e -> {
                buttons.get(Integer.parseInt(e.getActionCommand())).incrementColor();
            });
        }
    }

    public static void main(String[] args){
        w = new InputWindow();
        w.setTitle("kut");
        w.setSize(400, 600);
        w.setVisible(true);
    }

}
