package algomaster.designpatterns.ratelimitingproxy;

import java.time.Instant;

public class RateLimitProxy implements APIService{

    private APIService realApiService;
    public static final int MAX_REQUESTS = 3;
    public static final int WINDOW_LENGTH = 10;
    private int currentRequestsCount;
    private Instant firstRequestInstant;


    public RateLimitProxy(APIService realApiService){
        this.realApiService = realApiService;
    }

    @Override
    public String request(String endpoint) {
        String response;
        if(firstRequestInstant == null || Instant.now().isAfter(firstRequestInstant.plusSeconds(WINDOW_LENGTH))){
            //First request or window is refreshed, allow requests irrespective of the count
            currentRequestsCount = 1;
            firstRequestInstant = Instant.now();
            response = realApiService.request(endpoint);
        }else{
            //Existing 10 seconds window is utilised
            if(currentRequestsCount < MAX_REQUESTS){
                response = realApiService.request(endpoint);
                currentRequestsCount++;
            }else{
                response = "Server unavaialble. Please try later.";
            }
        }
        return response;
    }
    
}
