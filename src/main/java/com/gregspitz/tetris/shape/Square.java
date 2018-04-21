package com.gregspitz.tetris.shape;

import java.awt.*;

public class Square extends Shape {

    /**
     * All squares are red
     * Initial block numbering:
     * |1|2|
     * |3|4|
     * @param startX left starting position of the Square
     * @param startY top starting position of the Square
     */
    public Square(int startX, int startY) {
        super(Color.RED);
        int[] xs = new int[NUM_BLOCKS];
        int[] ys = new int[NUM_BLOCKS];
        xs[0] = startX;
        ys[0] = startY;
        xs[1] = startX + 1;
        ys[1] = startY;
        xs[2] = startX;
        ys[2] = startY + 1;
        xs[3] = startX + 1;
        ys[3] = startY + 1;
        setBlocks(xs, ys);
    }


    @Override
    public void rotate() {
        // Doesn't do anything for a square
    }
}
