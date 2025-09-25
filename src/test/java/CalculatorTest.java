import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private int valueStartA = 1;
    private int valueStartB = 3;

    @Test
    @DisplayName("should_return_an_addition")
    void should_return_an_addition() {
        Calculator calculator = new Calculator();

        int result = calculator.add(valueStartA, valueStartB);

        assertEquals(4, result);
    }

    @Test
    @DisplayName("should_return_a_subtraction")
    void should_return_a_subtraction() {
        Calculator calculator = new Calculator();

        int result = calculator.sub(valueStartA, valueStartB);

        assertEquals(-2, result);
    }
}
