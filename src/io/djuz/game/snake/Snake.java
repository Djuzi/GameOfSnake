package io.djuz.game.snake;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Snake enlargement after eating
     *
     * @param coordinate Food location but a new point for the snake’s head
     */
    private void increaseLength(Coordinate coordinate) {
        length++;
    }

    //FIXME: Переписть это дерьмо
    private void checkAndAdd(Coordinate coordinate) {
        snakeFace = grid.gridCare(coordinate);

    }
}
