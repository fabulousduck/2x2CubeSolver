package com.pyonium.cube;

import java.awt.*;

public class CubeButton extends Button {

    private int color;
    private int id;

    public CubeButton(int _id){
        super(String.valueOf(_id));
        id = _id;
        if(id <= 3){
            color = 0;
        } else if(id >= 4 && id <= 7){
            color = 1;
        } else if(id >= 8 && id <= 11){
            color = 2;
        } else if(id >= 12 && id <= 15){
            color = 3;
        } else if(id >= 16 && id <= 19){
            color = 4;
        } else if(id >= 20 && id <= 23){
            color = 5;
        }
        InputWindow.buttons.put(_id, this);
        updateColor();
    }

    public void updateColor(){
        switch(color){
            case 0:
                this.setBackground(Color.YELLOW);
                break;
            case 1:
                setBackground(Color.GREEN);
                break;
            case 2:
                setBackground(Color.WHITE);
                break;
            case 3:
                setBackground(Color.BLUE);
                break;
            case 4:
                setBackground(Color.RED);
                break;
            case 5:
                setBackground(Color.ORANGE);
                break;
        }
    }

    public void incrementColor(){
        color = (color + 1) % 6;
        updateColor();
    }

    public int getColor(){
        return color;
    }

}
