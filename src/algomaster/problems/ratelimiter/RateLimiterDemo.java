package algomaster.problems.ratelimiter;

import java.time.Duration;

public class RateLimiterDemo {
    
    public static void main(String[] args) throws InterruptedException {
        RateLimiterService ratelimiterService = RateLimiterService.getInstance();
        ratelimiterService.setRateLimitingStrategy(new FixedWindowRateLimitingStrategy());
        System.out.println(ratelimiterService.handleRequest(new Request("1", "viskushw")));
        System.out.println(ratelimiterService.handleRequest(new Request("1", "viskushw")));
        System.out.println(ratelimiterService.handleRequest(new Request("1", "viskushw")));
        System.out.println(ratelimiterService.handleRequest(new Request("1", "viskushw")));
        System.out.println(ratelimiterService.handleRequest(new Request("1", "viskushw")));
        Thread.sleep(Duration.ofSeconds(5));
        System.out.println(ratelimiterService.handleRequest(new Request("1", "viskushw"))); 
        System.out.println(ratelimiterService.handleRequest(new Request("1", "viskushw"))); 
    }
}
