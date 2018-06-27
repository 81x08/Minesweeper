package com.game.minesweeper.model;

public class Coordinate {

    public int x;
    public int y;

    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Coordinate) {
            Coordinate coordinate = (Coordinate) object;

            return coordinate.x == x && coordinate.y == y;
        }

        return super.equals(object);
    }
}
