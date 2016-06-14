package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class HumanPlayer implements IPlayer {
    private final CellSign sign;
    private final GameBoard board;

    public HumanPlayer(CellSign sign, GameBoard board) {
        this.sign = sign;
        this.board = board;
    }

    public void doMove() {
        boolean isValidInput = false;
        String userPosition = null;
        board.getContext().write("It's your turn please enter a position like [1,2]: ");
        while (!isValidInput) {
            userPosition = board.getContext().read();
            isValidInput = HumanInputPositionValidator.validate(userPosition);
            if (isValidInput) {
                break;
            } else {
                board.getContext().write("Please enter a valid position in format 1,2: ");
            }
        }
        setUserPosition(board, userPosition);
    }

    public CellSign getSign() {
        return this.sign;
    }

    private void setUserPosition(GameBoard gameBoard, String userPosition) {
        String[] position = userPosition.split(",");
        gameBoard.setPosition(Integer.valueOf(position[0]), Integer.valueOf(position[1]), this.sign);
    }
}
