package com.gregspitz.tetris;

import com.gregspitz.tetris.shape.*;
import org.junit.Before;
import org.junit.Test;

import static com.gregspitz.tetris.Grid.DEFAULT_WIDTH;
import static com.gregspitz.tetris.Grid.DEFAULT_HEIGHT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridTest {

    private Grid grid;

    @Before
    public void setup() {
        grid = new Grid(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Test
    public void addShapeBeyondWidth_doesNotAddShapeAndReturnsFalse() {
        Shape square = new Square(DEFAULT_WIDTH, 0);
        assertFalse(grid.addShape(square));
        assertEquals(GridTestData.EMPTY_GRID_DEFAULT_SIZE_STRING, grid.toString());
    }

    @Test
    public void addShapeBeyondHeight_doesNotAddShapeAndReturnsFalse() {
        Shape square = new Square(0, DEFAULT_HEIGHT);
        assertFalse(grid.addShape(square));
        assertEquals(GridTestData.EMPTY_GRID_DEFAULT_SIZE_STRING, grid.toString());
    }

    @Test
    public void addShapeBelow0X_doesNotAddShapeAndReturnsFalse() {
        Shape square = new Square(-1, DEFAULT_HEIGHT);
        assertFalse(grid.addShape(square));
        assertEquals(GridTestData.EMPTY_GRID_DEFAULT_SIZE_STRING, grid.toString());
    }

    @Test
    public void addSquareWithinBounds_addsSquareAndReturnsTrue() {
        Shape square = new Square(0, 0);
        assertTrue(grid.addShape(square));
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_0, grid.toString());
    }

    @Test
    public void addStraightWithinBounds_addsStraightAndReturnsTrue() {
        Shape straight = new Straight(0, 0);
        assertTrue(grid.addShape(straight));
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_0_0, grid.toString());
    }

    @Test
    public void addRightStepWithinBounds_addsRightStepAndReturnsTrue() {
        Shape rightStep = new RightStep(0, 0);
        assertTrue(grid.addShape(rightStep));
        assertEquals(GridTestData.GRID_WITH_RIGHT_STEP_AT_0_0, grid.toString());
    }

    @Test
    public void addLeftStepWithinBounds_addsLeftStepAndReturnsTrue() {
        Shape leftStep = new LeftStep(0, 0);
        assertTrue(grid.addShape(leftStep));
        assertEquals(GridTestData.GRID_WITH_LEFT_STEP_AT_0_0, grid.toString());
    }

    @Test
    public void addCenterStepWithinBounds_addsCenterStepAndReturnsTrue() {
        Shape centerStep = new CenterStep(0, 0);
        assertTrue(grid.addShape(centerStep));
        assertEquals(GridTestData.GRID_WITH_CENTER_STEP_AT_0_0, grid.toString());
    }

    @Test
    public void moveCurrentShape_movesShapeDownOneRow() {
        Shape square = new Square(0, 0);
        grid.addShape(square);
        grid.moveCurrentShapeDown();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_1, grid.toString());
    }

    @Test
    public void moveCurrentShapeUntilShapeGetsToBottom_shapeRemainsAtBottom() {
        Shape square = new Square(0, 0);
        grid.addShape(square);
        moveShapeDownNumberOfTimes(17);
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_17, grid.toString());
        grid.moveCurrentShapeDown();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_18, grid.toString());
        grid.moveCurrentShapeDown();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_18, grid.toString());
        grid.moveCurrentShapeDown();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_18, grid.toString());
    }

    @Test
    public void oneSquareMovesAllTheWayDown_anotherSquareStacksOnTopOfIt() {
        addInitialSquareAndMoveItAllTheWayDown();
        Shape square = new Square(0, 0);
        addShapeAndMoveItAllTheWayDown(square);
        assertEquals(GridTestData.GRID_WITH_STACKED_SQUARES_AT_0_16, grid.toString());
    }

    @Test
    public void oneSquareMovesAllTheWayDown_aStraightStacksOnTopOfIt() {
        addInitialSquareAndMoveItAllTheWayDown();
        Shape straight = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight);
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_STACKED_ON_SQUARE_AT_0_14, grid.toString());
    }

    @Test
    public void oneSquareMovesAllTheWayDown_aRightStepStacksOnTopOfIt() {
        addInitialSquareAndMoveItAllTheWayDown();
        Shape rightStep = new RightStep(0, 0);
        addShapeAndMoveItAllTheWayDown(rightStep);
        assertEquals(GridTestData.GRID_WITH_RIGHT_STEP_STACKED_ON_SQUARE_AT_0_17, grid.toString());
    }

    @Test
    public void oneSquareMovesAllTheWayDown_aLeftStepStacksOnTopOfIt() {
        addInitialSquareAndMoveItAllTheWayDown();
        Shape leftStep = new LeftStep(0, 0);
        addShapeAndMoveItAllTheWayDown(leftStep);
        assertEquals(GridTestData.GRID_WITH_LEFT_STEP_STACKED_ON_SQUARE_AT_0_16, grid.toString());
    }

    @Test
    public void oneSquareMovesAllTheWayDown_aCenterStepStacksOnTopOfIt() {
        addInitialSquareAndMoveItAllTheWayDown();
        Shape centerStep = new CenterStep(0, 0);
        addShapeAndMoveItAllTheWayDown(centerStep);
        assertEquals(GridTestData.GRID_WITH_CENTER_STEP_STACKED_ON_SQUARE_AT_0_17, grid.toString());
    }

    @Test
    public void shapeAtLeftEdgeMoveLeft_doesNothing() {
        Shape square = new Square(0, 0);
        grid.addShape(square);
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_0, grid.toString());
        grid.moveCurrentShapeLeft();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_0, grid.toString());
    }

    @Test
    public void shapeNotAtLeftEdgeMoveLeft_movesShapeLeftOne() {
        Shape square = new Square(1, 0);
        grid.addShape(square);
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_1_0, grid.toString());
        grid.moveCurrentShapeLeft();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_0, grid.toString());
    }

    @Test
    public void shapeAtRightEdgeMoveRight_doesNothing() {
        Shape square = new Square(DEFAULT_WIDTH - 2, 0);
        grid.addShape(square);
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_8_0, grid.toString());
        grid.moveCurrentShapeRight();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_8_0, grid.toString());
    }

    @Test
    public void shapeNotAtRightEdgeMoveRight_movesShapeRightOne() {
        Shape square = new Square(0, 0);
        grid.addShape(square);
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_0, grid.toString());
        grid.moveCurrentShapeRight();
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_1_0, grid.toString());
    }

    @Test
    public void shapeBumpingAgainstBlockGroupOnLeftMoveLeft_doesNothing() {
        Shape straight = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight);
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_0_16, grid.toString());
        Shape square = new Square(0, 0);
        grid.addShape(square);
        grid.moveCurrentShapeRight();
        moveShapeDownNumberOfTimes(16);
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_0_16_AND_SQUARE_AT_1_16, grid.toString());
        grid.moveCurrentShapeLeft();
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_0_16_AND_SQUARE_AT_1_16, grid.toString());
    }

    @Test
    public void shapeBumpingAgainstBlockGroupOnRightMoveRight_doesNothing() {
        Shape straight = new Straight(5, 0);
        addShapeAndMoveItAllTheWayDown(straight);
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_5_16, grid.toString());
        Shape square = new Square(0, 0);
        grid.addShape(square);
        moveShapeRightNumberOfTimes(3);
        moveShapeDownNumberOfTimes(16);
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_5_16_AND_SQUARE_AT_3_16, grid.toString());
        grid.moveCurrentShapeRight();
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_5_16_AND_SQUARE_AT_3_16, grid.toString());
    }

    @Test
    public void add5StraightsInOnTopOfEachOther_gameOver() {
        Shape straight1 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight1);
        assertEquals(GridTestData.GRID_WITH_STRAIGHT_AT_0_16, grid.toString());
        assertFalse(grid.isGameOver());
        Shape straight2 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight2);
        assertEquals(GridTestData.GRID_WITH_2_STRAIGHTS_STACKED_AT_0_12, grid.toString());
        assertFalse(grid.isGameOver());
        Shape straight3 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight3);
        assertEquals(GridTestData.GRID_WITH_3_STRAIGHTS_STACKED_AT_0_8, grid.toString());
        assertFalse(grid.isGameOver());
        Shape straight4 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight4);
        assertEquals(GridTestData.GRID_WITH_4_STRAIGHTS_STACKED_AT_0_4, grid.toString());
        assertFalse(grid.isGameOver());
        Shape straight5 = new Straight(0, 0);
        grid.addShape(straight5);
        assertEquals(GridTestData.GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0, grid.toString());
        assertTrue(grid.isGameOver());
    }

    @Test
    public void gameOverMoveRight_doesNothing() {
        createGameOverWith5Straights();
        assertEquals(GridTestData.GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0, grid.toString());
        grid.moveCurrentShapeRight();
        assertEquals(GridTestData.GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0, grid.toString());
    }

    @Test
    public void gameOverMoveLeft_doesNothing() {
        createGameOverWith5Straights();
        assertEquals(GridTestData.GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0, grid.toString());
        grid.moveCurrentShapeLeft();
        assertEquals(GridTestData.GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0, grid.toString());
    }

    @Test
    public void gameOverMoveDown_doesNothing() {
        createGameOverWith5Straights();
        assertEquals(GridTestData.GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0, grid.toString());
        grid.moveCurrentShapeDown();
        assertEquals(GridTestData.GRID_WITH_5_STRAIGHTS_STACKED_AT_0_0, grid.toString());
    }

    private void addShapeAndMoveItAllTheWayDown(Shape shape) {
        grid.addShape(shape);
        moveShapeDownNumberOfTimes(18);
    }

    private void addInitialSquareAndMoveItAllTheWayDown() {
        Shape square = new Square(0, 0);
        grid.addShape(square);
        moveShapeDownNumberOfTimes(18);
        assertEquals(GridTestData.GRID_WITH_SQUARE_AT_0_18, grid.toString());
    }

    private void moveShapeDownNumberOfTimes(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            grid.moveCurrentShapeDown();
        }
    }

    private void moveShapeRightNumberOfTimes(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            grid.moveCurrentShapeRight();
        }
    }

    private void createGameOverWith5Straights() {
        Shape straight1 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight1);
        Shape straight2 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight2);
        Shape straight3 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight3);
        Shape straight4 = new Straight(0, 0);
        addShapeAndMoveItAllTheWayDown(straight4);
        Shape straight5 = new Straight(0, 0);
        grid.addShape(straight5);
        assertTrue(grid.isGameOver());
    }
}
