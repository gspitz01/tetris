package com.gregspitz.tetris;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link Game}
 */
public class GameTest {

    @Mock
    private GameView view;

    @Mock
    private GameTimer timer;

    @Mock
    private JFrame frame;

    @Mock
    private Container contentPane;

    @Mock
    private Dimension preferredSize;

    @Mock
    private LayoutManager layout;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(frame.getContentPane()).thenReturn(contentPane);
    }

    @Test
    public void createGuiAndRun_setsUpGameFrame() {
        Game.createGuiAndRun(frame, preferredSize, layout, view, timer);
        verify(frame).setPreferredSize(preferredSize);
        verify(frame).getContentPane();
        verify(contentPane).setLayout(layout);
        verify(frame).add(view, BorderLayout.CENTER);
        verify(frame).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        verify(frame).pack();
        verify(frame).setVisible(true);
        verify(timer).start();
    }
}
