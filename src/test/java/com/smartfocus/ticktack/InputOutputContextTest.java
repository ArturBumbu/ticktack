package com.smartfocus.ticktack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by arthur on 13/06/16.
 */
public class InputOutputContextTest {

    private InputOutputContext context;
    private File file;
    private OutputStream out;
    private InputStream in;

    @Before
    public void setup() throws IOException {
        file = createTestFile();
        initContext(file);
    }

    @After
    public void teardown() {
        file.delete();
    }

    @Test
    public void shouldWriteAndReadWelcomeMessage() throws IOException {
        String message = "Welcome";
        context.write(message);
        assertEquals(message,context.read());
    }

    private File createTestFile() throws IOException {
        File file = new File("tmp.bin");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private void initContext(File file) throws IOException {
        out = new FileOutputStream(file);
        in = new FileInputStream(file);
        context = new InputOutputContext(in, out);
    }


}