package algomaster.interfaces;

public class JsonFormatter implements Formatter{

    @Override
    public String format(String message) {
        return "{\"log\": \"Server started on port 8080\"}";
    }
    
}
