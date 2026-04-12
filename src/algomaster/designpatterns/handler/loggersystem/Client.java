package algomaster.designpatterns.handler.loggersystem;

public class Client {
    public static void main(String[] args) {
        Logger myLogger = new Logger();
        // myLogger.log(new LogRequest("Hello World!", LogLevel.DEBUG));

        // myLogger.log(new LogRequest("Hello World!", LogLevel.INFO));

        // myLogger.log(new LogRequest("Hello World!", LogLevel.WARN));

        myLogger.log(new LogRequest("Hello World!", LogLevel.ERROR));
    }
}
