package com.gregspitz.tetris;

import javax.swing.*;
import java.awt.*;

public class Game {

    // TODO: separate some of this into other classes based on comments
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1200;

    private GameTimer timer;
    private GameModel model;
    private GameView view;

    Game(GameModel model, GameView view, GameTimer timer) {
        this.model = model;
        this.view = view;
        this.timer = timer;
    }

    void start() {
        timer.start();
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
        GameModel model = new GameModel();
        GameView view = new GameView(model);
        GameKeyListener keyListener = new GameKeyListener(model, view);
        view.addKeyListener(keyListener);
        GameTimer timer = new GameTimer(model, view);
        Game game = new Game(model, view, timer);
        gameFrame.add(view, BorderLayout.CENTER);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        game.start();
    }
}
