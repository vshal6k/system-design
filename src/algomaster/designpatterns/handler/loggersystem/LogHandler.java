package algomaster.designpatterns.handler.loggersystem;

public interface LogHandler {
    public void setNext(LogHandler handler);
    public void handle(LogRequest logRequest);
}
