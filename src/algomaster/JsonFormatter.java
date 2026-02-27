package algomaster;

public class JsonFormatter implements Formatter{

    @Override
    public String format(String message) {
        return "{\"log\": \"Server started on port 8080\"}";
    }
    
}
