package io.djuz.game.snake.logic;


import javafx.scene.paint.Color;

public class Food {

    public static final Color COLOR = Color.TOMATO;
    private Coordinate coordinate;

    public Food(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
