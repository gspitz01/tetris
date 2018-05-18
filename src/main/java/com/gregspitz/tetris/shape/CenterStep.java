package com.gregspitz.tetris.shape;

public class CenterStep extends Shape {

    /**
     * Direction:
     * 0: step on top
     * 1: step to right
     * 2: step on bottom
     * 3: step to left
     */
    private int direction;

    /**
     * All CenterSteps are yellow
     * Starts with step on top
     * Initial block positions:
     *   |2|
     * |1|3|4|
     * @param startX starting x position for #1 block
     * @param startY starting y position for #1 block
     */
    public CenterStep(int startX, int startY) {
        super('Y');
        int[] xs = new int[NUM_BLOCKS];
        int[] ys = new int[NUM_BLOCKS];
        xs[0] = startX;
        ys[0] = startY;
        xs[1] = startX + 1;
        ys[1] = startY - 1;
        xs[2] = startX + 1;
        ys[2] = startY;
        xs[3] = startX + 2;
        ys[3] = startY;
        setBlocks(xs, ys);
        direction = 0;
    }

    @Override
    public void rotate() {
        switch (direction) {
            case 0:
                blocks[0].setX(blocks[0].getX() + 1);
                blocks[0].setY(blocks[0].getY() - 1);
                blocks[1].setX(blocks[1].getX() + 1);
                blocks[1].setY(blocks[1].getY() + 1);
                blocks[3].setX(blocks[3].getX() - 1);
                blocks[3].setY(blocks[3].getY() + 1);
                direction = 1;
                break;
            case 1:
                blocks[0].setX(blocks[0].getX() + 1);
                blocks[0].setY(blocks[0].getY() + 1);
                blocks[1].setX(blocks[1].getX() - 1);
                blocks[1].setY(blocks[1].getY() + 1);
                blocks[3].setX(blocks[3].getX() - 1);
                blocks[3].setY(blocks[3].getY() - 1);
                direction = 2;
                break;
            case 2:
                blocks[0].setX(blocks[0].getX() - 1);
                blocks[0].setY(blocks[0].getY() + 1);
                blocks[1].setX(blocks[1].getX() - 1);
                blocks[1].setY(blocks[1].getY() - 1);
                blocks[3].setX(blocks[3].getX() + 1);
                blocks[3].setY(blocks[3].getY() - 1);
                direction = 3;
                break;
            case 3:
                blocks[0].setX(blocks[0].getX() - 1);
                blocks[0].setY(blocks[0].getY() - 1);
                blocks[1].setX(blocks[1].getX() + 1);
                blocks[1].setY(blocks[1].getY() - 1);
                blocks[3].setX(blocks[3].getX() + 1);
                blocks[3].setY(blocks[3].getY() + 1);
                direction = 0;
                break;
        }
        stayInBounds();
    }
}
