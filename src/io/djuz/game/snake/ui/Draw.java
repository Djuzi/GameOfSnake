package io.djuz.game.snake.ui;

import io.djuz.game.snake.logic.Coordinate;
import io.djuz.game.snake.logic.Food;
import io.djuz.game.snake.logic.Grid;
import io.djuz.game.snake.logic.Snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static io.djuz.game.snake.logic.Grid.CELLSIZE;

/**
 *
 */
public class Draw {

    public static void paint(Grid grid, GraphicsContext gc) {
        gc.setFill(Grid.COLOR);
        gc.fillRect(0, 0, grid.getWidth(), grid.getHeight());


        gc.setFill(Food.COLOR);
        paintCoordinate(grid.getFood().getCoordinate(), gc);


        Snake snake = grid.getSnake();
        gc.setFill(Snake.LIVE);
        snake.getSnakeBody().forEach(point -> paintCoordinate(point, gc));
        if (snake.isAlive()) {
            gc.setFill(Snake.DEAD);
            paintCoordinate(snake.getSnakeFace(), gc);
        }


        gc.setFill(Color.BEIGE);
        gc.fillText("Score : " + 100 * snake.getSnakeBody().size(), 10, 490);
    }

    private static void paintCoordinate(Coordinate coordinate, GraphicsContext gc) {
        gc.fillRect(coordinate.getCoordinateX() * CELLSIZE, coordinate.getCoordinateY() * CELLSIZE, CELLSIZE, CELLSIZE);
    }

    public static void paintResetMessage(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Hit RETURN to reset.", 10, 10);
    }
}
