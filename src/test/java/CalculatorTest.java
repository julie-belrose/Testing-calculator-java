import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("should_return_an_addition")
    void should_return_an_addition() {
        Calculator calculator = new Calculator();

        int result = calculator.add(1, 3);

        assertEquals(4, result);
    }
}
