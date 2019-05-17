package com.codecool.ptfilepartner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {
    public void setup(String filePath, Integer fromLine, Integer toLine) {
    }

    public String read() {
        BufferedReader in = null;
        String s;
        StringBuilder sb = new StringBuilder(); // use a StringBuilder if you are doing lot of string manipulation
        try {
            in = new BufferedReader(new FileReader(filePath));
            while ((s = in.readLine()) != null)
                sb.append(s + "\n");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String readLines() {
        return null;
    }
}
