package com.gregspitz.tetris.shape;

public class LeftL extends Shape {

    /**
     * Direction:
     * 0: L to left (reverse Roman capital L)
     * 1: L up
     * 2: L top right
     * 3: L down
     */
    private int direction;

    /**
     * Left L shape is always orange
     * Block positions:
     *   |2|          |1|2|
     *   |3|  |1|     |3|   |1|2|3|
     * |1|4|  |2|3|4| |4|       |4|
     * @param startX x position of 1 block
     * @param startY y position of 1 block
     */
    public LeftL(int startX, int startY) {
        super('O');
        int[] xs = new int[NUM_BLOCKS];
        int[] ys = new int[NUM_BLOCKS];
        xs[0] = startX;
        ys[0] = startY;
        xs[1] = startX + 1;
        ys[1] = startY - 2;
        xs[2] = startX + 1;
        ys[2] = startY - 1;
        xs[3] = startX + 1;
        ys[3] = startY;
        setBlocks(xs, ys);
        direction = 0;
    }

    @Override
    public void rotate() {
        switch(direction) {
            case 0:
                getBlocks()[0].setY(getBlocks()[0].getY() - 1);
                getBlocks()[1].setX(getBlocks()[1].getX() - 1);
                getBlocks()[1].setY(getBlocks()[1].getY() + 2);
                getBlocks()[2].setY(getBlocks()[2].getY() + 1);
                getBlocks()[3].setX(getBlocks()[3].getX() + 1);
                direction = 1;
                break;
            case 1:
                getBlocks()[0].setY(getBlocks()[0].getY() - 1);
                getBlocks()[1].setX(getBlocks()[1].getX() + 1);
                getBlocks()[1].setY(getBlocks()[1].getY() - 2);
                getBlocks()[2].setX(getBlocks()[2].getX() - 1);
                getBlocks()[2].setY(getBlocks()[2].getY() - 1);
                getBlocks()[3].setX(getBlocks()[3].getX() - 2);
                direction = 2;
                break;
            case 2:
                getBlocks()[0].setY(getBlocks()[0].getY() + 1);
                getBlocks()[1].setY(getBlocks()[1].getY() + 1);
                getBlocks()[2].setX(getBlocks()[2].getX() + 2);
                getBlocks()[3].setX(getBlocks()[3].getX() + 2);
                direction = 3;
                break;
            case 3:
                getBlocks()[0].setY(getBlocks()[0].getY() + 1);
                getBlocks()[1].setY(getBlocks()[1].getY() - 1);
                getBlocks()[2].setX(getBlocks()[2].getX() - 1);
                getBlocks()[3].setX(getBlocks()[3].getX() - 1);
                direction = 0;
                break;
        }
    }
}
