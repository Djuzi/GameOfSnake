package io.djuz.game.snake.logic;

/**
 * Class for the coordinate save.
 */
public class Coordinate {

    private int coordinateX;

    private int coordinateY;

    public Coordinate(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Coordinate moveCoordinate(int newX, int newY) {
        return new Coordinate(coordinateX + newX, coordinateY + newY);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Coordinate)) return false;
        Coordinate coordinate = (Coordinate) o;
        return coordinateX == coordinate.coordinateX & coordinateY == coordinate.coordinateY;
    }

    @Override
    public String toString() {
        return String.format("Point{x=%d, y=%d}", coordinateX, coordinateY);
    }
}
