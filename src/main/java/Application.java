import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

public class Application {

    public static void main(String[] args) throws URISyntaxException, IOException {

        URL resource = Application.class.getClassLoader().getResource("input.txt");

        checkNotNull(resource, "Resource should exist!");

        Path path = Paths.get(resource.toURI());

        Stream<String> lines = Files.lines(path);
        EnglishLetterFrequency frequency = new EnglishLetterFrequency(lines.collect(Collectors.joining("\n")));
        lines.close();

        System.out.println("English letter frequency:\n" + new PrettyPrintFrequencyMap<>(frequency.getFrequency()) + "\n");
    }
}
