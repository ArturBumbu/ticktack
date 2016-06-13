package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public enum  CellSign {
    EMPTY("   "), CROSS(" X "), NOUGHT(" O ");
    String name;

    CellSign(String s) {
        this.name = s;
    }

    public String getName() {
        return this.name;
    }
}
