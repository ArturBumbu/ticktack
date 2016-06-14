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
        board.getContext().write("It's your turn please enter a position like [1,2]: ");
        Position position = validateTheInputNumbers();
        setUserPosition(board, position);
    }


    private Position validateTheInputNumbers() {
        boolean isValidInput = false;
        String userPosition;
        Position position = null;
        while (!isValidInput) {
            userPosition = board.getContext().read();
            isValidInput = HumanInputPositionValidator.validate(userPosition);
            if (isValidInput) {
                position = getPosition(userPosition);
                break;
            } else {
                board.getContext().write("Please enter a valid position in format 1,2: ");
            }
        }
        return position;
    }

    public CellSign getSign() {
        return this.sign;
    }

    private void setUserPosition(GameBoard gameBoard, Position position) {
        gameBoard.setPosition(position, this.sign);
    }

    private Position getPosition(String userPosition) {
        String[] ints = userPosition.split(",");
        return new Position(Integer.valueOf(ints[0]), Integer.valueOf(ints[1]));
    }
}
