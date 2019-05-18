package com.codecool.ptfilepartner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    @Test
    public void testIsIllegalSetup () {
        FilePartReader filePartReader = new FilePartReader();
        System.out.println("Throw error message if from line bigger than to line");
        assertThrows(IllegalArgumentException.class, () -> {filePartReader.setup("file.txt",6,5);});
        System.out.println("Throw error message if from line smaller than 1");
        assertThrows(IllegalArgumentException.class, () -> {filePartReader.setup("file.txt",-1,5);});
    }
    @Test
    public void testIsFileReadIsWorking () {
        FilePartReader filePartReader = new FilePartReader();
        System.out.println("Read from file gives a string as result");
        filePartReader.setup("resources/file.txt", 1, 1);
        assertNotNull(filePartReader.read());
    }
    @Test
    public void testIsFileReadLinesIsWorking () {
        System.out.println("Read from file with lines gives proper result");
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/file.txt", 3, 5);
        String text = "  The quarrel between Agamemnon and Achilles - Achilles withdraws\n" +
                "  from the war, and sends his mother Thetis to ask Jove to help\n" +
                "  the Trojans - Scene between Jove and Juno on Olympus.";
        assertEquals(text, filePartReader.readLines());
    }

}