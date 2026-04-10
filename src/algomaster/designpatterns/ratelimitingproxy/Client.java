package algomaster.designpatterns.ratelimitingproxy;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        APIService realAPIService = new RealAPIService();
        APIService rateLimitingProxy = new RateLimitProxy(realAPIService);

        System.out.println(rateLimitingProxy.request("/google"));
        Thread.sleep(11000);
        System.out.println(rateLimitingProxy.request("/google"));
        System.out.println(rateLimitingProxy.request("/google"));
        System.out.println(rateLimitingProxy.request("/google"));

    }
}
