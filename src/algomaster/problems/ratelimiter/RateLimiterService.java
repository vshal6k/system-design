package algomaster.problems.ratelimiter;

public class RateLimiterService {
    private static final RateLimiterService INSTANCE = new RateLimiterService();

    private RateLimiterService() {
    };

    private RateLimitingStrategy rateLimitingStrategy = new TokenBucketRateLimtingStrategy();

    public static RateLimiterService getInstance() {
        return INSTANCE;
    }

    public RateLimitingStrategy getRateLimitingStrategy() {
        return rateLimitingStrategy;
    }

    public void setRateLimitingStrategy(RateLimitingStrategy rateLimitingStrategy) {
        this.rateLimitingStrategy = rateLimitingStrategy;
    }

    public boolean handleRequest(Request request){
        return rateLimitingStrategy.isRequestAllowed(request);
    }

}
