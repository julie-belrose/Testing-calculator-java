package org.example;

import java.util.List;
import java.util.Random;

public class WordGenerator {
    private final List<String> words;
    private final Random random;

    public WordGenerator() {
        this.words = List.of("chat", "lapin", "poule");
        this.random = new Random();
    }

    public String getRandomWord(String wordToGuess) {
        // ...
        return null;
    }

    public String getWord(int index) {
        // ...
        return "0";
    }
}
