package com.smartfocus.ticktack;

import java.util.Random;

/**
 * Created by arthur on 14/06/16.
 */
public class ComputerMover {
    private final GameBoard board;
    private Position position;
    private final BoardPositionValidator boardPositionValidator;

    public ComputerMover(GameBoard board, BoardPositionValidator boardPositionValidator) {
        this.board = board;
        this.boardPositionValidator = boardPositionValidator;
    }

    public void move(CellSign cellSign) {
        boolean validPosition = false;
        while (!validPosition) {
            this.position = new Position(generate(), generate());
            validPosition = boardPositionValidator.isValid(position);
        }
        board.setPosition(position, cellSign);
    }


    public int generate() {
        Random random = new Random();
        return random.nextInt(3);
    }
}
