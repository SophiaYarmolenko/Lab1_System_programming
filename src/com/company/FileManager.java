package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FileManager {

    private final StringAnalyzer stringAnalyzer = new StringAnalyzer();

    public Set<String> readAndAnalyzeFile(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            List<String> results = new LinkedList<>();
            String data = reader.readLine();
            while (data != null) {
                if (!data.isBlank()) {
                    results.add(data);
                }
                data = reader.readLine();
            }
            return this.stringAnalyzer.getSortedWordSet(results);
        } catch (IOException e) {
            throw new RuntimeException("Problems with reading file : ", e);
        }
    }

    public void writeResultsToFile(Set<String> results, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String each : results) {
                writer.write(each + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Problems with writing file : ", e);
        }
    }

}