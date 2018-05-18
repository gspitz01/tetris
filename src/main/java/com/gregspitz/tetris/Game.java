package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.*;
import com.gregspitz.tetris.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import static java.awt.event.KeyEvent.*;

public class Game extends JComponent implements ActionListener, KeyListener {

    private static final int TIMER_INTERVAL = 200;
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1200;
    private static final int GRID_WIDTH = 800;
    private static final int GRID_HEIGHT = 900;
    private static final int BLOCK_SIZE = 50;
    private static final int START_X = 20;
    private static final int START_Y = 20;
    private static final int SPACE_BETWEEN_BLOCKS = 1;
    private static final int NUM_SHAPES = 7;
    private static final int SHAPE_START_X = 4;
    private static final int SHAPE_START_Y = -1;
    private static final int NEXT_SHAPE_VIEW_X = 50 + START_X + BLOCK_SIZE * 10;
    private static final int NEXT_SHAPE_VIEW_Y = START_Y + 100;
    private static final int NEXT_SHAPE_VIEW_WIDTH = 200;
    private static final int NEXT_SHAPE_VIEW_HEIGHT = 400;
    private static final int NEXT_SHAPE_SHAPE_X_OFFSET = 50;
    private static final int NEXT_SHAPE_SHAPE_Y_OFFSET = 50;
    private static final Font GAME_OVER_FONT = new Font("TimesRoman", Font.BOLD, 60);
    private static final Font NEXT_SHAPE_FONT = new Font("Helvetica", Font.PLAIN, 40);
    private static final String GAME_OVER_TEXT = "GAME OVER";
    private static final String NEXT_SHAPE_TEXT = "Next Shape";

    private Grid grid;
    private Timer timer;
    private Shape nextShape;
    private Random random;

    private Game() {
        grid = new Grid(Grid.DEFAULT_WIDTH, Grid.DEFAULT_HEIGHT);
        timer = new Timer(TIMER_INTERVAL, this);
        setSize(GRID_WIDTH, GRID_HEIGHT);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        random = new Random();
        nextShape = getRandomShape();
        timer.start();
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
        for (char gridChar : grid.toString().toCharArray()) {
            switch (gridChar) {
                case 'R':
                    color = Color.RED;
                    drawBlock = true;
                    break;
                case 'Y':
                    color = Color.YELLOW;
                    drawBlock = true;
                    break;
                case 'G':
                    color = Color.GREEN;
                    drawBlock = true;
                    break;
                case 'M':
                    color = Color.MAGENTA;
                    drawBlock = true;
                    break;
                case 'B':
                    color = Color.BLUE;
                    drawBlock = true;
                    break;
                case 'C':
                    color = Color.CYAN;
                    drawBlock = true;
                    break;
                case 'O':
                    color = Color.ORANGE;
                    drawBlock = true;
                    break;
                case '_':
                    color = Color.GRAY;
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
        g2.drawString(NEXT_SHAPE_TEXT, NEXT_SHAPE_VIEW_X, NEXT_SHAPE_VIEW_Y - 5);
        g2.setColor(nextShape.getColor());
        for (Block block : nextShape.getBlocks()) {
            int blockX = (block.getX() - SHAPE_START_X) * BLOCK_SIZE;
            int blockY = (block.getY() - SHAPE_START_Y) * BLOCK_SIZE;
            g2.fillRect(NEXT_SHAPE_VIEW_X + NEXT_SHAPE_SHAPE_X_OFFSET + blockX,
                    NEXT_SHAPE_VIEW_Y + NEXT_SHAPE_SHAPE_Y_OFFSET + blockY, BLOCK_SIZE, BLOCK_SIZE);
        }

        if (grid.isGameOver()) {
            g2.setColor(Color.BLACK);
            g2.setFont(GAME_OVER_FONT);
            g2.drawString(GAME_OVER_TEXT, BLOCK_SIZE * 2, BLOCK_SIZE * 10);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::createGuiAndRun);
    }

    private static void createGuiAndRun() {
        JFrame gameFrame = new JFrame("Tetris");
        Dimension preferredSize = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setPreferredSize(preferredSize);
        gameFrame.getContentPane().setLayout(new BorderLayout());
        gameFrame.add(new Game(), BorderLayout.CENTER);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
    }

    private Shape getRandomShape() {
        // TODO: make adjustments to the starting position for each block
        switch(random.nextInt(NUM_SHAPES)) {
            case 0:
                return new Square(SHAPE_START_X, SHAPE_START_Y);
            case 1:
                return new Straight(SHAPE_START_X, SHAPE_START_Y);
            case 2:
                return new CenterStep(SHAPE_START_X, SHAPE_START_Y);
            case 3:
                return new LeftStep(SHAPE_START_X, SHAPE_START_Y);
            case 4:
                return new RightStep(SHAPE_START_X, SHAPE_START_Y);
            case 5:
                return new LeftL(SHAPE_START_X, SHAPE_START_Y);
            case 6:
                return new RightL(SHAPE_START_X, SHAPE_START_Y);
            default:
                return new Square(SHAPE_START_X, SHAPE_START_Y);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: show animation for removal of row
        if (grid.addShape(nextShape)) {
            nextShape = getRandomShape();
        }
        grid.moveCurrentShapeDown();
        if (grid.isGameOver()) {
            timer.stop();
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case VK_UP:
                grid.rotateCurrentShape();
                repaint();
                break;
            case VK_LEFT:
                grid.moveCurrentShapeLeft();
                repaint();
                break;
            case VK_RIGHT:
                grid.moveCurrentShapeRight();
                repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
