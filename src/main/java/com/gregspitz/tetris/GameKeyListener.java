package com.gregspitz.tetris;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;

public class GameKeyListener implements KeyListener {

    private GameModel gameModel;
    private JComponent gameView;

    GameKeyListener(GameModel gameModel, JComponent gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    // Events
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Events
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case VK_UP:
                // Model
                gameModel.rotateShape();
                // View
                gameView.repaint();
                break;
            case VK_LEFT:
                // Model
                gameModel.moveShapeLeft();
                // View
                gameView.repaint();
                break;
            case VK_RIGHT:
                // Model
                gameModel.moveShapeRight();
                // View
                gameView.repaint();
                break;
        }
    }

    // Events
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
