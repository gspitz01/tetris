package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.Block;

import javax.swing.*;
import java.awt.*;

import static com.gregspitz.tetris.GameModel.SHAPE_START_X;
import static com.gregspitz.tetris.GameModel.SHAPE_START_Y;

public class GameView extends JComponent {

    private static final int GRID_WIDTH = 800;
    private static final int GRID_HEIGHT = 900;
    static final int BLOCK_SIZE = 50;
    static final int START_X = 20;
    static final int START_Y = 20;
    static final int SPACE_BETWEEN_BLOCKS = 1;
    static final int NEXT_SHAPE_VIEW_X = 50 + START_X + BLOCK_SIZE * 10;
    static final int NEXT_SHAPE_VIEW_Y = START_Y + 100;
    static final int NEXT_SHAPE_VIEW_WIDTH = 200;
    static final int NEXT_SHAPE_VIEW_HEIGHT = 400;
    static final int NEXT_SHAPE_TEXT_Y_OFFSET = -5;
    static final int NEXT_SHAPE_SHAPE_X_OFFSET = 50;
    static final int NEXT_SHAPE_SHAPE_Y_OFFSET = 50;
    static final int GAME_OVER_TEXT_X = BLOCK_SIZE * 2;
    static final int GAME_OVER_TEXT_Y = BLOCK_SIZE * 10;
    static final Font GAME_OVER_FONT = new Font("TimesRoman", Font.BOLD, 60);
    static final Font NEXT_SHAPE_FONT = new Font("Helvetica", Font.PLAIN, 40);
    static final String GAME_OVER_TEXT = "GAME OVER";
    static final String NEXT_SHAPE_TEXT = "Next Shape";

    private GameModel model;
    private boolean gameOver;

    GameView(GameModel model) {
        this.model = model;

        gameOver = false;

        setSize(GRID_WIDTH, GRID_HEIGHT);
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        int x = START_X;
        int y = START_Y;
        boolean drawBlock = false;
        Color color = Color.BLACK;
        for (char gridChar : model.toString().toCharArray()) {
            switch (gridChar) {
                case 'R':
                case 'Y':
                case 'G':
                case 'M':
                case 'B':
                case 'C':
                case 'O':
                case '_':
                    color = getColorFromChar(gridChar);
                    drawBlock = true;
                    break;
                case '\n':
                    y += BLOCK_SIZE + SPACE_BETWEEN_BLOCKS;
                    x = START_X;
                    break;
            }
            if (drawBlock) {
                g2.setColor(color);
                g2.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                x += BLOCK_SIZE + SPACE_BETWEEN_BLOCKS;
                drawBlock = false;
            }
        }

        // Draw next block view
        g2.setColor(Color.WHITE);
        g2.drawRect(NEXT_SHAPE_VIEW_X, NEXT_SHAPE_VIEW_Y, NEXT_SHAPE_VIEW_WIDTH, NEXT_SHAPE_VIEW_HEIGHT);
        g2.setFont(NEXT_SHAPE_FONT);
        g2.drawString(NEXT_SHAPE_TEXT, NEXT_SHAPE_VIEW_X, NEXT_SHAPE_VIEW_Y + NEXT_SHAPE_TEXT_Y_OFFSET);
        g2.setColor(getColorFromChar(model.getNextShape().getColor()));
        for (Block block : model.getNextShape().getBlocks()) {
            int blockX = (block.getX() - SHAPE_START_X) * BLOCK_SIZE;
            int blockY = (block.getY() - SHAPE_START_Y) * BLOCK_SIZE;
            g2.fillRect(NEXT_SHAPE_VIEW_X + NEXT_SHAPE_SHAPE_X_OFFSET + blockX,
                    NEXT_SHAPE_VIEW_Y + NEXT_SHAPE_SHAPE_Y_OFFSET + blockY, BLOCK_SIZE, BLOCK_SIZE);
        }

        if (gameOver) {
            g2.setColor(Color.BLACK);
            g2.setFont(GAME_OVER_FONT);
            g2.drawString(GAME_OVER_TEXT, GAME_OVER_TEXT_X, GAME_OVER_TEXT_Y);
        }
    }

    static Color getColorFromChar(char colorChar) {
        switch (colorChar) {
            case 'R':
                return Color.RED;
            case 'Y':
                return Color.YELLOW;
            case 'G':
                return Color.GREEN;
            case 'M':
                return Color.MAGENTA;
            case 'B':
                return Color.BLUE;
            case 'C':
                return Color.CYAN;
            case 'O':
                return Color.ORANGE;
            case '_':
                return Color.GRAY;
            default:
                return Color.BLACK;
        }
    }

    void gameIsOver() {
        gameOver = true;
    }
}
