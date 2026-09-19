package algomaster.problems.ratelimiter;

import java.util.HashMap;

public class TokenBucketRateLimtingStrategy implements RateLimitingStrategy {
    public static final long FILL_RATE_PER_SECOND = 1;
    public static final long MAX_TOKENS = 5;
    private HashMap<String, Bucket> userBuckets = new HashMap<>();

    @Override
    public boolean isRequestAllowed(Request request) {
        String userId = request.getUserId();
        Bucket userBucket = userBuckets.get(userId);

        if (userBucket == null) {
            // user's first request, register bucket and allow
            userBucket = new Bucket(MAX_TOKENS, FILL_RATE_PER_SECOND);
            userBuckets.put(userId, userBucket);
        } else {
            // user requested earlier, update tokens
            userBucket.updateBucket();
        }

        long tokens = userBucket.getTokens();
        if (tokens == 0)
            return false;
        userBucket.useToken();
        return true;
    }

}
