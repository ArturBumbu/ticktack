package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class Cell {
    private CellSign sign;
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.col = col;
        this.row = row;
        this.sign = CellSign.EMPTY;
    }

    public CellSign getSign() {
        return sign;
    }

    public void setSign(CellSign sign) {
        this.sign = sign;
    }
}
