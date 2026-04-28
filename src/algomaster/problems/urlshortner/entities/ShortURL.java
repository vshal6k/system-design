package algomaster.problems.urlshortner.entities;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortURL {
    private final String alias;
    private final String shortURLString;
    private final String longURLString;
    private final LocalDate expiryDate;
    private AtomicInteger timesClicked;

    private ShortURL(ShortURLBuilder shortURLBuilder) {
        this.shortURLString = shortURLBuilder.shortURLString;
        this.alias = shortURLBuilder.alias;
        this.expiryDate = shortURLBuilder.expiryDate;
        this.longURLString = shortURLBuilder.longURLString;
        this.timesClicked = new AtomicInteger(0);
    }

    public String getLongURLString() {
        return longURLString;
    }

    public int getTimesClicked() {
        return timesClicked.intValue();
    }

    public String getShortURLString() {
        return shortURLString;
    }

    public String getAlias() {
        return alias;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return (expiryDate != null && LocalDate.now().isAfter(expiryDate)) ? true : false;
    }

    public int incrementTimesClicked() {
        return this.timesClicked.addAndGet(1);
    }

    public static class ShortURLBuilder {
        private String alias;
        private String shortURLString;
        private String longURLString;
        private LocalDate expiryDate;

        public ShortURLBuilder(String shortURLString, String longURLString) {
            this.shortURLString = shortURLString;
            this.longURLString = longURLString;
        }

        public ShortURLBuilder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public ShortURLBuilder expiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public ShortURL build() {
            if (shortURLString == null)
                throw new IllegalArgumentException("Short URL cannot be null.");
            if (longURLString == null)
                throw new IllegalArgumentException("Long URL cannot be null.");

            return new ShortURL(this);
        }

    }

}
