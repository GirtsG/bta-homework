import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.math.RoundingMode.HALF_UP;
import static java.util.stream.Collectors.toMap;

public class EnglishLetterFrequency {

    private final String text;

    public EnglishLetterFrequency(String text) {
        this.text = text;
    }

    public Map<Character, BigDecimal> getFrequency() {
        Map<Character, Long> letterCount = getLetterCount();
        BigDecimal valuesSum = BigDecimal.valueOf(letterCount.values().stream().reduce(0L, Long::sum));
        return letterCount
                .entrySet()
                .stream()
                .collect(
                        toMap(
                                Map.Entry::getKey,
                                e -> BigDecimal.valueOf(e.getValue())
                                        .multiply(BigDecimal.valueOf(100))
                                        .divide(valuesSum, 2, HALF_UP)
                                ,
                                (u, v) -> {
                                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                                },
                                LinkedHashMap::new
                        )
                );
    }

    private Map<Character, Long> getLetterCount() {
        return IntStream.rangeClosed('a', 'z').mapToObj(c -> (char) c)
                .collect(
                        toMap(
                                Function.identity(),
                                c -> this.text.chars().filter(ch -> Character.toLowerCase(ch) == c).count(),
                                (u, v) -> {
                                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                                },
                                LinkedHashMap::new
                        )
                );
    }
}
