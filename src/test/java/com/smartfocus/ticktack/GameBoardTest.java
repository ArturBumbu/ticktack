package com.smartfocus.ticktack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by arthur on 13/06/16.
 */
public class GameBoardTest {

    private GameBoard gameBoard;
    private File file;

    @Before
    public void setUp() throws Exception {
        file = createTestFile();
        initBoard(file);
    }

    @After
    public void tearDown() throws Exception {
        file.delete();
    }

    @Test
    public void shouldPrintEmptyCells() throws FileNotFoundException {
        int nrLines = 0;
        gameBoard.printBoard();
        nrLines = checkBoardLinesContent(nrLines);
        checkNrBoardRows(nrLines);
    }

    @Test
    public void shouldSetBoardPositionGiven() {
        int col = 1;
        int row = 2;
        CellSign cellSign = CellSign.CROSS;
        gameBoard.setPosition(col, row, cellSign);
        Cell cell = gameBoard.getPosition(col, row);
        assertEquals(cellSign.getName(), cell.getSign().getName());
    }

    private void checkNrBoardRows(int nrLines) {
        assertEquals(3, nrLines);
    }

    private void initBoard(File file) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputOutputContext context = new InputOutputContext(null, fileOutputStream);
        gameBoard = new GameBoard(context);

    }

    private int checkBoardLinesContent(int nrLines) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            assertEquals(CellSign.EMPTY.getName() + "|" + CellSign.EMPTY.getName() + "|" + CellSign.EMPTY.getName(), line);
            nrLines++;
        }
        return nrLines;
    }

    private File createTestFile() throws IOException {
        File file = new File("tmp.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}