package com.smartfocus.ticktack;

import java.util.Random;

/**
 * Created by arthur on 14/06/16.
 */
public class ComputerMover {
    private final GameBoard board;
    private int currentValidPositionForRow;
    private int currentValidPositionForCol;
    private final BoardPositionValidator boardPositionValidator;

    public ComputerMover(GameBoard board, BoardPositionValidator boardPositionValidator) {
        this.board = board;
        this.boardPositionValidator = boardPositionValidator;
    }

    public void move(CellSign cellSign) {
        boolean validPosition = false;
        while (!validPosition) {
            this.currentValidPositionForCol = generate();
            this.currentValidPositionForRow = generate();
            validPosition = boardPositionValidator.isValid(currentValidPositionForRow, currentValidPositionForCol);
        }
        board.setPosition(currentValidPositionForRow, currentValidPositionForCol, cellSign);
    }


    public int generate() {
        Random random = new Random();
        return random.nextInt(3);
    }
}
