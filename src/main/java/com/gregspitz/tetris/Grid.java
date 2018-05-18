package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.Block;
import com.gregspitz.tetris.shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {

    public static final int DEFAULT_WIDTH = 10;
    public static final int DEFAULT_HEIGHT = 20;

    private int width;
    private int height;
    private Shape currentShape;
    private List<Block> blockGroup;
    private boolean gameOver;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.currentShape = null;
        blockGroup = new ArrayList<>();
        gameOver = false;
    }

    public boolean addShape(Shape shape) {
        if (gameOver || currentShape != null) {
            return false;
        }

        // Allow blocks to be above the grid, that is, have a negative y coord
        for (Block block : shape.getBlocks()) {
            if (block.getX() < 0 || block.getX() >= width ||
                    block.getY() >= height) {
                return false;
            }
        }

        currentShape = shape;
        if (isHittingBottom()) {
            gameOver = true;
        }
        return true;
    }

    public void moveCurrentShapeDown() {
        if (currentShape == null || gameOver) {
            return;
        }

        currentShape.moveDown();
        boolean hittingBottom = isHittingBottom();
        if (hittingBottom) {
            addShapeToBlockGroup();
        }
    }

    private boolean isHittingBottom() {
        for (Block block : currentShape.getBlocks()) {
            if (block.getY() == height - 1) {
               return true;
            } else {
                for (Block groupBlock : blockGroup) {
                    if (block.getX() == groupBlock.getX() &&
                            block.getY() == groupBlock.getY() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void moveCurrentShapeLeft() {
        if (currentShape == null || gameOver) {
            return;
        }

        boolean atLeftEdge = false;
        for (Block block : currentShape.getBlocks()) {
            if (block.getX() == 0) {
                atLeftEdge = true;
            } else {
                for (Block groupBlock : blockGroup) {
                    if (block.getY() == groupBlock.getY() &&
                            block.getX() == groupBlock.getX() + 1) {
                        atLeftEdge = true;
                    }
                }
            }
        }
        if (!atLeftEdge) {
            currentShape.moveLeft();
        }
    }

    public void moveCurrentShapeRight() {
        if (currentShape == null || gameOver) {
            return;
        }

        boolean atRightEdge = false;
        for (Block block : currentShape.getBlocks()) {
            if (block.getX() == width - 1) {
                atRightEdge = true;
            } else {
                for (Block groupBlock : blockGroup) {
                    if (block.getY() == groupBlock.getY() &&
                            block.getX() == groupBlock.getX() - 1) {
                        atRightEdge = true;
                    }
                }
            }
        }
        if (!atRightEdge) {
            currentShape.moveRight();
        }
    }

    public void rotateCurrentShape() {
        if (!gameOver && currentShape != null) {
            currentShape.rotate();
        }
    }

    private void addShapeToBlockGroup() {
        blockGroup.addAll(Arrays.asList(currentShape.getBlocks()));
        currentShape = null;
        checkForAndRemoveFilledRows();
    }

    private void checkForAndRemoveFilledRows() {
        // TODO: optimize this by turning blockGroup into a 2D array
        int[] blocksInRow = new int[height];
        for (int i = 0; i < height; i++) {
            blocksInRow[i] = 0;
        }
        for (Block block : blockGroup) {
            blocksInRow[block.getY()]++;
        }
        List<Integer> rowsToRemove = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            if (blocksInRow[i] == width) {
                rowsToRemove.add(i);
            }
        }
        blockGroup.removeIf(currentBlock -> rowsToRemove.contains(currentBlock.getY()));
        for (Block block : blockGroup) {
            for (int row : rowsToRemove) {
                if (block.getY() < row) {
                    block.setY(block.getY() + 1);
                }
            }
        }
    }

    private char getBlockChar(Block block) {
        if (block.getColor().equals(Color.RED)) {
            return 'R';
        } else if (block.getColor().equals(Color.BLUE)) {
            return 'B';
        } else if (block.getColor().equals(Color.YELLOW)) {
            return 'Y';
        } else if (block.getColor().equals(Color.GREEN)) {
            return 'G';
        } else if (block.getColor().equals(Color.MAGENTA)) {
            return 'M';
        } else if (block.getColor().equals(Color.CYAN)) {
            return 'C';
        } else if (block.getColor().equals(Color.ORANGE)) {
            return 'O';
        }
        return '?';
    }

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public String toString() {
        char[][] grid = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = '_';
            }
        }
        if (currentShape != null) {
            // Display blocks from currentShape
            for (Block block : currentShape.getBlocks()) {
                char colorChar = getBlockChar(block);
                // Y coord can be below 0, avoid trying to print those block
                if (block.getY() >= 0) {
                    grid[block.getX()][block.getY()] = colorChar;
                }
            }
        }
        // Display blocks in the blockGroup
        for (Block block : blockGroup) {
            char colorChar = getBlockChar(block);
            grid[block.getX()][block.getY()] = colorChar;
        }
        StringBuilder gridString = new StringBuilder();
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                gridString.append(grid[i][j]);
            }
            gridString.append("\n");
        }
        return gridString.toString();
    }
}
