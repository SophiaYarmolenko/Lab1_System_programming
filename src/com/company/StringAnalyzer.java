package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class StringAnalyzer {

    public Set<String> getSortedWordSet(List<String> data) {
        List<String> allWords = new LinkedList<>();
        for (String each : data) {
            for (String word : each.split("[\\s(),.!?:;@|-]+")) {
                allWords.add(refactorWord(word));
            }
        }
        return allWords.stream()
                .sorted(Comparator.comparingInt(this::consonantalCharNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private int consonantalCharNumber(String string) {
        int counter = 0;
        for (char letter : string.toLowerCase().toCharArray()) {
            if (isConsonantal(letter)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isConsonantal(char letter) {
        switch (letter) {
            case 'e':
            case 'u':
            case 'i':
            case 'o':
            case 'a':
                return false;
            default:
                return true;
        }
    }

    private String refactorWord(String word) {
        return word.length() > 30 ? word.substring(0, 30) : word;
    }

}
