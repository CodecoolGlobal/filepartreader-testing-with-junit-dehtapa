package com.codecool.ptfilepartner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader filePartReader;
    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader=filePartReader;
    }

    public List getWordsOrderedAlphabetically() {
        String text = filePartReader.readLines();
        List wordList= new ArrayList(Arrays.asList(text.split(" ")));
        Collections.sort(wordList, String.CASE_INSENSITIVE_ORDER);
        return wordList;
    }

    public List getWordsContainingSubstring(String subString) {
        String text = filePartReader.readLines();
        List wordList= new ArrayList(Arrays.asList(text.split(" ")));
        List newList = new ArrayList();
        for (Object word : wordList) {
            if (word.toString().contains(subString) ) {
                newList.add(word.toString());
            }
        }
        return newList;
    }

    public List getStringsWhichPalindromes() {
        String text = filePartReader.readLines();
        List wordList= new ArrayList(Arrays.asList(text.split(" ")));
        List newList = new ArrayList();
        for (Object word : wordList) {
            String reversedWord = new StringBuilder(word.toString()).reverse().toString();
            if (word.toString().equals(reversedWord) &&  (!word.toString().isEmpty() || word.toString() != null)) {
                newList.add(word.toString());
            }
        }
        return newList;
    }

}
