import org.example.Hangman;
import org.example.WordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {

    private Hangman hangman;
    private WordGenerator mockWordGenerator;

    @BeforeEach
    void setUp() {
        mockWordGenerator = Mockito.mock(WordGenerator.class);
        Mockito.when(mockWordGenerator.getRandomWord()).thenReturn("chat");
        hangman = new Hangman(mockWordGenerator, 6);
    }

    @Test
    @DisplayName("should_guess_correct_letter")
    void should_guess_correct_letter() {
        assertTrue(hangman.guess('c'));
    }

    @Test
    @DisplayName("should_guess_wrong_letter")
    void should_guess_wrong_letter() {
        assertFalse(hangman.guess('x'));
    }

    @Test
    @DisplayName("should_win_game")
    void should_win_game() {
        hangman.guess('c');
        hangman.guess('h');
        hangman.guess('a');
        hangman.guess('t');

        assertTrue(hangman.isGameWon());
    }

    @Test
    @DisplayName("should_lose_game")
    void should_lose_game() {
        for (int i = 0; i < 6; i++) {
            hangman.guess('x');
        }

        assertTrue(hangman.isGameOver());
    }

    @Test
    @DisplayName("should_return_masked_word")
    void should_return_masked_word() {
        assertEquals("____", hangman.getMaskedWord());

        hangman.guess('c');
        assertEquals("c___", hangman.getMaskedWord());
    }

    @Test
    @DisplayName("should_track_remaining_attempts")
    void should_track_remaining_attempts() {
        assertEquals(6, hangman.getRemainingAttempts());

        hangman.guess('x');
        assertEquals(5, hangman.getRemainingAttempts());
    }
}