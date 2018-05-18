package com.gregspitz.tetris;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import java.awt.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link Game}
 */
public class GameTest {


    @Mock
    private GameModel model;

    @Mock
    private GameView view;

    @Mock
    private GameTimer timer;

    @Mock
    private JFrame frame;

    @Mock
    private Container contentPane;

    @Mock
    private Game mockGame;

    private Game game;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(frame.getContentPane()).thenReturn(contentPane);
        game = new Game(model, view, timer);
    }

    @Test
    public void start_callsStartOnTimer() {
        game.start();
        verify(timer).start();
    }

    @Test
    public void createGuiAndRun_setsUpGameFrame() {
        Game.createGuiAndRun(frame, view, mockGame);
        verify(frame).setPreferredSize(any(Dimension.class));
        verify(frame).getContentPane();
        verify(contentPane).setLayout(any(BorderLayout.class));
        verify(frame).add(view, BorderLayout.CENTER);
        verify(frame).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        verify(frame).pack();
        verify(frame).setVisible(true);
        verify(mockGame).start();
    }
}
