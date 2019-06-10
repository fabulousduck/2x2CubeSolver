package com.pyonium.cube;

import java.awt.*;

public class CubeButton extends Button {

    private int color;
    private int id;

    public CubeButton(int _id, int _color){
        super(String.valueOf(_id));
        id = _id;
        color = _color;
        InputWindow.buttons.put(_id, this);
        updateColor();
    }

    public void updateColor(){
        switch(color){
            case 0:
                this.setBackground(Color.YELLOW);
                break;
        }
    }
}
