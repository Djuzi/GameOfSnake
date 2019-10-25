package io.djuz.game.snake;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * A class describing the structure and methods for the essence of the snake
 */
public class Snake {
    private final static Color LIVE = Color.GREENYELLOW;
    private final static Color DEAD = Color.RED;
    private Grid grid;
    private Coordinate snakeFace;
    private List<Coordinate> snakeBody;
    private int length;
    private boolean isAlive;
    private int xMove;
    private int yMove;

    public Snake(Grid grid, Coordinate snakeFace) {
        this.grid = grid;
        this.snakeFace = snakeFace;
        this.snakeBody = new LinkedList<>();
        this.length = 1;
        this.isAlive = true;
        this.xMove = 1;
        this.yMove = 1;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Coordinate getSnakeFace() {
        return snakeFace;
    }

    public void setSnakeFace(Coordinate snakeFace) {
        this.snakeFace = snakeFace;
    }

    public List<Coordinate> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(List<Coordinate> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return If the snake has not yet bitten itself
     */
    public boolean isAlive() {
        return isAlive || length == 1;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Snake enlargement after eating
     * @param coordinate Food location but a new point for the snake’s head
     */
    private void increaseLength(Coordinate coordinate) {
        length++;
        checkAndAdd(coordinate);
    }

    /**
     * Checking the snake for life and death
     *
     * @param coordinate new coordinate to move
     */
    private void checkAndAdd(Coordinate coordinate) {
        coordinate = grid.gridWrap(coordinate);
        if (isAlive & !snakeBody.contains(snakeFace)) {
            isAlive = true;
            snakeBody.add(coordinate);
            snakeFace = coordinate;
        } else isAlive = false;
    }

    /**
     * Delete old coordinate and add new coordinate
     *
     * @param coordinate New coordinate to add
     */
    private void deleteAndAdd(Coordinate coordinate) {
        checkAndAdd(coordinate);
        snakeBody.remove(0);
    }

    /**
     * @return Snake movement check
     */
    private boolean isMoving() {
        return xMove == 0 & yMove == 0;
    }

    /**
     * Make the snake extend/grow to the square where it's headed.
     */
    public void extend() {
        if (!isMoving()) increaseLength(snakeFace.moveCoordinate(xMove, yMove));

    }

    /**
     * Make the snake move one square in it's current direction.
     */
    public void move() {
        if (!isMoving()) deleteAndAdd(snakeFace.moveCoordinate(xMove, yMove));
    }

    /**
     * The direction of movement of the snake up
     */
    public void moveUp() {
        if (yMove == 1 && length > 1) return;
        xMove = 0;
        yMove = -1;
    }

    /**
     * The direction of movement of the snake down
     */
    public void moveDown() {
        if (yMove == -1 && length > 1) return;
        xMove = 0;
        yMove = 1;
    }

    /**
     * The direction of movement of the snake left
     */
    public void moveLeft() {
        if (xMove == 1 && length > 1) return;
        xMove = -1;
        yMove = 0;
    }

    /**
     * The direction of movement of the snake right
     */
    public void moveRight() {
        if (xMove == -1 && length > 1) return;
        xMove = 1;
        yMove = 0;
    }
}
