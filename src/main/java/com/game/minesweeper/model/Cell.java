package com.game.minesweeper.model;

public class Cell {

    private Icon lowLayer;
    private Icon highLayer = Icon.closed;

    public Cell () {
        lowLayer = Icon.zero;
    }

    public Cell (final Icon value) {
        lowLayer = value;
    }

    public boolean isFlag() {
        return highLayer == Icon.flagged;
    }

    public void setFlag(final boolean flag){
        if (!isOpen()) {
            this.highLayer = flag ? Icon.flagged : Icon.closed;
        }
    }

    public boolean isOpen() {
        return highLayer == Icon.opened;
    }

    public void setOpen() {
        if (!isFlag()) {
            highLayer = Icon.opened;
        }
    }

    public boolean isBomb() {
        return lowLayer == Icon.bomb;
    }

    public void setBomb() {
        lowLayer = Icon.bomb;
    }

    public void setNotBomb() {
        lowLayer = Icon.notbomb;
    }

    public void setExploded() {
        lowLayer = Icon.exploded;
    }

    public boolean isNumber() {
        return !isBomb();
    }

    public void setNumber(final Icon value) {
        lowLayer = value;
    }

    public Icon getIcon() {
        return isOpen() ? lowLayer : highLayer;
    }

    public Icon getValue() {
        return lowLayer;
    }

}