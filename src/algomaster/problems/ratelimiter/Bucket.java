package algomaster.problems.ratelimiter;

import java.time.Duration;
import java.time.Instant;

public class Bucket {
    private long tokens;
    private Instant timeStamp;
    private long maxTokens;
    private long fillRatePerSecond;

    public Bucket(long maxTokens, long fillRatePerSecond) {
        this.maxTokens = maxTokens;
        this.tokens = maxTokens;
        this.fillRatePerSecond = fillRatePerSecond;
        this.timeStamp = Instant.now();
    }

    public long getTokens() {
        return tokens;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public long getMaxTokens() {
        return maxTokens;
    }

    public void updateBucket() {
        Instant currentInstant = Instant.now();
        Instant lastInstant = this.timeStamp;

        long timeElapsedInSeconds = Duration.between(lastInstant, currentInstant).getSeconds();
        this.tokens = Math.min(this.maxTokens, timeElapsedInSeconds * fillRatePerSecond + this.tokens);
        this.timeStamp = currentInstant;
    }

    public long getFillRatePerSecond() {
        return fillRatePerSecond;
    }

    public void useToken() {
        tokens--;
    }

}
