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

    public void write(String message) {
        try {
            outputStream.write(message.getBytes());
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(byte message) {
        try {
            outputStream.write(message);
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read() {
        String line = null;
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line != null) {
                break;
            }
        }
        return line;
    }

    @Override
    protected void finalize() throws Throwable {
        if (inputStream != null) {
            inputStream.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
    }

}
