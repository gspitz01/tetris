package com.gregspitz.tetris.shape;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for {@link RightStep}
 */
public class RightStepTest {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private RightStep rightStep;

    @Before
    public void setup() {
        rightStep = new RightStep(START_X, START_Y);
    }

    @Test
    public void constructor_setsColorToGreen() {
        assertEquals('G', rightStep.getColor());
    }

    @Test
    public void constructor_setsBlocksToRightStepShape() {
        assertInitialPosition();
    }

    @Test
    public void moveRight_movesAllBlockRightOne() {
        rightStep.moveRight();
        assertEquals(START_X + 1, rightStep.getBlocks()[0].getX());
        assertEquals(START_X + 2, rightStep.getBlocks()[1].getX());
        assertEquals(START_X + 2, rightStep.getBlocks()[2].getX());
        assertEquals(START_X + 3, rightStep.getBlocks()[3].getX());
    }

    @Test
    public void moveLeft_movesAllBlocksLeftOne() {
        rightStep.moveLeft();
        assertEquals(START_X - 1, rightStep.getBlocks()[0].getX());
        assertEquals(START_X, rightStep.getBlocks()[1].getX());
        assertEquals(START_X, rightStep.getBlocks()[2].getX());
        assertEquals(START_X + 1, rightStep.getBlocks()[3].getX());
    }

    @Test
    public void moveDown_movesAllBlocksOnePositiveY() {
        rightStep.moveDown();
        assertEquals(START_Y + 1, rightStep.getBlocks()[0].getY());
        assertEquals(START_Y + 1, rightStep.getBlocks()[1].getY());
        assertEquals(START_Y, rightStep.getBlocks()[2].getY());
        assertEquals(START_Y, rightStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateOnce_adjustsBlockLocations() {
        rightStep.rotate();
        assertEquals(START_X, rightStep.getBlocks()[0].getX());
        assertEquals(START_Y - 1, rightStep.getBlocks()[0].getY());
        assertEquals(START_X, rightStep.getBlocks()[1].getX());
        assertEquals(START_Y, rightStep.getBlocks()[1].getY());
        assertEquals(START_X + 1 , rightStep.getBlocks()[2].getX());
        assertEquals(START_Y, rightStep.getBlocks()[2].getY());
        assertEquals(START_X + 1, rightStep.getBlocks()[3].getX());
        assertEquals(START_Y + 1, rightStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateTwice_getsBackToOriginalPosition() {
        rightStep.rotate();
        rightStep.rotate();
        assertInitialPosition();
    }

    private void assertInitialPosition() {
        assertEquals(START_X, rightStep.getBlocks()[0].getX());
        assertEquals(START_Y, rightStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, rightStep.getBlocks()[1].getX());
        assertEquals(START_Y, rightStep.getBlocks()[1].getY());
        assertEquals(START_X + 1 , rightStep.getBlocks()[2].getX());
        assertEquals(START_Y - 1, rightStep.getBlocks()[2].getY());
        assertEquals(START_X + 2, rightStep.getBlocks()[3].getX());
        assertEquals(START_Y - 1, rightStep.getBlocks()[3].getY());
    }
}
