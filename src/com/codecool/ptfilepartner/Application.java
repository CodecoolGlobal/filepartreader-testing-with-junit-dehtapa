package com.codecool.ptfilepartner;

public class Application {
    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/file.txt", 3, 13000);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        fileWordAnalyzer.getWordsOrderedAlphabetically();
        fileWordAnalyzer.getStringsWhichPalindromes();
    }
}
