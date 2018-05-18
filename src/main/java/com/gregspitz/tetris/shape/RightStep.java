package com.gregspitz.tetris.shape;

public class RightStep extends Shape {

    private boolean horizontal;

    /**
     * All RightSteps are green
     * Starts horizontal
     * Initial block numbering:
     *   |3|4|
     * |1|2|
     * @param startX starting x position of 1 block
     * @param startY starting y position of 1 block
     */
    public RightStep(int startX, int startY) {
        super('G');
        int[] xs = new int[NUM_BLOCKS];
        int[] ys = new int[NUM_BLOCKS];
        xs[0] = startX;
        ys[0] = startY;
        xs[1] = startX + 1;
        ys[1] = startY;
        xs[2] = startX + 1;
        ys[2] = startY - 1;
        xs[3] = startX + 2;
        ys[3] = startY - 1;
        setBlocks(xs, ys);
        horizontal = true;
    }

    @Override
    public void rotate() {
        if (horizontal) {
            getBlocks()[0].setY(getBlocks()[0].getY() - 1);
            getBlocks()[1].setX(getBlocks()[1].getX() - 1);
            getBlocks()[2].setY(getBlocks()[2].getY() + 1);
            getBlocks()[3].setX(getBlocks()[3].getX() - 1);
            getBlocks()[3].setY(getBlocks()[3].getY() + 2);
        } else {
            getBlocks()[0].setY(getBlocks()[0].getY() + 1);
            getBlocks()[1].setX(getBlocks()[1].getX() + 1);
            getBlocks()[2].setY(getBlocks()[2].getY() - 1);
            getBlocks()[3].setX(getBlocks()[3].getX() + 1);
            getBlocks()[3].setY(getBlocks()[3].getY() - 2);
        }
        horizontal = !horizontal;
    }
}
