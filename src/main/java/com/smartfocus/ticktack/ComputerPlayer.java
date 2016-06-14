package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class ComputerPlayer implements IPlayer {
    private final CellSign sign;
    private final GameBoard board;
    private final BoardPositionValidator boardPositionValidator;
    private final ComputerMover computerMover;


    public ComputerPlayer(CellSign sign, GameBoard board) {
        this.sign = sign;
        this.board = board;
        boardPositionValidator = new BoardPositionValidator(board);
        computerMover = new ComputerMover(board, boardPositionValidator);
    }

    public void doMove() {
        computerMover.move(sign);
    }

    public CellSign getSign() {
        return this.sign;
    }
}
