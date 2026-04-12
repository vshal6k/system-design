package algomaster.designpatterns.handler.loggersystem;

public class WarnLogger extends AbstractLogger{

    @Override
    public void handle(LogRequest logRequest) {
        if(logRequest.getLogLevel().getLevel() >= 3 ){
            System.out.println("[WARN]: " + logRequest.getContent());
            forward(logRequest);
        }
    }
    
}
