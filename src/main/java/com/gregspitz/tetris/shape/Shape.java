package com.gregspitz.tetris.shape;

import com.gregspitz.tetris.Grid;

public abstract class Shape {

    static final int NUM_BLOCKS = 4;
    private char color;
    Block[] blocks;

    /**
     * All shape subclasses must call setBlocks in their constructors
     * @param color the shape's color - cannot be null
     */
    public Shape(char color) {
        this.color = color;
    }

    public char getColor() {
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

    void setBlocks(int[] xs, int[] ys) {
        blocks = new Block[NUM_BLOCKS];
        for (int i = 0; i < NUM_BLOCKS; i++) {
            blocks[i] = new Block(xs[i], ys[i], color);
        }
    }

    void stayInBounds() {
        boolean moveRight = false;
        boolean moveLeft = false;
        for (Block block : getBlocks()) {
            if (block.getX() < 0) {
                moveRight = true;
            } else if (block.getX() >= Grid.DEFAULT_WIDTH) {
                moveLeft = true;
            }
        }
        for (Block block : getBlocks()) {
            if (moveRight) {
                block.setX(block.getX() + 1);
            } else if (moveLeft) {
                block.setX(block.getX() - 1);
            }
        }
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public abstract void rotate();
}