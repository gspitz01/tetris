package com.gregspitz.tetris.shape;

public class Block {

    private int x;
    private int y;
    private char color;


    public Block(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime * result + x;
        result = prime * result + y;
        return result + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Block)) {
            return false;
        }
        Block otherBlock = (Block) obj;
        return x == otherBlock.x && y == otherBlock.y && color == otherBlock.color;
    }
}
