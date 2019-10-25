package io.djuz.game.snake;


import javafx.scene.paint.Color;

public class Food {
    //    private FoodType foodType;
    private static final Color COLOR = Color.TOMATO;
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
