package algomaster.designpatterns.handler.loggersystem;

public class ErrorLogger extends AbstractLogger{

    @Override
    public void handle(LogRequest logRequest) {
        if(logRequest.getLogLevel().getLevel() >= 4 ){
            System.out.println("[ERROR]: " + logRequest.getContent());
            forward(logRequest);
        }
    }
    
}
