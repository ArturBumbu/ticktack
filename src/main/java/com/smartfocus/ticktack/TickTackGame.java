package com.smartfocus.ticktack;

/**
 * Created by arthur on 13/06/16.
 */
public class TickTackGame {
    public TickTackGame() {
        gameInit();
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

    private void gameInit() {
        System.out.println("gameInit");
    }
}
