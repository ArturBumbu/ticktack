package com.smartfocus.ticktack;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by arthur on 13/06/16.
 */
public class HumanPlayerTest {

    private IPlayer humanPlayer;
    private GameBoard board;
    File file;

    public void setUp() throws IOException {
        file = createTestFile();
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputOutputContext inputOutputContext = new InputOutputContext(inputStream, fileOutputStream);
        board = new GameBoard(inputOutputContext);
        humanPlayer = new HumanPlayer();
    }

    @Test
    public void shouldAskUserForLocationToMove() {

        humanPlayer.doMove(board);
        assertEquals("It's your turn please enter a position like: 1,2", board.getContext().read());
    }

    private File createTestFile() throws IOException {
        File file = new File("tmp.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}