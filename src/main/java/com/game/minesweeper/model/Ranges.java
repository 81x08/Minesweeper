package com.game.minesweeper.model;

import java.util.ArrayList;
import java.util.Random;

public abstract class Ranges {

    private static Random random = new Random();

    private static int columns;
    private static int rows;

    private static ArrayList<Coordinate> coordinates;

    public static int getSize() {
        return columns * rows;
    }

    public static void setSize(final int _columns, final int _rows){
        columns = _columns;
        rows = _rows;

        coordinates = new ArrayList<>();

        for (int x = 0; x < _columns; x++) {
            for (int y = 0; y < _rows; y++){
                coordinates.add(new Coordinate(x, y));
            }
        }
    }

    public static int getColumns() {
        return columns;
    }

    public static int getRows() {
        return rows;
    }

    public static boolean inRange(final Coordinate coordinate) {
        return  coordinate.x >= 0 && coordinate.x < columns &&
                coordinate.y >= 0 && coordinate.y < rows;
    }

    public static ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public static Coordinate getRandomCoordinates() {
        return new Coordinate(random.nextInt(columns), random.nextInt(rows));
    }

    public static ArrayList<Coordinate> getCoordinatesAroundPoint(final Coordinate point) {
        Coordinate coordinate;
        ArrayList<Coordinate> coordinatesAround = new ArrayList<Coordinate>();

        for (int x = point.x - 1; x <= point.x + 1; x++) {
            for (int y = point.y - 1; y <= point.y + 1; y++) {
                if (inRange(coordinate = new Coordinate(x, y))) {
                    if (!coordinate.equals(point)) {
                        coordinatesAround.add(coordinate);
                    }
                }
            }
        }

        return coordinatesAround;
    }

}