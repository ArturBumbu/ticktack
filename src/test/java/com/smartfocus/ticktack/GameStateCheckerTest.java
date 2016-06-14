package com.smartfocus.ticktack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by arthur on 14/06/16.
 */
public class GameStateCheckerTest {

    private GameBoard board;
    private GameStateChecker gameStateChecker;
    private File file;

    @Before
    public void setup() throws IOException {
        file = createTestFile();
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputOutputContext inputOutputContext = new InputOutputContext(inputStream, fileOutputStream);
        this.board = new GameBoard(inputOutputContext);
        this.gameStateChecker = new GameStateChecker(board);
    }

    @After
    public void teardown() {
        file.delete();
    }

    @Test
    public void shouldCheckIfCurrentPlayerWinByFirstLineCompleted() {
        CellSign cellSign = CellSign.CROSS;
        setFirstLineCompleted(cellSign);
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
        this.board.printBoard();
    }


    @Test
    public void shouldCheckIfCurrentPlayerWinBySecondCompleted() {
        CellSign cellSign = CellSign.CROSS;
        setSecondLineCompleted(cellSign);
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
        board.printBoard();
    }

    @Test
    public void shouldCheckIfCurrentPlayerWinByThirdCompleted() {
        CellSign cellSign = CellSign.CROSS;
        setThirdLineCompleted(cellSign);
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
    }

    @Test
    public void shouldCheckIfCurrentPlayerWinByFirstColumnCompleted() {
        CellSign cellSign = CellSign.CROSS;
        setFirstColumnCompleted(cellSign);
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
    }

    @Test
    public void shouldCheckIfCurrentPlayerWinBySecondColumnCompleted() {
        CellSign cellSign = CellSign.CROSS;
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
    }

    @Test
    public void shouldCheckIfCurrentPlayerWinByThirdColumnCompleted() {
        CellSign cellSign = CellSign.CROSS;
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
    }

    @Test
    public void shouldCheckIfCurrentPlayerWinByPrincipalDiagonalCompleted() {
        CellSign cellSign = CellSign.CROSS;
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
    }

    @Test
    public void shouldCheckIfCurrentPlayerWinBySecondaryDiagonalCompleted() {
        CellSign cellSign = CellSign.CROSS;
        boolean has_won_cross = gameStateChecker.hasWon(cellSign);
        assertTrue(has_won_cross);
    }

    private File createTestFile() throws IOException {
        File file = new File("tmp.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private void setFirstLineCompleted(CellSign cellSign) {
        this.board.setPosition(0, 0, cellSign);
        this.board.setPosition(0, 1, cellSign);
        this.board.setPosition(0, 2, cellSign);
    }

    private void setSecondLineCompleted(CellSign cellSign) {
        this.board.setPosition(1, 0, cellSign);
        this.board.setPosition(1, 1, cellSign);
        this.board.setPosition(1, 2, cellSign);
    }

    private void setThirdLineCompleted(CellSign cellSign) {
        this.board.setPosition(2, 0, cellSign);
        this.board.setPosition(2, 1, cellSign);
        this.board.setPosition(2, 2, cellSign);
    }

    private void setFirstColumnCompleted(CellSign cellSign) {
        this.board.setPosition(0, 0, cellSign);
        this.board.setPosition(1, 0, cellSign);
        this.board.setPosition(2, 0, cellSign);
    }
}