package algomaster.problems.ratelimiter;

import java.time.Instant;

public class Request {
    private String requestId;
    private String userId;
    private Instant createdAt;

    public Request(String requestId, String userId) {
        this.requestId = requestId;
        this.userId = userId;
        this.createdAt = Instant.now();
    }

    public String getRequestId() {
        return requestId;
    }

    public String getUserId() {
        return userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

}
