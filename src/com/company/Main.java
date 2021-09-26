package com.company;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Set<String> results = fileManager.readAndAnalyzeFile("sample3.txt");
        fileManager.writeResultsToFile(results, "result.txt");
    }
}
