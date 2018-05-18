package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.*;

import java.util.Random;

public class GameModel {

    static final int NUM_SHAPES = 7;
    static final int SHAPE_START_X = 4;
    static final int SHAPE_START_Y = -1;

    private Grid grid;
    private Shape nextShape;
    private Random random;

    GameModel() {
        this(new Grid(Grid.DEFAULT_WIDTH, Grid.DEFAULT_HEIGHT), new Random());
    }

    GameModel(Grid grid, Random random) {
        this.grid = grid;
        this.random = random;
        nextShape = getRandomShape(SHAPE_START_X, SHAPE_START_Y);
    }

    Shape getRandomShape(int startX, int startY) {
        // TODO: make adjustments to the starting position for each block
        switch(random.nextInt(NUM_SHAPES)) {
            case 0:
                return new Square(startX, startY);
            case 1:
                return new Straight(startX, startY);
            case 2:
                return new CenterStep(startX, startY);
            case 3:
                return new LeftStep(startX, startY);
            case 4:
                return new RightStep(startX, startY);
            case 5:
                return new LeftL(startX, startY);
            case 6:
                return new RightL(startX, startY);
            default:
                return new Square(startX, startY);
        }
    }

    boolean update() {
        tryToAddShape();
        moveShapeDown();
        return isGameOver();
    }

    void tryToAddShape() {
        if (grid.addShape(nextShape)) {
            nextShape = getRandomShape(SHAPE_START_X, SHAPE_START_Y);
        }
    }

    void moveShapeDown() {
        grid.moveCurrentShapeDown();
    }

    void rotateShape() {
        grid.rotateCurrentShape();
    }

    void moveShapeLeft() {
        grid.moveCurrentShapeLeft();
    }

    void moveShapeRight() {
        grid.moveCurrentShapeRight();
    }

    boolean isGameOver() {
        return grid.isGameOver();
    }

    Shape getNextShape() {
        return nextShape;
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
