package algomaster.problems.urlshortner.shorteningStrategy;

import java.util.concurrent.atomic.AtomicLong;

public class Base62ShorteningStrategy implements ShorteningStrategy {
    private static final String BASE62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final AtomicLong counter;

    public Base62ShorteningStrategy() {
        this(1);
    }

    public Base62ShorteningStrategy(long startValue) {
        if (startValue < 0)
            throw new IllegalArgumentException("Start value cannot be negative.");

        this.counter = new AtomicLong(startValue);
    }

    @Override
    public String shorten(String longURL) {
        return encode(counter.getAndIncrement());
    }

    private String encode(long number) {
        if (number == 0)
            return String.valueOf(BASE62_CHARS.charAt(0));

        StringBuilder shortURL = new StringBuilder();
        while (number > 0) {
            int index = (int) (number % BASE62_CHARS.length());
            shortURL.append(BASE62_CHARS.charAt(index));
            number = number / BASE62_CHARS.length();
        }

        return shortURL.reverse().toString();
    }
}
