package com.gregspitz.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer implements ActionListener {

    private static final int TIMER_INTERVAL = 200;

    private GameModel gameModel;
    private Game gameView;
    private Timer timer;

    GameTimer(GameModel gameModel, Game gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
        timer = new Timer(TIMER_INTERVAL, this);
    }

    GameTimer(GameModel gameModel, Game gameView, Timer timer) {
        this.gameModel = gameModel;
        this.gameView = gameView;
        this.timer = timer;
    }

    void start() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: show animation for removal of row
        // Returns true if game is over
        if (gameModel.update()) {
            // Timing
            timer.stop();
            gameView.gameIsOver();
        }

        // View
        gameView.repaint();
    }
}
