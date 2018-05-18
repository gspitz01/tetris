package com.gregspitz.tetris.shape;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link RightL}
 */
public class RightLTest {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private RightL rightL;

    @Before
    public void setup() {
        rightL = new RightL(START_X, START_Y);
    }

    @Test
    public void constructor_setsColorLightGray() {
        assertEquals('C', rightL.getColor());
    }

    @Test
    public void constructor_setsBlocksInRightLShape() {
        assertInitialPosition();
    }

    @Test
    public void moveRight_movesBlocksOneRight() {
        rightL.moveRight();
        assertEquals(START_X + 1, rightL.getBlocks()[0].getX());
        assertEquals(START_Y, rightL.getBlocks()[0].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[1].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[1].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[2].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[2].getY());
        assertEquals(START_X + 2, rightL.getBlocks()[3].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[3].getY());
    }

    @Test
    public void moveLeft_movesBlocksOneLeft() {
        rightL.moveLeft();
        assertEquals(START_X - 1, rightL.getBlocks()[0].getX());
        assertEquals(START_Y, rightL.getBlocks()[0].getY());
        assertEquals(START_X - 1, rightL.getBlocks()[1].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[1].getY());
        assertEquals(START_X - 1, rightL.getBlocks()[2].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[2].getY());
        assertEquals(START_X , rightL.getBlocks()[3].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[3].getY());
    }

    @Test
    public void moveDown_movesBlocksOnePositionPositiveY() {
        rightL.moveDown();
        assertEquals(START_X, rightL.getBlocks()[0].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[0].getY());
        assertEquals(START_X, rightL.getBlocks()[1].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[1].getY());
        assertEquals(START_X, rightL.getBlocks()[2].getX());
        assertEquals(START_Y + 3, rightL.getBlocks()[2].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[3].getX());
        assertEquals(START_Y + 3, rightL.getBlocks()[3].getY());
    }

    @Test
    public void rotateOnce_turnsShapeLDown() {
        rightL.rotate();
        assertEquals(START_X, rightL.getBlocks()[0].getX());
        assertEquals(START_Y, rightL.getBlocks()[0].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[1].getX());
        assertEquals(START_Y, rightL.getBlocks()[1].getY());
        assertEquals(START_X + 2, rightL.getBlocks()[2].getX());
        assertEquals(START_Y, rightL.getBlocks()[2].getY());
        assertEquals(START_X, rightL.getBlocks()[3].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[3].getY());
    }

    @Test
    public void rotateTwice_turnsShapeLLeft() {
        rightL.rotate();
        rightL.rotate();
        assertEquals(START_X, rightL.getBlocks()[0].getX());
        assertEquals(START_Y, rightL.getBlocks()[0].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[1].getX());
        assertEquals(START_Y, rightL.getBlocks()[1].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[2].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[2].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[3].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[3].getY());
    }

    @Test
    public void rotateThrice_turnsShapeLUp() {
        rightL.rotate();
        rightL.rotate();
        rightL.rotate();
        assertEquals(START_X, rightL.getBlocks()[0].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[0].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[1].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[1].getY());
        assertEquals(START_X + 2, rightL.getBlocks()[2].getX());
        assertEquals(START_Y, rightL.getBlocks()[2].getY());
        assertEquals(START_X + 2, rightL.getBlocks()[3].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[3].getY());
    }

    @Test
    public void rotateFourTimes_returnsShapeToInitialPosition() {
        rightL.rotate();
        rightL.rotate();
        rightL.rotate();
        rightL.rotate();
        assertInitialPosition();
    }

    private void assertInitialPosition() {
        assertEquals(START_X, rightL.getBlocks()[0].getX());
        assertEquals(START_Y, rightL.getBlocks()[0].getY());
        assertEquals(START_X, rightL.getBlocks()[1].getX());
        assertEquals(START_Y + 1, rightL.getBlocks()[1].getY());
        assertEquals(START_X, rightL.getBlocks()[2].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[2].getY());
        assertEquals(START_X + 1, rightL.getBlocks()[3].getX());
        assertEquals(START_Y + 2, rightL.getBlocks()[3].getY());
    }
}
