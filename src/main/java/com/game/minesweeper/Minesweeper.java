package com.game.minesweeper;

import com.game.minesweeper.controller.*;
import com.game.minesweeper.model.*;
import com.game.minesweeper.view.ViewWindow;

class Minesweeper {

    private static int COLUMNS = 9;
    private static int ROWS = 9;
    private static int BOMBS = 10;

    public static void main(String[] args) {
        Game game = new Game(COLUMNS, ROWS, BOMBS);
        ViewWindow view = new ViewWindow();
        MouseController mouseController = new MouseController();

        view.addController(mouseController);
        mouseController.addDependence(game, view);
    }
}