package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class ComputerPlayer implements IPlayer {
    private final CellSign sign;

    public ComputerPlayer(CellSign sign) {
        this.sign = sign;
    }

    public void doMove(GameBoard gameBoard) {

    }

    public CellSign getSign() {
        return this.sign;
    }
}
