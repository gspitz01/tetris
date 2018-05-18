package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.gregspitz.tetris.GameModel.SHAPE_START_X;
import static com.gregspitz.tetris.GameModel.SHAPE_START_Y;

public class Game extends JComponent implements ActionListener {

    // TODO: separate some of this into other classes based on comments

    private static final int TIMER_INTERVAL = 200;
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1200;
    private static final int GRID_WIDTH = 800;
    private static final int GRID_HEIGHT = 900;
    private static final int BLOCK_SIZE = 50;
    private static final int START_X = 20;
    private static final int START_Y = 20;
    private static final int SPACE_BETWEEN_BLOCKS = 1;
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

    private Timer timer;
    private GameModel gameModel;
    private boolean gameOver;

    private Game() {
        gameModel = new GameModel();
        gameOver = false;
        // Timing
        timer = new Timer(TIMER_INTERVAL, this);

        // View
        setSize(GRID_WIDTH, GRID_HEIGHT);
        setFocusable(true);
        requestFocus();

        // View and events
        addKeyListener(new GameKeyListener(gameModel, this));

        // Timing
        timer.start();
    }

    // View
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
        for (char gridChar : gameModel.toString().toCharArray()) {
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
        g2.drawString(NEXT_SHAPE_TEXT, NEXT_SHAPE_VIEW_X, NEXT_SHAPE_VIEW_Y - 5);
        g2.setColor(getColorFromChar(gameModel.getNextShape().getColor()));
        for (Block block : gameModel.getNextShape().getBlocks()) {
            int blockX = (block.getX() - SHAPE_START_X) * BLOCK_SIZE;
            int blockY = (block.getY() - SHAPE_START_Y) * BLOCK_SIZE;
            g2.fillRect(NEXT_SHAPE_VIEW_X + NEXT_SHAPE_SHAPE_X_OFFSET + blockX,
                    NEXT_SHAPE_VIEW_Y + NEXT_SHAPE_SHAPE_Y_OFFSET + blockY, BLOCK_SIZE, BLOCK_SIZE);
        }

        if (gameOver) {
            g2.setColor(Color.BLACK);
            g2.setFont(GAME_OVER_FONT);
            g2.drawString(GAME_OVER_TEXT, BLOCK_SIZE * 2, BLOCK_SIZE * 10);
        }
    }

    // View or util
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::createGuiAndRun);
    }

    // View
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

    // Timing
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: show animation for removal of row
        // Returns true if game is over
        if (gameModel.update()) {
            // Timing
            timer.stop();
            gameOver = true;
        }

        // View
        repaint();
    }


}
