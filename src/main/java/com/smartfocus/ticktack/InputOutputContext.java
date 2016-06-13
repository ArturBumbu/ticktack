package com.smartfocus.ticktack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by arthur on 13/06/16.
 */
public class InputOutputContext {
    private InputStream inputStream;
    private OutputStream outputStream;

    public InputOutputContext(InputStream inputStream,
                              OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;

    }

    public void write(String message) throws IOException {

    }

    public String read() {
        return null;
    }

}
