package com.gregspitz.tetris;

import org.junit.Test;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Tests for {@link Game}
 */
public class GameTest {

    @Test
    public void getColorFromChar_returnsCorrectColor() {
        char[] colorChars = { 'R', 'Y', 'G', 'M', 'B', 'C', 'O', '_', '?'};
        List<Color> colors = Arrays.asList(Color.RED, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE,
                Color.CYAN, Color.ORANGE, Color.GRAY, Color.BLACK);
        for (int i = 0; i < colorChars.length; i++) {
            assertEquals(colors.get(i), Game.getColorFromChar(colorChars[i]));
        }
    }
}
