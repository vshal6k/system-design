package algomaster.problems.urlshortner;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.urlshortner.entities.ShortURL;
import algomaster.problems.urlshortner.shorteningStrategy.ShorteningStrategy;

public class URLShortner {
    private static final int MAX_SHORT_URL_GENERATION_ATTEMPTS = 5;

    private final ShorteningStrategy shorteningStrategy;
    private final Map<String, ShortURL> shortURLMap = new ConcurrentHashMap<>();
    private final Map<String, ShortURL> longURLMap = new ConcurrentHashMap<>();

    public URLShortner(ShorteningStrategy shorteningStrategy) {
        this.shorteningStrategy = shorteningStrategy;
    }

    private void removeShortURLIfExpired(ShortURL shortURL) {
        if (shortURL != null && shortURL.isExpired()) {
            shortURLMap.remove(shortURL.getShortURLString());
            longURLMap.remove(shortURL.getLongURLString(), shortURL);
        }
    }

    private void validateAlias(String alias) {
        if (alias != null) {
            ShortURL existingShortURL = shortURLMap.get(alias);
            removeShortURLIfExpired(existingShortURL);
            if (shortURLMap.containsKey(alias)) {
                throw new IllegalArgumentException("Alias is already in use. Please choose another alias.");
            }
        }
    }

    private String generateUniqueShortURL(String longURLString) {
        for (int attempt = 0; attempt < MAX_SHORT_URL_GENERATION_ATTEMPTS; attempt++) {
            String shortURLString = shorteningStrategy.shorten(longURLString);
            if (shortURLString == null)
                throw new IllegalStateException("Shortening strategy generated a null short URL.");

            ShortURL existingShortURL = shortURLMap.get(shortURLString);
            removeShortURLIfExpired(existingShortURL);
            if (!shortURLMap.containsKey(shortURLString))
                return shortURLString;
        }

        throw new IllegalStateException("Could not generate a unique short URL. Please retry.");
    }

    public synchronized String getShortURL(String longURLString, String alias, LocalDate expiryDate) {
        if (longURLString == null)
            throw new IllegalArgumentException("Long URL cannot be null.");

        ShortURL existingShortURL = longURLMap.get(longURLString);
        removeShortURLIfExpired(existingShortURL);
        existingShortURL = longURLMap.get(longURLString);
        if (existingShortURL != null) {
            if (alias != null && !alias.equals(existingShortURL.getShortURLString()))
                throw new IllegalArgumentException("Long URL already has an active short URL.");
            return existingShortURL.getShortURLString();
        }

        validateAlias(alias);

        String shortURLString = (alias != null) ? alias : generateUniqueShortURL(longURLString);

        ShortURL shortURL = new ShortURL.ShortURLBuilder(shortURLString, longURLString)
                .alias(alias)
                .expiryDate(expiryDate)
                .build();

        shortURLMap.put(shortURLString, shortURL);
        longURLMap.put(longURLString, shortURL);

        return shortURLString;

    }

    public synchronized String getLongURLUsingShortURL(String shortURLString) {
        if (shortURLString == null)
            throw new IllegalArgumentException("Short url cannot be null.");

        ShortURL shortURL = shortURLMap.get(shortURLString);

        removeShortURLIfExpired(shortURL);

        if (shortURL == null || shortURL.isExpired())
            throw new IllegalArgumentException("Long URL does not exist");

        shortURL.incrementTimesClicked();

        return shortURL.getLongURLString();

    }

    public synchronized String getShortURLUsingLongURL(String longURLString) {
        if (longURLString == null)
            throw new IllegalArgumentException("Long URL cannot be null.");

        ShortURL shortURL = longURLMap.get(longURLString);
        removeShortURLIfExpired(shortURL);

        if (shortURL == null || shortURL.isExpired())
            throw new IllegalArgumentException("Short URL does not exist");

        return shortURL.getShortURLString();
    }

    public synchronized int getVisitCount(String shortURLString) {
        if (shortURLString == null)
            throw new IllegalArgumentException("Short url cannot be null.");

        ShortURL shortURL = shortURLMap.get(shortURLString);
        removeShortURLIfExpired(shortURL);

        if (shortURL == null || shortURL.isExpired())
            throw new IllegalArgumentException("Short url not found");

        return shortURL.getTimesClicked();
    }
}
