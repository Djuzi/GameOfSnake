package io.djuz.game.snake;

import javafx.scene.paint.Color;

import java.util.List;

public class Snake {
    private final static Color LIVE = Color.GREENYELLOW;
    private final static Color DEAD = Color.RED;
    private Grid grid;
    private Coordinate snakeFace;
    private List<Coordinate> snakebody;
    private int length;
    private boolean isAlive;

    //FIXME: Переделать заглушка - очень спать хочется
    public Snake(Grid grid, Coordinate snakeFace, List<Coordinate> snakebody, int length, boolean isAlive) {
        this.grid = grid;
        this.snakeFace = snakeFace;
        this.snakebody = snakebody;
        this.length = length;
        this.isAlive = isAlive;
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

    public List<Coordinate> getSnakebody() {
        return snakebody;
    }

    public void setSnakebody(List<Coordinate> snakebody) {
        this.snakebody = snakebody;
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

    private void increaseLength(Coordinate coordinate) {
        length++;
    }

    //FIXME: Переписть это дерьмо
    private void checkAndAdd(Coordinate coordinate) {
        snakeFace = grid.gridCare(coordinate);

    }
}
