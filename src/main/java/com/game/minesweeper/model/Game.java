package com.game.minesweeper.model;

import java.util.ArrayList;

public class Game {

    private int totalBombs;

    private Board board;

    public Game(final int columns, final int rows, final int totalBombs) {
        Ranges.setSize(columns, rows);

        this.totalBombs = totalBombs;

        createBoard();
    }

    public Icon getIcon(final Coordinate coordinate) {
        return board.getIcon(coordinate);
    }

    public ArrayList<Icon> getIcons() {
        ArrayList<Icon> icons = new ArrayList<>();

        for (Coordinate coordinate : Ranges.getCoordinates()) {
            icons.add(getIcon(coordinate));
        }

        return icons;
    }

    public void pressLeftButton(final Coordinate coordinate) {
        board.opened(coordinate);
    }

    public void pressRightButton(final Coordinate coordinate) {
        board.flagged(coordinate);
    }

    public void pressMiddleButton() {
        createBoard();
    }

    private void createBoard() {
        board = new Board(totalBombs);
    }

}
