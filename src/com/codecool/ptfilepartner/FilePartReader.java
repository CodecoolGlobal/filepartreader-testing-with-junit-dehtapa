package com.codecool.ptfilepartner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        this.filePath = "/maci";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public String read() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public String readLines() {
        String text = read();
        String[] parts = text.split("\n");
        StringBuilder newText = new StringBuilder();
        for (int i = fromLine - 1; i < parts.length; i++) {
             if (i > toLine - 1) break;
            if (i != fromLine - 1)  newText.append("\n");
                newText.append(parts[i]);
        }
        return newText.toString();
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1) {
            throw new IllegalArgumentException("From line must be greater than 1.");
        }
        if (toLine < fromLine) {
            throw new IllegalArgumentException("To line must greater than from line.");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }
}
