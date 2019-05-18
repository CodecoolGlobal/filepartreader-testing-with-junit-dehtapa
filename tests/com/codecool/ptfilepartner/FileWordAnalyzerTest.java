package com.codecool.ptfilepartner;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    @Test
    public void testIsAlphabeticOrder () {
        System.out.println("Throw error message if from line bigger than to line");
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/file.txt", 3, 5);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List listToTest = fileWordAnalyzer.getWordsOrderedAlphabetically();
        for (int i = 1; i < listToTest.size() - 1; i++) {
            int finalI = i;
            String previousWord = (String) listToTest.get(i-1);
            String word = (String) listToTest.get(i);
            String nextWord = (String) listToTest.get(i+1);
            assertAll("test alphabetic order",
                    () -> assertTrue(previousWord.toLowerCase().compareTo(word.toLowerCase()) <= 0),
                    () -> assertTrue(nextWord.toLowerCase().compareTo(word.toLowerCase()) >= 0)
            );
        }

    }
    @Test
    public void testIsContainsSubtring () {
        System.out.println("Can find substrings in words");
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/file.txt", 1, 13364);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List listToTest = fileWordAnalyzer.getWordsContainingSubstring("ach");
        assertEquals(263, listToTest.size());
    }
    @Test
    public void testIsPalindromCheck () {
        System.out.println("Palindrom selection test");
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/file.txt", 1, 13364);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List listToTest = fileWordAnalyzer.getStringsWhichPalindromes();
        for ( Object word: listToTest) {
            String reversedWord = new StringBuilder(word.toString()).reverse().toString();
            assertEquals(reversedWord, word.toString());
        }
    }

}