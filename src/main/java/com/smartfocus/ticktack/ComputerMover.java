package com.smartfocus.ticktack;

import java.util.Random;

/**
 * Created by arthur on 14/06/16.
 */
public class ComputerMover {
    private final GameBoard board;
    private int currentValidPositionForRow;
    private int currentValidPositionForCol;

    public ComputerMover(GameBoard board) {
        this.board = board;
    }

    public void move(CellSign cellSign) {
        boolean validPosition = false;
        while (!validPosition) {
            this.currentValidPositionForCol = generate();
            this.currentValidPositionForRow = generate();
            validPosition = isValid(currentValidPositionForRow, currentValidPositionForCol);
        }
        board.setPosition(currentValidPositionForRow, currentValidPositionForCol, cellSign);
    }

    public boolean isValid(int row, int col) {
        return this.board.getPosition(row, col).getSign() == CellSign.EMPTY;
    }


    public int generate() {
        Random random = new Random();
        return random.nextInt(3);
    }
}
