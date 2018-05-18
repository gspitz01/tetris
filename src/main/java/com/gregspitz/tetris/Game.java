package com.gregspitz.tetris;

import javax.swing.*;
import java.awt.*;

public class Game {

    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1200;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameModel model = new GameModel();
            GameView view = new GameView(model);
            GameKeyListener keyListener = new GameKeyListener(model, view);
            view.addKeyListener(keyListener);
            GameTimer timer = new GameTimer(model, view);
            Dimension preferredSize = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
            LayoutManager layout = new BorderLayout();
            createGuiAndRun(new JFrame("Tetris"), preferredSize, layout, view, timer);
        });
    }

    static void createGuiAndRun(JFrame gameFrame, Dimension preferredSize, LayoutManager layout,
                                GameView view, GameTimer timer) {
        gameFrame.setPreferredSize(preferredSize);
        gameFrame.getContentPane().setLayout(layout);
        gameFrame.add(view, BorderLayout.CENTER);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        timer.start();
    }
}
