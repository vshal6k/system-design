package algomaster.problems.ratelimiter;

public interface RateLimitingStrategy {
    public boolean isRequestAllowed(Request request);
}
