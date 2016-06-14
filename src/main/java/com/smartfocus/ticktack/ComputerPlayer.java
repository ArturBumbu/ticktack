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

    public void doMove(GameBoard gameBoard) {
        new ComputerMover(gameBoard, new BoardPositionValidator(gameBoard)).move(sign);
    }

    public CellSign getSign() {
        return this.sign;
    }
}
