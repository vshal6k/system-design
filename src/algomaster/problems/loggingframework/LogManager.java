package algomaster.problems.loggingframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogManager {
    private final Map<String, Logger> loggers = new ConcurrentHashMap<>();
    private final Logger rootLogger;
    private final AsyncLogProcessor processor;

    public LogManager() {
        this.rootLogger = new Logger("root", null);
        this.loggers.put("root", rootLogger);
        this.processor = new AsyncLogProcessor();
    }

    public Logger getLogger(String name) {
        return this.loggers.computeIfAbsent(name, this::createLogger);
    }

    public Logger createLogger(String name) {
        if (loggers.containsKey(name))
            return this.loggers.get(name);

        int lastDot = name.lastIndexOf('.');
        String parentName = (lastDot == -1) ? "root" : name.substring(0, lastDot);
        Logger parent = getLogger(parentName);
        return new Logger(name, parent);
    }

    public Logger getRootLogger() {
        return rootLogger;
    }

    AsyncLogProcessor getProcessor() {
        return processor;
    }

    public void shutdown() {
        // Stop the processor first to ensure all logs are written.
        processor.stop();

        // Then, close all appenders.
        loggers.values().stream()
                .flatMap(logger -> logger.getAppenders().stream())
                .distinct()
                .forEach(appender -> appender.close());

        System.out.println("Logging framework shut down gracefully.");
    }

}
