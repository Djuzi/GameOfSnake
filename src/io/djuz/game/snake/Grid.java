package io.djuz.game.snake;

import javafx.scene.paint.Color;

import java.util.Random;

public class Grid {
    public static final int CELLSIZE = 10;
    public static final Color COLOR = new Color(0.1, 0.1, 0.1, 1);
    private final int cols;
    private final int rows;
    private Snake snake;
    private Food food;

    public Grid(int rows, int cols) {
        this.cols = cols / CELLSIZE;
        this.rows = rows / CELLSIZE;
        snake = new Snake();
        food = new Food();
    }

    public static int getCELLSIZE() {
        return CELLSIZE;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }


    public Coordinate gridCare(Coordinate coordinate) {
        int x = coordinate.getCoordinateX();
        int y = coordinate.getCoordinateY();
        if (x >= rows) x = 0;
        if (y >= cols) y = 0;
        if (x < 0) x = rows - 1;
        if (y < 0) y = cols - 1;
        return new Coordinate(x, y);
    }

    public Coordinate getRandomCoordinate() {
        Random random = new Random();
        Coordinate coordinate;
        do {
            coordinate = new Coordinate(random.nextInt(rows), random.nextInt(cols));
        } while (true)
        return coordinate;
    }
}
