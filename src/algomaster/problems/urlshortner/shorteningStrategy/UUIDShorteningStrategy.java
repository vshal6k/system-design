package algomaster.problems.urlshortner.shorteningStrategy;

import java.util.UUID;

public class UUIDShorteningStrategy implements ShorteningStrategy {

    @Override
    public String shorten(String longURL, String alias) {
        if (alias != null)
            return alias;
        else
            return UUID.randomUUID().toString();
    }

}
