package algomaster;

public class Logger {
    private Formatter formatter;

    public Logger(Formatter formatter) {
        this.formatter = formatter;
    }

    public void log(String message) {
        System.out.println(formatter.format(message));
    }

    public static void main(String[] args) {
        Logger plainLogger = new Logger(new PlainFormatter());
        plainLogger.log("Server started on port 8080");

        Logger jsonLogger = new Logger(new JsonFormatter());
        jsonLogger.log("Server started on port 8080");
    }

}
