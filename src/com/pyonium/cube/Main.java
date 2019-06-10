package com.pyonium.cube;

public class Main {

    /*
     * A solved cube has the string "yyyyggggwwwwbbbbrrrroooo". Flat projection, first top to bottom, then left to right.
     */

    public static void main(String[] args){
        Cube c = new Cube("ooggwwgorbwrbyybgrryowyb");
        c.solve();
    }

}
