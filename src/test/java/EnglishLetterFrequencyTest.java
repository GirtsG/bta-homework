import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EnglishLetterFrequencyTest {

    private static final String text = "  It wAs not very easy to persuade Miss Leatheran " +
            "to undertake this tAsk—in fact, persuading her was one of the hardest jobs \n" +
            "of my professional career—and even After it was completed she displayed a \t" +
            "curious reluctance to let me see the mAnuscript.  ";

    @Test
    public void testGetLetterFrequency_isNotNull() {
        EnglishLetterFrequency englishLetterFrequency = new EnglishLetterFrequency(text);

        assertNotNull(englishLetterFrequency.getFrequency(), "EnglishLetterFrequency.getFrequency() cannot be null for given text.");
    }

    @Test
    public void testGetLetterFrequency_isCorrect() {
        EnglishLetterFrequency englishLetterFrequency = new EnglishLetterFrequency(text);
        Map<Character, BigDecimal> frequencyMap = englishLetterFrequency.getFrequency();


        assertEquals(BigDecimal.valueOf(0.0d).setScale(2), frequencyMap.get('q'));
        assertEquals(BigDecimal.valueOf(3d).setScale(2), frequencyMap.get('l'));
        assertEquals(BigDecimal.valueOf(10d).setScale(2), frequencyMap.get('a'));
        assertEquals(BigDecimal.valueOf(9.5d).setScale(2), frequencyMap.get('s'));
    }
}