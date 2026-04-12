package algomaster.designpatterns.handler.loggersystem;

public class DebugLogger extends AbstractLogger{

    @Override
    public void handle(LogRequest logRequest) {
        if(logRequest.getLogLevel().getLevel() >= 1 ){
            System.out.println("[DEBUG]: " + logRequest.getContent());
            forward(logRequest);
        }
    }
    
}
