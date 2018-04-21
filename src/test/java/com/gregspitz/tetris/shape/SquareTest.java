package com.gregspitz.tetris.shape;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for {@link Square}
 */
public class SquareTest {

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private Square square;

    @Before
    public void setup() {
        square = new Square(START_X, START_Y);
    }

    @Test
    public void constructor_setsColorToRed() {
        assertEquals(Color.RED, square.getColor());
    }

    @Test
    public void constructor_setsBlocksInSquareShape() {
        assertInitialPosition();
    }

    @Test
    public void moveRight_movesAllBlocksToRightOne() {
        square.moveRight();
        assertEquals(START_X + 1, square.getBlocks()[0].getX());
        assertEquals(START_X + 2, square.getBlocks()[1].getX());
        assertEquals(START_X + 1, square.getBlocks()[2].getX());
        assertEquals(START_X + 2, square.getBlocks()[3].getX());
    }

    @Test
    public void moveLeft_movesAllBlocksToLeftOne() {
        square.moveLeft();
        assertEquals(START_X - 1, square.getBlocks()[0].getX());
        assertEquals(START_X, square.getBlocks()[1].getX());
        assertEquals(START_X - 1, square.getBlocks()[2].getX());
        assertEquals(START_X , square.getBlocks()[3].getX());
    }

    @Test
    public void moveDown_movesAllBlocksOnePositiveY() {
        square.moveDown();
        assertEquals(START_Y + 1, square.getBlocks()[0].getY());
        assertEquals(START_Y + 1, square.getBlocks()[1].getY());
        assertEquals(START_Y + 2, square.getBlocks()[2].getY());
        assertEquals(START_Y + 2, square.getBlocks()[3].getY());
    }

    @Test
    public void rotate_doesNothing() {
        square.rotate();
        assertInitialPosition();
    }

    private void assertInitialPosition() {
        assertEquals(START_X, square.getBlocks()[0].getX());
        assertEquals(START_Y, square.getBlocks()[0].getY());
        assertEquals(START_X + 1, square.getBlocks()[1].getX());
        assertEquals(START_Y, square.getBlocks()[1].getY());
        assertEquals(START_X, square.getBlocks()[2].getX());
        assertEquals(START_Y + 1, square.getBlocks()[2].getY());
        assertEquals(START_X + 1, square.getBlocks()[3].getX());
        assertEquals(START_Y + 1, square.getBlocks()[3].getY());
    }
}
