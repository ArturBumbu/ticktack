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
        if (checkLineByNumber(cellSign, 0) ||
                checkLineByNumber(cellSign, 1) ||
                checkLineByNumber(cellSign, 2) ||
                checkColumnByNumber(cellSign, 0) ||
                checkColumnByNumber(cellSign, 1) ||
                checkColumnByNumber(cellSign, 2) ||
                checkPrincipalDiagonal(cellSign) ||
                checkSecondaryDiagonal(cellSign)
                ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkLineByNumber(CellSign cellSign, int line) {
        return this.board.getPosition(new Position(line, 0)).getSign().getName().equals(cellSign.getName()) &&
                this.board.getPosition(new Position(line, 1)).getSign().getName().equals(cellSign.getName()) &&
                this.board.getPosition(new Position(line, 2)).getSign().getName().equals(cellSign.getName());
    }

    private boolean checkColumnByNumber(CellSign cellSign, int column) {
        if (
                this.board.getPosition(new Position(0, column)).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(new Position(1, column)).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(new Position(2, column)).getSign().getName().equals(cellSign.getName())
                ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPrincipalDiagonal(CellSign cellSign) {
        if (
                this.board.getPosition(new Position(0, 0)).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(new Position(1, 1)).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(new Position(2, 2)).getSign().getName().equals(cellSign.getName())
                ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkSecondaryDiagonal(CellSign cellSign) {
        if (
                this.board.getPosition(new Position(0, 2)).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(new Position(1, 1)).getSign().getName().equals(cellSign.getName()) &&
                        this.board.getPosition(new Position(2, 0)).getSign().getName().equals(cellSign.getName())
                ) {
            return true;
        } else {
            return false;
        }
    }
}
