package com.game.minesweeper.model;

import java.util.ArrayList;

class Board {

    private int totalBombs;
    private int totalFlags;

    private ArrayList<Cell> board;
    private ArrayList<Cell> bombs;
    private ArrayList<Cell> flags;

    Board(final int totalBombs) {
        this.board = new ArrayList<>();
        this.bombs = new ArrayList<>();
        this.flags = new ArrayList<>();

        for (int i = 0; i < Ranges.getSize(); i++) {
            this.board.add(new Cell());
        }

        this.totalBombs = totalBombs;

        randomPlaceBombs();
    }

    Icon getIcon(final Coordinate coordinate) {
        return board.get(getIndex(coordinate)).getIcon();
    }

    void opened(final Coordinate coordinate) {
        Cell cell = getCell(coordinate);

        if (!cell.isOpen() && !cell.isFlag()) {
            switch (cell.getValue()) {
                case zero: {
                    cell.setOpen();
                    openCellsAround(coordinate);

                    break;
                }
                case bomb: {
                    cell.setExploded();
                    cell.setOpen();

                    openBombs(coordinate);

                    break;
                }
                default: {
                    cell.setOpen();
                }
            }
        }
    }

    void flagged(final Coordinate coordinate) {
        Cell cell = getCell(coordinate);

        boolean isFlag = cell.isFlag();

        if (isFlag) {
            flags.remove(cell);
        } else {
            flags.add(cell);
        }

        cell.setFlag(!isFlag);
    }

    private Cell getCell(final Coordinate coordinate) {
        return board.get(getIndex(coordinate));
    }

    private int getIndex(final Coordinate coordinate) {
        return coordinate.x + coordinate.y * Ranges.getColumns();
    }

    private void placeBomb(Coordinate coordinate) {
        Cell cell = getCell(coordinate);
        cell.setBomb();

        bombs.add(cell);

        incNumbersAroundBomb(coordinate);
    }

    private void randomPlaceBombs() {
        Cell cell = null;
        Coordinate coordinate;

        for (int i = 0; i < totalBombs; i++) {
            while (true) {
                coordinate = Ranges.getRandomCoordinates();

                cell = getCell(coordinate);

                if (cell.isBomb()) {
                    continue;
                }

                placeBomb(coordinate);

                break;
            }
        }
    }

    private void incNumbersAroundBomb(final Coordinate point) {
        Cell cell = null;

        for (Coordinate coordinate : Ranges.getCoordinatesAroundPoint(point)) {
            cell = getCell(coordinate);

            if (cell.isBomb()) {
                continue;
            }

            cell.setNumber(cell.getValue().getNextValue());
        }
    }

    private void openBombs(final Coordinate coordinate) {
        for (Cell cell : bombs) {
            if (cell.isFlag()) {
                continue;
            }

            cell.setOpen();
        }

        for (Cell cell : flags) {
            if (cell.isBomb()) {
                continue;
            }

            cell.setFlag(false);
            cell.setNotBomb();
            cell.setOpen();
        }
    }

    private void openCellsAround(final Coordinate point) {
        for (Coordinate coordinate : Ranges.getCoordinatesAroundPoint(point)) {
            opened(coordinate);
        }
    }

}