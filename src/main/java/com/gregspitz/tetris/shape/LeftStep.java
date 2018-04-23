package com.gregspitz.tetris.shape;

import java.awt.*;

public class LeftStep extends Shape {

    private boolean horizontal;

    /**
     * All LeftSteps are magenta
     * Starts horizontal
     * Initial block positions:
     * |1|2|
     *   |3|4|
     * @param startX starting x position of #1 block
     * @param startY starting y position of #1 block
     */
    public LeftStep(int startX, int startY) {
        super(Color.MAGENTA);
        int[] xs = new int[NUM_BLOCKS];
        int[] ys = new int[NUM_BLOCKS];
        xs[0] = startX;
        ys[0] = startY;
        xs[1] = startX + 1;
        ys[1] = startY;
        xs[2] = startX + 1;
        ys[2] = startY + 1;
        xs[3] = startX + 2;
        ys[3] = startY + 1;
        setBlocks(xs, ys);
        horizontal = true;
    }

    @Override
    public void rotate() {
        if (horizontal) {
            blocks[0].setX(blocks[0].getX() + 1);
            blocks[1].setY(blocks[1].getY() + 1);
            blocks[2].setX(blocks[2].getX() - 1);
            blocks[3].setX(blocks[3].getX() - 2);
            blocks[3].setY(blocks[3].getY() + 1);
        } else {
            blocks[0].setX(blocks[0].getX() - 1);
            blocks[1].setY(blocks[1].getY() - 1);
            blocks[2].setX(blocks[2].getX() + 1);
            blocks[3].setX(blocks[3].getX() + 2);
            blocks[3].setY(blocks[3].getY() - 1);
        }
        horizontal = !horizontal;
    }
}
