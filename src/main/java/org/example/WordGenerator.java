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
//        int randomIndex = random.nextInt(words.size());
//        return words.get(randomIndex);
        return null;
    }

    public String getWord(int index) {
//        if (index < 0 || index >= words.size()) {
//            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
//        }
//        return words.get(index);

        return "0";
    }
}
