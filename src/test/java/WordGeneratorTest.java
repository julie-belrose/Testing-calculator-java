import org.example.WordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;

public class WordGeneratorTest {

    private WordGenerator wordGenerator;
    String wordToGuess = "lapin";

    @BeforeEach
    void setUp() {
        wordGenerator = Mockito.mock(WordGenerator.class);
    }

    //private Array<String> wordToGuess = ["bnj", "n mm"];

    @Test
    @DisplayName("should_return_random_word_to_guess")
    void should_return_random_word_to_guess() {
        // Arrange
        Mockito.when(wordGenerator.getRandomWord(wordToGuess)).thenReturn("lapin");

        // Act
        String result = wordGenerator.getRandomWord(wordToGuess);

        // Assert
        assertEquals("lapin", result);
    }

    @Test
    @DisplayName("should_get_word_by_index")
    void should_get_word_by_index() {
        // Arrange
        Mockito.when(wordGenerator.getWord(1)).thenReturn("lapin");

        // Act
        String result = wordGenerator.getWord(1);

        // Assert
        assertEquals("lapin", result);
    }

}
