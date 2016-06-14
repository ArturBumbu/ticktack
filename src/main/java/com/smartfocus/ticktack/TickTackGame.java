package com.smartfocus.ticktack;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by arthur on 13/06/16.
 */
public class TickTackGame {
    private IPlayer currentPlayer;
    private IPlayer firstPlayer;
    private IPlayer secondPlayer;
    private GameState currentState;
    private GameBoard gameBoard;
    private final InputOutputContext context;
    private final GameStateChecker checker;

    public TickTackGame(InputStream in, OutputStream out) {
        this.context = new InputOutputContext(in, out);
        this.gameBoard = new GameBoard(this.context);
        this.checker = new GameStateChecker(this.gameBoard);
        gameInit();
        do {
            playerMove();
            printBoard();
            checkGameState();
            printWinnerMessage();
            changePlayers();
        } while (currentState == GameState.PLAYING);
    }

    private void changePlayers() {
        if (currentPlayer == firstPlayer) {
            currentPlayer = secondPlayer;
        } else if (currentPlayer == secondPlayer) {
            currentPlayer = firstPlayer;
        }
    }

    private void printWinnerMessage() {
        if (currentState == GameState.CROSS_WON) {
            context.write("Human won! Bye!");
        } else if (currentState == GameState.NOUGHT_WON) {
            context.write("Computer won! Bye!");
        }
    }

    private void checkGameState() {
        if (checker.hasWon(currentPlayer.getSign())) {
            changeGameStateToWinner();
        }
    }

    private void changeGameStateToWinner() {
        if (currentPlayer instanceof HumanPlayer) {
            currentState = GameState.CROSS_WON;
        } else if (currentPlayer instanceof ComputerPlayer) {
            currentState = GameState.NOUGHT_WON;
        }
    }

    private void printBoard() {
        this.gameBoard.printBoard();
    }

    private void playerMove() {
        currentPlayer.doMove(this.gameBoard);
    }

    private void gameInit() {
        askForFirstPlayerChoice();
        initPlayers();
        this.currentState = GameState.PLAYING;
    }

    private void initPlayers() {
        String firstPlayerChoice = readUserInput();
        instantiatePlayers(firstPlayerChoice);
    }

    private String readUserInput() {
        String firstPlayerChoice = null;
        boolean validCommand = false;
        while (!validCommand) {
            firstPlayerChoice = this.context.read();
            validCommand = InputChoiceValidator.validate(firstPlayerChoice);
            if (validCommand) {
                break;
            } else {
                context.write("Please enter a valid char: ");
            }
        }
        return firstPlayerChoice;
    }

    private void instantiatePlayers(String firstPlayerChoice) {
        if (firstPlayerChoice.equals("h")) {
            firstPlayer = new HumanPlayer(CellSign.CROSS);
            secondPlayer = new ComputerPlayer(CellSign.NOUGHT, this.gameBoard);
        } else if (firstPlayerChoice.equals("c")) {
            firstPlayer = new ComputerPlayer(CellSign.NOUGHT, this.gameBoard);
            secondPlayer = new HumanPlayer(CellSign.CROSS);
        }
        currentPlayer = firstPlayer;
    }


    private void askForFirstPlayerChoice() {
        this.context.write("Please select the first player(c - for computer, h - human):");
    }
}
