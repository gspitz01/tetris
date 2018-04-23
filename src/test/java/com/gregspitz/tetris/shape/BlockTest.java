package com.gregspitz.tetris.shape;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for {@link Block}
 */
public class BlockTest {

    @Test
    public void equalsBlocks_areEqual() {
        Block block1 = new Block(0, 0, Color.RED);
        Block block2 = new Block(0, 0, Color.RED);
        assertEquals(block1, block2);
    }

    @Test
    public void sameInstance_areEqual() {
        Block block1 = new Block(0, 0, Color.RED);
        Block block2 = block1;
        assertEquals(block1, block2);
    }

    @Test
    public void blocksDifferByX_notEqual() {
        Block block1 = new Block(0, 0, Color.MAGENTA);
        Block block2 = new Block(1, 0, Color.MAGENTA);
        assertNotEquals(block1, block2);
    }

    @Test
    public void blocksDifferByY_notEqual() {
        Block block1 = new Block(0, 0, Color.MAGENTA);
        Block block2 = new Block(0, 1, Color.MAGENTA);
        assertNotEquals(block1, block2);
    }

    @Test
    public void blocksDifferByColor_notEqual() {
        Block block1 = new Block(0, 0, Color.MAGENTA);
        Block block2 = new Block(0, 0, Color.YELLOW);
        assertNotEquals(block1, block2);
    }

    @Test
    public void nullBlock_notEqual() {
        Block block1 = new Block(0, 0, Color.RED);
        Block block2 = null;
        assertNotEquals(block1, block2);
    }

    @Test
    public void notABlock_notEqual() {
        Block block1 = new Block(0, 0, Color.MAGENTA);
        String notABlock = "Not a block.";
        assertNotEquals(block1, notABlock);
    }

    @Test
    public void equalBlocks_haveSameHashcode() {
        Block block1 = new Block(0, 0, Color.YELLOW);
        Block block2 = new Block(0, 0, Color.YELLOW);
        assertEquals(block1.hashCode(), block2.hashCode());
    }

    @Test
    public void unequalBlocks_haveDifferentHashcode() {
        Block block1 = new Block(0, 0, Color.YELLOW);
        Block block2 = new Block(-1, 1, Color.YELLOW);
        assertNotEquals(block1.hashCode(), block2.hashCode());
    }
}
