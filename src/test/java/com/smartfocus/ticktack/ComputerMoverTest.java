package com.smartfocus.ticktack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by arthur on 14/06/16.
 */
public class ComputerMoverTest {

    private ComputerMover computerMover;

    @Before
    public void setup() throws IOException {
        computerMover = new ComputerMover(null, null);
    }

    @Test
    public void shouldGenerateAnIntBetweenZeroAndTwo() {
        int generatedInt = computerMover.generate();
        assertTrue(generatedInt >= 0 && generatedInt <= 2);
    }
}