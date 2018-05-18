package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.Block;
import com.gregspitz.tetris.shape.Shape;
import com.gregspitz.tetris.shape.Square;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static com.gregspitz.tetris.GameModel.SHAPE_START_X;
import static com.gregspitz.tetris.GameModel.SHAPE_START_Y;
import static com.gregspitz.tetris.GameView.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link GameView}
 */
public class GameViewTest {

    @Mock
    private GameModel model;

    private Shape nextShape = new Square(0, 0);

    @Mock
    private Graphics2D graphics;

    private GameView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(model.getNextShape()).thenReturn(nextShape);
        when(model.toString()).thenReturn(GridTestData.GRID_WITH_CENTER_STEP_AT_0_0);
        view = new GameView(model);
    }

    @Test
    public void paintComponent_setsRenderingHintsOnGraphics() {
        view.paintComponent(graphics);
        verify(graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Test
    public void paintComponent_paintsBlackBackground() {
        view.paintComponent(graphics);
        verify(graphics).setColor(Color.BLACK);
        verify(graphics).fillRect(0, 0, view.getWidth(), view.getHeight());
    }

    @Test
    public void paintComponent_paintsCenterStepAt00() {
        view.paintComponent(graphics);
        verify(graphics, times(3)).setColor(Color.YELLOW);
        int x = START_X;
        for (int i = 0; i < 3; i++) {
            verify(graphics).fillRect(x, START_Y, BLOCK_SIZE, BLOCK_SIZE);
            x += BLOCK_SIZE + SPACE_BETWEEN_BLOCKS;
        }
    }

    @Test
    public void paintComponent_paintsGraySquares() {
        view.paintComponent(graphics);
        verify(graphics, times(197)).setColor(Color.GRAY);
        int x = START_X;
        int y = START_Y;
        for (int i = 0; i < 3; i++) {
            x += BLOCK_SIZE + SPACE_BETWEEN_BLOCKS;
        }
        for (int i = 0; i < 7; i++) {
            verify(graphics).fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
        }

        for (int i = 1; i < 20; i++) {
            x = START_X;
            y += BLOCK_SIZE + SPACE_BETWEEN_BLOCKS;
            for (int j = 0; j < 10; j++) {
                verify(graphics).fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
            }
        }
    }

    @Test
    public void paintComponent_paintsNextShapeView() {
        view.paintComponent(graphics);
        verify(graphics).setColor(Color.WHITE);
        verify(graphics).drawRect(NEXT_SHAPE_VIEW_X, NEXT_SHAPE_VIEW_Y, NEXT_SHAPE_VIEW_WIDTH, NEXT_SHAPE_VIEW_HEIGHT);
        verify(graphics).setFont(NEXT_SHAPE_FONT);
        verify(graphics)
                .drawString(NEXT_SHAPE_TEXT, NEXT_SHAPE_VIEW_X, NEXT_SHAPE_VIEW_Y + NEXT_SHAPE_TEXT_Y_OFFSET);
        // nextShape color
        verify(graphics).setColor(Color.RED);
        for (Block block : nextShape.getBlocks()) {
            int blockX = (block.getX() - SHAPE_START_X) * BLOCK_SIZE;
            int blockY = (block.getY() - SHAPE_START_Y) * BLOCK_SIZE;
            verify(graphics).fillRect(NEXT_SHAPE_VIEW_X + NEXT_SHAPE_SHAPE_X_OFFSET + blockX,
                    NEXT_SHAPE_VIEW_Y + NEXT_SHAPE_SHAPE_Y_OFFSET + blockY, BLOCK_SIZE, BLOCK_SIZE);
        }
    }

    @Test
    public void paintComponentGameIsOver_paintsGameOverText() {
        view.gameIsOver();
        view.paintComponent(graphics);
        // Once for the background and once for the GameOver text
        verify(graphics, times(2)).setColor(Color.BLACK);
        verify(graphics).setFont(GAME_OVER_FONT);
        verify(graphics).drawString(GAME_OVER_TEXT, GAME_OVER_TEXT_X, GAME_OVER_TEXT_Y);
    }

    @Test
    public void getColorFromChar_returnsCorrectColor() {
        char[] colorChars = { 'R', 'Y', 'G', 'M', 'B', 'C', 'O', '_', '?'};
        List<Color> colors = Arrays.asList(Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE,
                Color.CYAN, Color.ORANGE, Color.GRAY, Color.BLACK);
        for (int i = 0; i < colorChars.length; i++) {
            assertEquals(colors.get(i), GameView.getColorFromChar(colorChars[i]));
        }
    }
}
