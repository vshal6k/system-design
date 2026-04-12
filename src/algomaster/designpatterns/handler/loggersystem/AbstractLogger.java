package algomaster.designpatterns.handler.loggersystem;

public abstract class AbstractLogger implements LogHandler{
    private LogHandler logHandler;

    @Override
    public void setNext(LogHandler Logger){
        this.logHandler = Logger;
    }

    public void forward(LogRequest logRequest){
        if(logHandler != null){
            logHandler.handle(logRequest);
        }
    }
}
