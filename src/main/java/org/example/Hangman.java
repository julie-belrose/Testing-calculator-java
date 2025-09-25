package org.example;

import java.util.Set;

public class Hangman {
    private final String wordToGuess = "";
    private final Set<Character> guessedLetters = Set.of();
    private int remainingAttempts = 6;

    public Hangman(WordGenerator wordGenerator, int maxAttempts) {
        // ...
        remainingAttempts = maxAttempts;
    }

    public boolean guess(char letter) {
        // ...
        return false;
    }

    public String getMaskedWord() {
        // ...
        return "";
    }

    public boolean isGameWon() {
        // ...
        return false;
    }

    public boolean isGameOver() {
        // ...
        return false;
    }

    public int getRemainingAttempts() {
        // ...
        return 0;
    }
}