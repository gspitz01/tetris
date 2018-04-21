package com.gregspitz.tetris.shape;

import java.awt.*;

public abstract class Shape {

    public static final int NUM_BLOCKS = 4;
    private Color color;
    protected Block[] blocks;

    /**
     * All shape subclasses must call setBlocks in their constructors
     * @param color the shape's color - cannot be null
     */
    public Shape(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }

        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void moveRight() {
        for (Block block : blocks) {
            block.setX(block.getX() + 1);
        }
    }

    public void moveLeft() {
        for (Block block : blocks) {
            block.setX(block.getX() - 1);
        }
    }

    public void moveDown() {
        for (Block block : blocks) {
            block.setY(block.getY() + 1);
        }
    }

    public void setBlocks(int[] xs, int[] ys) {
        blocks = new Block[NUM_BLOCKS];
        for (int i = 0; i < NUM_BLOCKS; i++) {
            blocks[i] = new Block(xs[i], ys[i]);
        }
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public abstract void rotate();
}