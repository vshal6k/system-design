package algomaster.designpatterns.handler.loggersystem;

public class InfoLogger extends AbstractLogger{

    @Override
    public void handle(LogRequest logRequest) {
        if(logRequest.getLogLevel().getLevel() >= 2 ){
            System.out.println("[INFO]: " + logRequest.getContent());
            forward(logRequest);
        }
    }
    
}
