package algomaster.designpatterns.handler.loggersystem;

public class Logger {

    private DebugLogger debugLogger = new DebugLogger();
    private InfoLogger infoLogger = new InfoLogger();
    private WarnLogger warnLogger = new WarnLogger();
    private ErrorLogger errorLogger = new ErrorLogger();

    public Logger() {
        debugLogger.setNext(infoLogger);
        infoLogger.setNext(warnLogger);
        warnLogger.setNext(errorLogger);
    }

    public void log(LogRequest logRequest) {
        debugLogger.handle(logRequest);
    }
    
}
