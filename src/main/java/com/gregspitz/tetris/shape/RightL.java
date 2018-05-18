package com.gregspitz.tetris.shape;

import java.awt.*;

public class RightL extends Shape {

    private int direction;

    /**
     * Right L's are always cyan
     * Initial block positions:
     * |1|   |1|2|3| |1|2|      |3|
     * |2|   |4|       |3|  |1|2|4|
     * |3|4|           |4|
     * @param startX starting x position for 1 block
     * @param startY starting y position for 1 block
     */
    public RightL(int startX, int startY) {
        super(Color.CYAN);
        int[] xs = new int[NUM_BLOCKS];
        int[] ys = new int[NUM_BLOCKS];
        xs[0] = startX;
        ys[0] = startY;
        xs[1] = startX;
        ys[1] = startY + 1;
        xs[2] = startX;
        ys[2] = startY + 2;
        xs[3] = startX + 1;
        ys[3] = startY + 2;
        setBlocks(xs, ys);
        direction = 0;
    }

    @Override
    public void rotate() {
        switch (direction) {
            case 0:
                getBlocks()[1].setX(getBlocks()[1].getX() + 1);
                getBlocks()[1].setY(getBlocks()[1].getY() - 1);
                getBlocks()[2].setX(getBlocks()[2].getX() + 2);
                getBlocks()[2].setY(getBlocks()[2].getY() - 2);
                getBlocks()[3].setX(getBlocks()[3].getX() - 1);
                getBlocks()[3].setY(getBlocks()[3].getY() - 1);
                direction = 1;
                break;
            case 1:
                getBlocks()[2].setX(getBlocks()[2].getX() - 1);
                getBlocks()[2].setY(getBlocks()[2].getY() + 1);
                getBlocks()[3].setX(getBlocks()[3].getX() + 1);
                getBlocks()[3].setY(getBlocks()[3].getY() + 1);
                direction = 2;
                break;
            case 2:
                getBlocks()[0].setY(getBlocks()[0].getY() + 1);
                getBlocks()[1].setY(getBlocks()[1].getY() + 1);
                getBlocks()[2].setX(getBlocks()[2].getX() + 1);
                getBlocks()[2].setY(getBlocks()[2].getY() - 1);
                getBlocks()[3].setX(getBlocks()[3].getX() + 1);
                getBlocks()[3].setY(getBlocks()[3].getY() - 1);
                direction = 3;
                break;
            case 3:
                getBlocks()[0].setY(getBlocks()[0].getY() - 1);
                getBlocks()[1].setX(getBlocks()[1].getX() - 1);
                getBlocks()[2].setX(getBlocks()[2].getX() - 2);
                getBlocks()[2].setY(getBlocks()[2].getY() + 2);
                getBlocks()[3].setX(getBlocks()[3].getX() - 1);
                getBlocks()[3].setY(getBlocks()[3].getY() + 1);
                direction = 0;
                break;
        }
    }
}
