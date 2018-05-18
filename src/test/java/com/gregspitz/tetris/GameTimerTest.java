package com.gregspitz.tetris;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import java.awt.event.ActionEvent;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link GameTimer}
 */
public class GameTimerTest {

    @Mock
    private GameModel gameModel;

    @Mock
    private Game gameView;

    @Mock
    private Timer timer;

    @Mock
    private ActionEvent actionEvent;

    private GameTimer gameTimer;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        gameTimer = new GameTimer(gameModel, gameView, timer);
    }

    @Test
    public void start_callsStartOnTimer() {
        gameTimer.start();
        verify(timer).start();
    }

    @Test
    public void actionPerformedGameNotOver_callsGameModelUpdateAndGameViewRepaint() {
        when(gameModel.update()).thenReturn(false);
        gameTimer.actionPerformed(actionEvent);
        verify(gameModel).update();
        verify(gameView).repaint();
    }

    @Test
    public void actionPerformedGameIsOver_callsGameModelUpdateGameViewOverRepaintAndStopsTimer() {
        when(gameModel.update()).thenReturn(true);
        gameTimer.actionPerformed(actionEvent);
        verify(gameModel).update();
        verify(timer).stop();
        verify(gameView).gameIsOver();
        verify(gameView).repaint();
    }
}
