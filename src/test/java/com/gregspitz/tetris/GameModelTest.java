package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link GameModel}
 */
public class GameModelTest {

    @Mock
    private Grid grid;

    @Mock
    private Random random;

    private GameModel gameModel;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        // Random shape 4 is RightStep
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(4);
        gameModel = new GameModel(grid, random);
    }

    @Test
    public void constructor_setsNextShapeToRandomShape() {
        assertTrue(gameModel.getNextShape() instanceof RightStep);
    }

    @Test
    public void getRandomShape_returnsCorrectShape() {
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(0);
        Shape returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof Square);

        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(1);
        returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof Straight);

        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(2);
        returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof CenterStep);

        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(3);
        returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof LeftStep);

        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(4);
        returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof RightStep);

        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(5);
        returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof LeftL);

        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(6);
        returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof RightL);

        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(7);
        returnedShape = gameModel.getRandomShape(0, 0);
        assertTrue(returnedShape instanceof Square);
    }

    @Test
    public void moveShapeDown_callsMoveCurrentShapeDownOnGrid() {
        gameModel.moveShapeDown();
        verify(grid).moveCurrentShapeDown();
    }

    @Test
    public void moveShapeLeft_callsMoveCurrentShapeLeftOnGrid() {
        gameModel.moveShapeLeft();
        verify(grid).moveCurrentShapeLeft();
    }

    @Test
    public void moveShapeRight_callsMoveCurrentShapeRightOnGrid() {
        gameModel.moveShapeRight();
        verify(grid).moveCurrentShapeRight();
    }

    @Test
    public void rotateShape_callsRotateCurrentShapeOnGrid() {
        gameModel.rotateShape();
        verify(grid).rotateCurrentShape();
    }

    @Test
    public void isGameOver_returnsGridIsGameOver() {
        when(grid.isGameOver()).thenReturn(false);
        assertFalse(gameModel.isGameOver());
        when(grid.isGameOver()).thenReturn(true);
        assertTrue(gameModel.isGameOver());
    }

    @Test
    public void toString_returnsGridToString() {
        String gridToString = "grid to string";
        when(grid.toString()).thenReturn(gridToString);
        assertEquals(gridToString, gameModel.toString());
    }

    @Test
    public void tryToAddShapeSuccess_addsShapeToGridAndChangesNextShape() {
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        when(grid.addShape(any(RightStep.class))).thenReturn(true);
        // Random shape 1 is Straight
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(1);

        gameModel.tryToAddShape();

        assertTrue(gameModel.getNextShape() instanceof Straight);
    }

    @Test
    public void tryToAddShapeFail_doesNotChangeNextShape() {
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        when(grid.addShape(any(RightStep.class))).thenReturn(false);
        // Random shape 1 is Straight
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(1);

        gameModel.tryToAddShape();

        assertTrue(gameModel.getNextShape() instanceof RightStep);
    }

    @Test
    public void update_cantAddShape_gameNotOver_doesNotChangeNextShapeMovesShapeDownAndReturnsFalse() {
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        when(grid.addShape(any(RightStep.class))).thenReturn(false);
        when(grid.isGameOver()).thenReturn(false);
        // Random shape 1 is Straight
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(1);

        assertFalse(gameModel.update());
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        verify(grid).moveCurrentShapeDown();
    }

    @Test
    public void update_canAddShape_gameNotOver_changesNextShapeMovesShapeDownAndReturnsFalse() {
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        when(grid.addShape(any(RightStep.class))).thenReturn(true);
        when(grid.isGameOver()).thenReturn(false);
        // Random shape 1 is Straight
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(1);

        assertFalse(gameModel.update());
        assertTrue(gameModel.getNextShape() instanceof Straight);
        verify(grid).moveCurrentShapeDown();
    }

    @Test
    public void update_cantAddShape_gameIsOver_doesNotChangeNextShapeMovesShapeDownAndReturnsTrue() {
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        when(grid.addShape(any(RightStep.class))).thenReturn(false);
        when(grid.isGameOver()).thenReturn(true);
        // Random shape 1 is Straight
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(1);

        assertTrue(gameModel.update());
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        verify(grid).moveCurrentShapeDown();
    }

    @Test
    public void update_canAddShape_gameIsOver_changesNextShapeMovesShapeDownAndReturnsTrue() {
        assertTrue(gameModel.getNextShape() instanceof RightStep);
        when(grid.addShape(any(RightStep.class))).thenReturn(true);
        when(grid.isGameOver()).thenReturn(true);
        // Random shape 1 is Straight
        when(random.nextInt(eq(GameModel.NUM_SHAPES))).thenReturn(1);

        assertTrue(gameModel.update());
        assertTrue(gameModel.getNextShape() instanceof Straight);
        verify(grid).moveCurrentShapeDown();
    }
}
