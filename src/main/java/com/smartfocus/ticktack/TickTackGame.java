package com.smartfocus.ticktack;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by arthur on 13/06/16.
 */
public class TickTackGame {

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
    }



    private void askForFirstPlayerChoice() {
        this.context.write("Please select the first player(c - for computer, h - human):");
    }
}
