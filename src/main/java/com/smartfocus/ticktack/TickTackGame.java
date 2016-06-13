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

    private InputOutputContext context;

    public TickTackGame(InputStream in, OutputStream out) {
        gameInit(in, out);
        do {
            playerMove();
            printBoard();
            checkGameState();
            printWinnerMessage();
            changePlayers();
        } while (false);
        System.out.println("Game finished");
    }

    private void changePlayers() {
        System.out.println("Change Players");
    }

    private void printWinnerMessage() {
        System.out.println("printWinnerMessage");
    }

    private void checkGameState() {
        System.out.println("checkGameState");
    }

    private void printBoard() {
        System.out.println("printBoard");
    }

    private void playerMove() {
        System.out.println("playerMove");
    }

    private void gameInit(InputStream in, OutputStream out) {
        this.context = new InputOutputContext(in, out);
        askForFirstPlayerChoice();
        initPlayers();
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
            firstPlayer = new HumanPlayer();
            secondPlayer = new ComputerPlayer();
        } else if (firstPlayerChoice.equals("c")) {
            firstPlayer = new ComputerPlayer();
            secondPlayer = new HumanPlayer();
        }
        currentPlayer = firstPlayer;
    }


    private void askForFirstPlayerChoice() {
        this.context.write("Please select the first player(c - for computer, h - human):");
    }
}
