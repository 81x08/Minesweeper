package com.game.minesweeper.model;

import java.awt.image.BufferedImage;

public enum Icon {

    zero,
    num1,
    num2,
    num3,
    num4,
    num5,
    num6,
    num7,
    num8,
    bomb,
    opened,
    closed,
    flagged,
    exploded,
    notbomb;

    public static final int IMAGE_SIZE = 50;

    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Icon getNextValue() {
        return Icon.values()[this.ordinal() + 1];
    }

}
