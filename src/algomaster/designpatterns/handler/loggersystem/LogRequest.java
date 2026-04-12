package algomaster.designpatterns.handler.loggersystem;

public class LogRequest {
    private String content;
    private LogLevel logLevel;

    public LogRequest(String content, LogLevel logLevel) {
        this.content = content;
        this.logLevel = logLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public static void main(String[] args) {
        LogRequest logRequest = new LogRequest("Error Occured", LogLevel.ERROR);
        System.out.println(logRequest.getContent() + " " + logRequest.getLogLevel().getLevel());
    }
}
