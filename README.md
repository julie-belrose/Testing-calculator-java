# Exercice Java Test #1 - Bases du testing

## Objectifs

Appréhender le fonctionnement de JUnit et de l'écriture de tests unitaires dans un projet Java Maven classique

## Sujet

Via l'utilisation de Maven et de JUnit 5, réaliser le testing de la classe suivantes :

```java
// Calculator.java

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) throws ArithmeticException {
        return a / b;
    }
}
```

## Next

# Exercice Java Test #2 - Bases du mocking

## Objectifs

Appréhender le fonctionnement de Mockito et de l'écriture de tests unitaires dans un projet Java Maven classique dont les classes possèdent des dépendances

## Sujet

Via l'utilisation de Maven, de JUnit 5 et de Mockito, réaliser le testing et l'implémentation des classes suivantes:

```java
// Hangman.java

public class Hangman {
    private final String wordToGuess;
    private final Set<Character> guessedLetters;
    private int remainingAttempts;

    public Hangman(WordGenerator wordGenerator, int maxAttempts) {
        // ...
    }

    public boolean guess(char letter) {
        // ...
    }

    public String getMaskedWord() {
        // ...
    }

    public boolean isGameWon() {
        // ...
    }

    public boolean isGameOver() {
        // ...
    }

    public int getRemainingAttempts() {
        // ...
    }
}
```

```java
// WordGenerator.class

public class WordGenerator {
    private final List<String> words;
    private final Random random;

    public WordGenerator() {
        // ...
    }

    public String getRandomWord() {
        // ...
    }

    public String getWord(int index) {
        // ...
    }
}
```