package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class HumanPlayer implements IPlayer {


    public void doMove(GameBoard gameBoard) {
        gameBoard.getContext().write("It's your turn please enter a position like [1,2]: ");
        String userPosition = gameBoard.getContext().read();
    }
}
