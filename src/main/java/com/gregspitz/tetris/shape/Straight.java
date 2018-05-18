package com.gregspitz.tetris.shape;

public class Straight extends Shape {

    private boolean vertical;

    /**
     * All Straights are blue
     * Initial block numbering:
     * |1|
     * |2|
     * |3|
     * |4|
     * starts vertical
     * @param startX x of top block
     * @param startY y of top block
     */
    public Straight(int startX, int startY) {
        super('B');
        int[] xs = new int[NUM_BLOCKS];
        int[] ys = new int[NUM_BLOCKS];
        for (int i = 0; i < NUM_BLOCKS; i++) {
            xs[i] = startX;
            ys[i] = startY + i;
        }
        setBlocks(xs, ys);
        vertical = true;
    }

    @Override
    public void rotate() {
        if (vertical) {
            // If it's already vertical
            int secondBlockY = blocks[1].getY();
            // All blocks have the same X position
            int blocksX = blocks[0].getX();

            // Set all y's to the y of the second block
            for (Block block : blocks) {
                block.setY(secondBlockY);
            }

            // Set x's increasing from 2 behind the current x
            blocks[0].setX(blocksX - 2);
            blocks[1].setX(blocksX - 1);
            blocks[2].setX(blocksX);
            blocks[3].setX(blocksX + 1);
        } else {
            // If it's horizontal
            // All blocks have the same Y position
            int blocksY = blocks[0].getY();
            int secondBlockX = blocks[2].getX();

            // Set all blocks to the x of the third block
            for (Block block : blocks) {
                block.setX(secondBlockX);
            }

            // Set y's increasing from 1 behind current y
            blocks[0].setY(blocksY - 1);
            blocks[1].setY(blocksY);
            blocks[2].setY(blocksY + 1);
            blocks[3].setY(blocksY + 2);
        }
        vertical = !vertical;
    }
}
