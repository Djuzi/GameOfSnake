package io.djuz.game.snake;

public class Grid {
    public static final int SIZE = 10;
    private final int cols;
    private final int rows;

    public Grid(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
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
//    public Coordinate getRandomCoordinate(){
//        Random random = new Random();
//        Coordinate coordinate;
//        do {
//            coordinate= new Coordinate(random.nextInt(rows), random.nextInt(cols));
//        }while (true)
//            return coordinate;
//    }
}
