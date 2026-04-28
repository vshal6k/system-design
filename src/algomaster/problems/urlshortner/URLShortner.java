package algomaster.problems.urlshortner;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.urlshortner.entities.ShortURL;
import algomaster.problems.urlshortner.shorteningStrategy.ShorteningStrategy;

public class URLShortner {
    private static volatile URLShortner INSTANCE;
    private final ShorteningStrategy shorteningStrategy;
    private final Map<String, ShortURL> aliasURLMap = new ConcurrentHashMap<>();
    private final Map<String, ShortURL> shortURLMap = new ConcurrentHashMap<>();

    private URLShortner(ShorteningStrategy shorteningStrategy) {
        this.shorteningStrategy = shorteningStrategy;
    };

    public static URLShortner getInstance(ShorteningStrategy shorteningStrategy) {
        if (INSTANCE == null) {
            synchronized (URLShortner.class) {
                if (INSTANCE == null)
                    INSTANCE = new URLShortner(shorteningStrategy);
            }
        }
        return INSTANCE;
    }

    private void removeShortURLIfExpired(ShortURL shortURL) {
        if (shortURL != null && shortURL.isExpired()) {
            shortURLMap.remove(shortURL.getShortURLString());
            aliasURLMap.remove(shortURL.getAlias());
        }
    }

    private void validateAlias(String alias) {
        if (alias != null) {
            ShortURL existingShortURL = aliasURLMap.get(alias);
            if (existingShortURL != null && !existingShortURL.isExpired()) {
                throw new IllegalArgumentException("Alias is already in use. Please choose another alias.");
            }
        }
    }

    public String getShortURL(String longURLString, String alias, LocalDate expiryDate) {
        if (longURLString == null)
            throw new IllegalArgumentException("Long URL cannot be null.");

        validateAlias(alias);

        if (alias != null)
            removeShortURLIfExpired(aliasURLMap.get(alias));

        String shortURLString = (alias != null) ? alias : shorteningStrategy.shorten(longURLString);

        ShortURL shortURL = new ShortURL.ShortURLBuilder(shortURLString, longURLString)
                .alias(alias)
                .expiryDate(expiryDate)
                .build();

        shortURLMap.put(shortURLString, shortURL);

        return shortURLString;

    }

    public String getLongURLUsingShortURL(String shortURLString) {
        if (shortURLString == null)
            throw new IllegalArgumentException("Short url cannot be null.");

        ShortURL shortURL = shortURLMap.get(shortURLString);

        removeShortURLIfExpired(shortURL);

        if (shortURL == null || shortURL.isExpired())
            throw new IllegalArgumentException("Long URL does not exist");

        shortURL.incrementTimesClicked();

        return shortURL.getLongURLString();

    }
}
