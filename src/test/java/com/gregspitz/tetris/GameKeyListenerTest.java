package com.gregspitz.tetris;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link GameKeyListener}
 */
public class GameKeyListenerTest {

    @Mock
    private GameModel gameModel;

    @Mock
    private JComponent gameView;

    @Mock
    private KeyEvent keyEvent;

    private GameKeyListener gameKeyListener;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        gameKeyListener = new GameKeyListener(gameModel, gameView);
    }

    @Test
    public void keyPressedUp_callsGameModelRotateShapeAndGameViewRepaint() {
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        gameKeyListener.keyPressed(keyEvent);
        verify(gameModel).rotateShape();
        verify(gameView).repaint();
    }

    @Test
    public void keyPressedLeft_callsGameModelMoveLeftAndGameViewRepaint() {
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        gameKeyListener.keyPressed(keyEvent);
        verify(gameModel).moveShapeLeft();
        verify(gameView).repaint();
    }

    @Test
    public void keyPressedRight_callsGameModelMoveRightAndGameViewRepaint() {
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        gameKeyListener.keyPressed(keyEvent);
        verify(gameModel).moveShapeRight();
        verify(gameView).repaint();
    }
}
