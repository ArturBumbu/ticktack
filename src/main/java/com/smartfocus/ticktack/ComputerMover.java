package com.smartfocus.ticktack;

/**
 * Created by arthur on 14/06/16.
 */
public class ComputerMover {
    private final GameBoard board;

    public ComputerMover(GameBoard board) {
        this.board = board;
    }

    public boolean isValid(int row, int col) {
        return this.board.getPosition(row, col).getSign() == CellSign.EMPTY;
    }
}
