package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class Cell {
    private CellSign sign;


    public Cell() {
        this.sign = CellSign.EMPTY;
    }

    public Cell(CellSign cellSign) {
        this.sign = cellSign;
    }

    public CellSign getSign() {
        return sign;
    }

}
