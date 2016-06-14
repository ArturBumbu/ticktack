package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class ComputerPlayer implements IPlayer {
    private final CellSign sign;
    private final GameBoard board;


    public ComputerPlayer(CellSign sign, GameBoard board) {
        this.sign = sign;
        this.board = board;
    }

    public void doMove() {
        new ComputerMover(board, new BoardPositionValidator(board)).move(sign);
    }

    public CellSign getSign() {
        return this.sign;
    }
}
