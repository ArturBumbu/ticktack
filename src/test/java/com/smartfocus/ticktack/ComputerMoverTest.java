package com.smartfocus.ticktack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by arthur on 14/06/16.
 */
public class ComputerMoverTest {

    private File file;
    private GameBoard board;
    ComputerMover computerMover;

    @Before
    public void setup() throws IOException {
        file = createTestFile();
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputOutputContext inputOutputContext = new InputOutputContext(inputStream, fileOutputStream);
        this.board = new GameBoard(inputOutputContext);
        computerMover = new ComputerMover(this.board);
    }

    @After
    public void teardown() {
        file.delete();
    }

    @Test
    public void shouldReturnFalseWhenCrossPositionGenerated() {
        setBoardCrossOnFirstPosition();
        assertFalse(computerMover.isValid(0, 0));
    }

    @Test
    public void shouldReturnFalseWhenNoughtPositionGenerated() {
        setBoardNoughtOnFirstPosition();
        assertFalse(computerMover.isValid(0, 0));
    }

    @Test
    public void shouldReturnTrueWhenEmptyPositionGenerated() {
        assertTrue(computerMover.isValid(0, 0));
    }

    private void setBoardCrossOnFirstPosition() {
        this.board.setPosition(0, 0, CellSign.CROSS);
    }

    private void setBoardNoughtOnFirstPosition() {
        this.board.setPosition(0, 0, CellSign.NOUGHT);
    }

    private File createTestFile() throws IOException {
        File file = new File("tmp.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}