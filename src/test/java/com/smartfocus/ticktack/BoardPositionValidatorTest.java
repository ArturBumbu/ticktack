package com.smartfocus.ticktack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by arthur on 14/06/16.
 */
public class BoardPositionValidatorTest {

    private File file;
    private GameBoard board;
    private BoardPositionValidator boardPositionValidator;

    @Before
    public void setup() throws IOException {
        file = createTestFile();
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputOutputContext inputOutputContext = new InputOutputContext(inputStream, fileOutputStream);
        this.board = new GameBoard(inputOutputContext);
        boardPositionValidator = new BoardPositionValidator(this.board);
    }

    @After
    public void teardown() {
        file.delete();
    }

    @Test
    public void shouldReturnFalseWhenCrossPositionGenerated() {
        setBoardCrossOnFirstPosition();
        assertFalse(boardPositionValidator.isValid(0, 0));
    }

    @Test
    public void shouldReturnFalseWhenNoughtPositionGenerated() {
        setBoardNoughtOnFirstPosition();
        assertFalse(boardPositionValidator.isValid(0, 0));
    }

    @Test
    public void shouldReturnTrueWhenEmptyPositionGenerated() {
        assertTrue(boardPositionValidator.isValid(0, 0));
    }


    private File createTestFile() throws IOException {
        File file = new File("tmp.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private void setBoardCrossOnFirstPosition() {
        this.board.setPosition(0, 0, CellSign.CROSS);
    }

    private void setBoardNoughtOnFirstPosition() {
        this.board.setPosition(0, 0, CellSign.NOUGHT);
    }
}