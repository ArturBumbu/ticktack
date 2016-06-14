package com.smartfocus.ticktack;

/**
 * Created by arthur on 14/06/16.
 */
public class GameStateChecker {
    private final GameBoard board;

    public GameStateChecker(GameBoard board) {
        this.board = board;
    }

    public boolean hasWon(CellSign cellSign) {
        if (checkFirstLine(cellSign)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFirstLine(CellSign cellSign) {
        if (
                this.board.getPosition(0, 0).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(0, 1).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(0, 2).getSign().getName().equals(cellSign.getName())
                ) {
            return true;
        } else {
            return false;
        }
    }
}
