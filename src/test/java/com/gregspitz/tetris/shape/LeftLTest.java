package com.gregspitz.tetris.shape;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link LeftL}
 */
public class LeftLTest {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private LeftL leftL;

    @Before
    public void setup() {
        leftL = new LeftL(START_X, START_Y);
    }

    @Test
    public void constructor_setsColorOrange() {
        assertEquals('O', leftL.getColor());
    }

    @Test
    public void constructor_setsBlocksToLeftLShape() {
        assertInitialPosition();
    }

    @Test
    public void moveRight_movesAllBlocksRightOne() {
        leftL.moveRight();
        assertEquals(START_X + 1, leftL.getBlocks()[0].getX());
        assertEquals(START_Y, leftL.getBlocks()[0].getY());
        assertEquals(START_X + 2, leftL.getBlocks()[1].getX());
        assertEquals(START_Y - 2, leftL.getBlocks()[1].getY());
        assertEquals(START_X + 2, leftL.getBlocks()[2].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[2].getY());
        assertEquals(START_X + 2, leftL.getBlocks()[3].getX());
        assertEquals(START_Y, leftL.getBlocks()[3].getY());
    }

    @Test
    public void moveLeft_movesAllBlocksLeftOne() {
        leftL.moveLeft();
        assertEquals(START_X - 1, leftL.getBlocks()[0].getX());
        assertEquals(START_Y, leftL.getBlocks()[0].getY());
        assertEquals(START_X, leftL.getBlocks()[1].getX());
        assertEquals(START_Y - 2, leftL.getBlocks()[1].getY());
        assertEquals(START_X, leftL.getBlocks()[2].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[2].getY());
        assertEquals(START_X, leftL.getBlocks()[3].getX());
        assertEquals(START_Y, leftL.getBlocks()[3].getY());
    }

    @Test
    public void moveDown_movesAllBlockOnePositiveY() {
        leftL.moveDown();
        assertEquals(START_X, leftL.getBlocks()[0].getX());
        assertEquals(START_Y + 1, leftL.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[1].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[1].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[2].getX());
        assertEquals(START_Y , leftL.getBlocks()[2].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[3].getX());
        assertEquals(START_Y + 1, leftL.getBlocks()[3].getY());
    }

    @Test
    public void rotateOnce_turnsShapeLUp() {
        leftL.rotate();
        assertEquals(START_X, leftL.getBlocks()[0].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[0].getY());
        assertEquals(START_X, leftL.getBlocks()[1].getX());
        assertEquals(START_Y, leftL.getBlocks()[1].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[2].getX());
        assertEquals(START_Y, leftL.getBlocks()[2].getY());
        assertEquals(START_X + 2, leftL.getBlocks()[3].getX());
        assertEquals(START_Y, leftL.getBlocks()[3].getY());
    }

    @Test
    public void rotateTwice_turnsShapeToUpsideDownL() {
        leftL.rotate();
        leftL.rotate();
        assertEquals(START_X, leftL.getBlocks()[0].getX());
        assertEquals(START_Y - 2, leftL.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[1].getX());
        assertEquals(START_Y - 2, leftL.getBlocks()[1].getY());
        assertEquals(START_X, leftL.getBlocks()[2].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[2].getY());
        assertEquals(START_X, leftL.getBlocks()[3].getX());
        assertEquals(START_Y, leftL.getBlocks()[3].getY());
    }

    @Test
    public void rotateThrice_turnsShapeToDownFacingL() {
        leftL.rotate();
        leftL.rotate();
        leftL.rotate();
        assertEquals(START_X, leftL.getBlocks()[0].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[1].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[1].getY());
        assertEquals(START_X + 2, leftL.getBlocks()[2].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[2].getY());
        assertEquals(START_X + 2, leftL.getBlocks()[3].getX());
        assertEquals(START_Y, leftL.getBlocks()[3].getY());
    }

    @Test
    public void rotateFourTimes_returnsShapeToOriginalPosition() {
        leftL.rotate();
        leftL.rotate();
        leftL.rotate();
        leftL.rotate();
        assertInitialPosition();
    }

    private void assertInitialPosition() {
        assertEquals(START_X, leftL.getBlocks()[0].getX());
        assertEquals(START_Y, leftL.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[1].getX());
        assertEquals(START_Y - 2, leftL.getBlocks()[1].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[2].getX());
        assertEquals(START_Y - 1, leftL.getBlocks()[2].getY());
        assertEquals(START_X + 1, leftL.getBlocks()[3].getX());
        assertEquals(START_Y, leftL.getBlocks()[3].getY());
    }
}
