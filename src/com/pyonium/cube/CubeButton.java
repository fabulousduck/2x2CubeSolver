package com.pyonium.cube;

import java.awt.*;

public class CubeButton extends Button {

    private int color;
    private int id;

    public CubeButton(int _id, int _color){
        super(String.valueOf(_id));
        color = _color;
    }
}
