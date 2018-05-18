package com.gregspitz.tetris.shape;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for {@link LeftStep}
 */
public class LeftStepTest {

    // TODO: add equals tests

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private LeftStep leftStep;

    @Before
    public void setup() {
        leftStep = new LeftStep(START_X, START_Y);
    }

    @Test
    public void constructor_setsColorToMagenta() {
        assertEquals('M', leftStep.getColor());
    }

    @Test
    public void constructor_setsBlocksToLeftStepShape() {
        assertEquals(START_X, leftStep.getBlocks()[0].getX());
        assertEquals(START_Y, leftStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[1].getX());
        assertEquals(START_Y, leftStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[2].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[2].getY());
        assertEquals(START_X + 2, leftStep.getBlocks()[3].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[3].getY());
    }

    @Test
    public void moveRight_movesAllBlocksRightOne() {
        leftStep.moveRight();
        assertEquals(START_X + 1, leftStep.getBlocks()[0].getX());
        assertEquals(START_Y, leftStep.getBlocks()[0].getY());
        assertEquals(START_X + 2, leftStep.getBlocks()[1].getX());
        assertEquals(START_Y, leftStep.getBlocks()[1].getY());
        assertEquals(START_X + 2, leftStep.getBlocks()[2].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[2].getY());
        assertEquals(START_X + 3, leftStep.getBlocks()[3].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[3].getY());
    }

    @Test
    public void moveLeft_movesAllBlocksLeftOne() {
        leftStep.moveLeft();
        assertEquals(START_X - 1, leftStep.getBlocks()[0].getX());
        assertEquals(START_Y, leftStep.getBlocks()[0].getY());
        assertEquals(START_X, leftStep.getBlocks()[1].getX());
        assertEquals(START_Y, leftStep.getBlocks()[1].getY());
        assertEquals(START_X, leftStep.getBlocks()[2].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[2].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[3].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[3].getY());
    }

    @Test
    public void moveDown_movesOnePositiveY() {
        leftStep.moveDown();
        assertEquals(START_X, leftStep.getBlocks()[0].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[1].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[2].getX());
        assertEquals(START_Y + 2, leftStep.getBlocks()[2].getY());
        assertEquals(START_X + 2, leftStep.getBlocks()[3].getX());
        assertEquals(START_Y + 2, leftStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateOnce_turnsShapeVertical() {
        leftStep.rotate();
        assertEquals(START_X + 1, leftStep.getBlocks()[0].getX());
        assertEquals(START_Y, leftStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[1].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[1].getY());
        assertEquals(START_X, leftStep.getBlocks()[2].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[2].getY());
        assertEquals(START_X, leftStep.getBlocks()[3].getX());
        assertEquals(START_Y + 2, leftStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateTwice_returnsShapeToInitialPosition() {
        leftStep.rotate();
        leftStep.rotate();
        assertInitialPosition();
    }

    private void assertInitialPosition() {
        assertEquals(START_X, leftStep.getBlocks()[0].getX());
        assertEquals(START_Y, leftStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[1].getX());
        assertEquals(START_Y, leftStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, leftStep.getBlocks()[2].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[2].getY());
        assertEquals(START_X + 2, leftStep.getBlocks()[3].getX());
        assertEquals(START_Y + 1, leftStep.getBlocks()[3].getY());
    }
}
