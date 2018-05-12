package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;

public class Game extends JComponent implements ActionListener, KeyListener {

    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1200;
    private static final int GRID_WIDTH = 800;
    private static final int GRID_HEIGHT = 900;
    private static final int BLOCK_SIZE = 50;
    private static final int START_X = 20;
    private static final int START_Y = 20;
    private static final int SPACE_BETWEEN_BLOCKS = 1;
    private static final int FONT_SIZE = 60;

    private Grid grid;
    private Timer timer;

    private Game() {
        grid = new Grid(Grid.DEFAULT_WIDTH, Grid.DEFAULT_HEIGHT);
        timer = new Timer(100, this);
        setSize(GRID_WIDTH, GRID_HEIGHT);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
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
        if (grid.isGameOver()) {
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("TimesRoman", Font.BOLD, FONT_SIZE));
            g2.drawString("GAME OVER", BLOCK_SIZE * 2, BLOCK_SIZE * 10);
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
        gameFrame.pack();
        gameFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: add creation of random next shape based on return value of addShape()
        // TODO: show animation for removal of row
        grid.addShape(new Square(4, -1));
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
                // TODO: fill in rotate
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
