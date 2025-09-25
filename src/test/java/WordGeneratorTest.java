import org.example.WordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordGeneratorTest {

    private WordGenerator wordGenerator;
    String wordToGuess = "lapin";
    private final List<String> expectedWords = List.of("chat", "lapin", "poule");

    @BeforeEach
    void setUp() {
        wordGenerator = new WordGenerator();
    }

    @Test
    @DisplayName("should_return_random_word_to_guess")
    void should_return_random_word_to_guess() {
        // Act
        String result = wordGenerator.getRandomWord(wordToGuess);

        // Assert
        assertNotNull(result);
        assertTrue(expectedWords.contains(result));
    }

    @Test
    @DisplayName("should_get_word_by_index")
    void should_get_word_by_index() {
        // Act
        String result = wordGenerator.getWord(1);

        // Assert
        assertEquals("lapin", result);
    }

}
