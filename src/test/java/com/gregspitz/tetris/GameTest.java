package com.gregspitz.tetris;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

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

    private Game game;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        game = new Game(model, view, timer);
    }

    @Test
    public void start_callsStartOnTimer() {
        game.start();
        verify(timer).start();
    }
}
