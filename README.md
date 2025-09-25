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