package com.gregspitz.tetris.shape;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StraightTest {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private Straight straight;

    @Before
    public void setup() {
        straight = new Straight(START_X, START_Y);
    }

    @Test
    public void constructor_setsColorToBlue() {
        assertEquals('B', straight.getColor());
    }

    @Test
    public void constructor_setBlocksInStraightVerticalLine() {
        assertInitialPosition();
    }

    @Test
    public void moveRight_movesAllBlocksRightOne() {
        straight.moveRight();
        for (Block block : straight.getBlocks()) {
            assertEquals(START_X + 1, block.getX());
        }
    }

    @Test
    public void moveLeft_movesAllBlocksLeftOne() {
        straight.moveLeft();
        for (Block block : straight.getBlocks()) {
            assertEquals(START_X - 1, block.getX());
        }
    }

    @Test
    public void moveDown_movesAllBlocksOnePositiveY() {
        straight.moveDown();
        for (int i = 0; i < Shape.NUM_BLOCKS; i++) {
            assertEquals(START_Y + i + 1, straight.getBlocks()[i].getY());
        }
    }

    @Test
    public void rotateOnce_makesItHorizontal() {
        straight.rotate();
        for (int i = 0; i < Shape.NUM_BLOCKS; i++) {
            assertEquals(START_Y + 1, straight.getBlocks()[i].getY());
            assertEquals(START_X - 2 + i, straight.getBlocks()[i].getX());
        }
    }

    @Test
    public void rotateTwice_getsBackToOriginalPosition() {
        straight.rotate();
        straight.rotate();
        assertInitialPosition();
    }

    private void assertInitialPosition() {
        for (int i = 0; i < Shape.NUM_BLOCKS; i++) {
            assertEquals(START_X, straight.getBlocks()[i].getX());
            assertEquals(START_Y + i, straight.getBlocks()[i].getY());
        }
    }
}
