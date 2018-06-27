package com.game.minesweeper.view;

import com.game.minesweeper.controller.MouseController;
import com.game.minesweeper.model.Coordinate;
import com.game.minesweeper.model.Icon;
import com.game.minesweeper.model.Ranges;

import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewWindow extends JFrame {

    private JPanel panel;

    private MouseController mouseController;

    public ViewWindow() {
        initResources();
        initSettings();

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ArrayList<Icon> icons = mouseController.getIcons();
                ArrayList<Coordinate> coordinates = Ranges.getCoordinates();

                for (int i = 0; i < Ranges.getSize(); i++) {
                    g.drawImage(icons.get(i).getImage(), coordinates.get(i).x * Icon.IMAGE_SIZE, coordinates.get(i).y * Icon.IMAGE_SIZE, this);
                }
            }
        };

        panel.setPreferredSize(new Dimension(Ranges.getColumns() * Icon.IMAGE_SIZE, Ranges.getRows() * Icon.IMAGE_SIZE));
        add(panel);

        initFrame();
    }

    public void addController(MouseController mouseController) {
        this.mouseController = mouseController;
    }

    public void setMouseAdapted(final MouseAdapter mouseAdapted) {
        panel.addMouseListener(mouseAdapted);
    }

    public void repaint() {
        panel.repaint();
    }

    private void initResources() {
        for (Icon icon : Icon.values()) {
            icon.setImage(getBufferedImage(icon.name()));
        }
    }

    private BufferedImage getBufferedImage(String name) {
        String fileName = "/" + name + ".png";

        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(ViewWindow.class.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedImage;
    }

    private void initSettings() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(getBufferedImage("icon"));
    }

    private void initFrame() {
        pack();
    }

}
