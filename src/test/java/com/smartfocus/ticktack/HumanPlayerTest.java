package com.smartfocus.ticktack;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by arthur on 13/06/16.
 */
public class HumanPlayerTest {

    private IPlayer humanPlayer;
    private GameBoard board;
    File file;
    InputOutputContext inputOutputContext;

    @Before
    public void setUp() throws IOException {
        file = createTestFile();
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        inputOutputContext = new InputOutputContext(inputStream, fileOutputStream);
        board = new GameBoard(inputOutputContext);
        humanPlayer = new HumanPlayer(CellSign.CROSS, board);
    }

    @Test
    @Ignore
    public void shouldAskUserForLocationToMove() {
        humanPlayer.doMove();
        assertEquals("It's your turn please enter a position like [1,2]: ", inputOutputContext.read());
    }

    @Test
    @Ignore
    public void shouldReadUserLocationFromStream() {
        humanPlayer.doMove();
        inputOutputContext.write("1,2");
        assertEquals("1,2", inputOutputContext.read());
    }

    private File createTestFile() throws IOException {
        File file = new File("tmp.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}