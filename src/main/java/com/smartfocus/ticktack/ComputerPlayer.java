package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class ComputerPlayer implements IPlayer {
    private final CellSign sign;
    private final GameBoard board;
    private final BoardPositionValidator boardPositionValidator;


    public ComputerPlayer(CellSign sign, GameBoard board) {
        this.sign = sign;
        this.board = board;
        boardPositionValidator = new BoardPositionValidator(board);
    }

    public void doMove() {
        new ComputerMover(board, boardPositionValidator).move(sign);
    }

    public CellSign getSign() {
        return this.sign;
    }
}
