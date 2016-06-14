package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class HumanPlayer implements IPlayer {
    private final CellSign sign;

    public HumanPlayer(CellSign sign) {
        this.sign = sign;
    }

    public void doMove(GameBoard gameBoard) {
        boolean isValidPosition = false;
        String userPosition = null;
        gameBoard.getContext().write("It's your turn please enter a position like [1,2]: ");
        while (!isValidPosition) {
            userPosition = gameBoard.getContext().read();
            isValidPosition = HumanInputPositionValidator.validate(userPosition);
            if (isValidPosition) {
                break;
            } else {
                gameBoard.getContext().write("Please enter a valid position in format 1,2: ");
            }
        }
        setUserPosition(gameBoard, userPosition);
    }

    private void setUserPosition(GameBoard gameBoard, String userPosition) {
        String[] position = userPosition.split(",");
        gameBoard.setPosition(Integer.valueOf(position[0]), Integer.valueOf(position[1]), this.sign);
    }
}
