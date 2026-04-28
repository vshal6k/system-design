package algomaster.problems.urlshortner.shorteningStrategy;

import java.util.UUID;

public class UUIDShorteningStrategy implements ShorteningStrategy {

    @Override
    public String shorten(String longURL) {
        return UUID.randomUUID().toString();
    }

}
