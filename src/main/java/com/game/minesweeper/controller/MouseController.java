package com.game.minesweeper.controller;

import com.game.minesweeper.model.Game;
import com.game.minesweeper.model.Coordinate;
import com.game.minesweeper.model.Icon;
import com.game.minesweeper.view.ViewWindow;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseController extends JFrame {

    private Game game;
    private ViewWindow viewWindow;
    private MouseAdapter mouseAdapter;

    public MouseController() {
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / com.game.minesweeper.model.Icon.IMAGE_SIZE;
                int y = e.getY() / Icon.IMAGE_SIZE;

                Coordinate coordinate = new Coordinate(x, y);

                if (e.getButton() == MouseEvent.BUTTON1) {
                    pressLeftButton(coordinate);
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    pressMiddleButton();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    pressRightButton(coordinate);
                }

                repaintView();
            }
        };
    }

    public void addDependence(final Game game, final ViewWindow viewWindow) {
        this.game = game;
        this.viewWindow = viewWindow;

        viewWindow.setMouseAdapted(mouseAdapter);
    }

    public ArrayList<Icon> getIcons() {
        return game.getIcons();
    }

    private void pressLeftButton(final Coordinate coordinate) {
        game.pressLeftButton(coordinate);
    }

    private void pressRightButton(final Coordinate coordinate) {
        game.pressRightButton(coordinate);
    }

    private void pressMiddleButton() {
        game.pressMiddleButton();
    }

    private void repaintView() {
        viewWindow.repaint();
    }

}