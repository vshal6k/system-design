package algomaster.designpatterns.ratelimitingproxy;

public class RealAPIService implements APIService{

    @Override
    public String request(String endpoint) {
        return "Response from " + endpoint;
    }
    
}
