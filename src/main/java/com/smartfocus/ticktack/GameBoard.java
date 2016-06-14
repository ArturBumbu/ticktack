package com.smartfocus.ticktack;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by arthur on 13/06/16.
 */
public class GameBoard {
    private Cell[][] board;
    private final int GAME_SIZE = 3;
    private final InputOutputContext context;
    private final String DELIMITER = "|";
    private final String LINE_SEPARATOR;

    public GameBoard(InputOutputContext context) {
        this.context = context;
        this.LINE_SEPARATOR = System.getProperty("line.separator");
        board = new Cell[GAME_SIZE][GAME_SIZE];
        for (int row = 0; row < GAME_SIZE; ++row) {
            for (int col = 0; col < GAME_SIZE; ++col) {
                board[row][col] = new Cell(row, col);
            }
        }
    }

    public InputOutputContext getContext() {
        return context;
    }

    public void printBoard() {
        for (int row = 0; row < GAME_SIZE; row++) {
            for (int col = 0; col < GAME_SIZE; col++) {
                context.write(board[row][col].getSign().getName());
                if (col < GAME_SIZE - 1) {
                    context.write(DELIMITER);
                }
            }
            context.write(LINE_SEPARATOR);
        }
    }

    public void setPosition(int row, int col, CellSign cellSign) {
        board[row][col] = new Cell(row, col, cellSign);
    }

    public Cell getPosition(int row, int col) {
        return board[row][col];
    }
}
