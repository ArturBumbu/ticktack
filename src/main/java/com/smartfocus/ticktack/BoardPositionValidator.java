package com.smartfocus.ticktack;

/**
 * Created by arthur on 14/06/16.
 */
public class BoardPositionValidator {
    private final GameBoard board;

    public BoardPositionValidator(GameBoard board) {
        this.board = board;
    }

    public boolean isValid(Position position) {
        return this.board.getPosition(position).getSign() == CellSign.EMPTY;
    }
}
