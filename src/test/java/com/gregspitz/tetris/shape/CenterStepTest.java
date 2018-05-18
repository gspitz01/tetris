package com.gregspitz.tetris.shape;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for {@link CenterStep}
 */
public class CenterStepTest {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private CenterStep centerStep;

    @Before
    public void setup() {
        centerStep = new CenterStep(START_X, START_Y);
    }

    @Test
    public void constructor_setsColorToYellow() {
        assertEquals('Y', centerStep.getColor());
    }

    @Test
    public void constructor_setsBlocksToCenterStepShape() {
        assertInitialPosition();
    }

    @Test
    public void moveRight_movesAllBlocksRightOne() {
        centerStep.moveRight();
        assertEquals(START_X + 1, centerStep.getBlocks()[0].getX());
        assertEquals(START_Y, centerStep.getBlocks()[0].getY());
        assertEquals(START_X + 2, centerStep.getBlocks()[1].getX());
        assertEquals(START_Y - 1, centerStep.getBlocks()[1].getY());
        assertEquals(START_X + 2, centerStep.getBlocks()[2].getX());
        assertEquals(START_Y, centerStep.getBlocks()[2].getY());
        assertEquals(START_X + 3, centerStep.getBlocks()[3].getX());
        assertEquals(START_Y, centerStep.getBlocks()[3].getY());
    }

    @Test
    public void moveLeft_movesAllBlocksLeftOne() {
        centerStep.moveLeft();
        assertEquals(START_X - 1, centerStep.getBlocks()[0].getX());
        assertEquals(START_Y, centerStep.getBlocks()[0].getY());
        assertEquals(START_X , centerStep.getBlocks()[1].getX());
        assertEquals(START_Y - 1, centerStep.getBlocks()[1].getY());
        assertEquals(START_X, centerStep.getBlocks()[2].getX());
        assertEquals(START_Y, centerStep.getBlocks()[2].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[3].getX());
        assertEquals(START_Y, centerStep.getBlocks()[3].getY());
    }

    @Test
    public void moveDown_movesAllBlocksOnePositiveY() {
        centerStep.moveDown();
        assertEquals(START_X, centerStep.getBlocks()[0].getX());
        assertEquals(START_Y + 1, centerStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[1].getX());
        assertEquals(START_Y, centerStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[2].getX());
        assertEquals(START_Y + 1, centerStep.getBlocks()[2].getY());
        assertEquals(START_X + 2, centerStep.getBlocks()[3].getX());
        assertEquals(START_Y + 1, centerStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateOnce_turnsShapeVerticalWithStepOnRightSide() {
        centerStep.rotate();
        assertEquals(START_X + 1, centerStep.getBlocks()[0].getX());
        assertEquals(START_Y - 1, centerStep.getBlocks()[0].getY());
        assertEquals(START_X + 2, centerStep.getBlocks()[1].getX());
        assertEquals(START_Y, centerStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[2].getX());
        assertEquals(START_Y, centerStep.getBlocks()[2].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[3].getX());
        assertEquals(START_Y + 1, centerStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateTwice_turnsShapeHorizontalWithStepOnBottom() {
        centerStep.rotate();
        centerStep.rotate();
        assertEquals(START_X + 2, centerStep.getBlocks()[0].getX());
        assertEquals(START_Y, centerStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[1].getX());
        assertEquals(START_Y + 1, centerStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[2].getX());
        assertEquals(START_Y, centerStep.getBlocks()[2].getY());
        assertEquals(START_X, centerStep.getBlocks()[3].getX());
        assertEquals(START_Y, centerStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateThrice_turnsShapeVerticalWithStepOnLeft() {
        centerStep.rotate();
        centerStep.rotate();
        centerStep.rotate();
        assertEquals(START_X + 1, centerStep.getBlocks()[0].getX());
        assertEquals(START_Y + 1, centerStep.getBlocks()[0].getY());
        assertEquals(START_X, centerStep.getBlocks()[1].getX());
        assertEquals(START_Y, centerStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[2].getX());
        assertEquals(START_Y, centerStep.getBlocks()[2].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[3].getX());
        assertEquals(START_Y - 1, centerStep.getBlocks()[3].getY());
    }

    @Test
    public void rotateFourTimes_returnsShapeToInitialPosition() {
        centerStep.rotate();
        centerStep.rotate();
        centerStep.rotate();
        centerStep.rotate();
        assertInitialPosition();
    }

    private void assertInitialPosition() {
        assertEquals(START_X, centerStep.getBlocks()[0].getX());
        assertEquals(START_Y, centerStep.getBlocks()[0].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[1].getX());
        assertEquals(START_Y - 1, centerStep.getBlocks()[1].getY());
        assertEquals(START_X + 1, centerStep.getBlocks()[2].getX());
        assertEquals(START_Y, centerStep.getBlocks()[2].getY());
        assertEquals(START_X + 2, centerStep.getBlocks()[3].getX());
        assertEquals(START_Y, centerStep.getBlocks()[3].getY());
    }
}
