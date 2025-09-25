import org.example.WordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordGeneratorTest {

    private WordGenerator wordGenerator;
    String wordToGuess = "lapin";

    @BeforeEach
    void setUp() {
        wordGenerator = Mockito.mock(WordGenerator.class);
        private List<String> words = Mockito.mock(WordGenerator.words);
    }

    //private Array<String> wordToGuess = ["bnj", "n mm"];

    @Test
    @DisplayName("should_return_random_word_to_guess")
    void should_return_random_word_to_guess() {
        // Act
        String result = String.valueOf(Integer.parseInt(wordGenerator.getRandomWord(wordToGuess)));

        // Assert
        assertEquals("lapin", result);
    }

    @Test
    @DisplayName("shoul_compare_index_world_to_wordToguess")
    void shoul_compare_index_world_to_wordToguess() {

        int result = wordGenerator.getWord(String.valueOf(words[1]));

        assertEquals(1, result);

    }

}
