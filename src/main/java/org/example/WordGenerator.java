package org.example;

import java.util.List;
import java.util.Random;

public class WordGenerator {
    private final List<String> words;
    private final Random random = new Random();

    public WordGenerator() {
        this.words = List.of("chat", "lapin", "poule");
    }

    public String getRandomWord() {
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);

    }

    public String getWord(int index) {
        if (index < 0 || index >= words.size()) {
          throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
       return words.get(index);
    }
}
