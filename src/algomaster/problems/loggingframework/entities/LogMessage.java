package algomaster.problems.loggingframework.entities;

import java.time.LocalDateTime;

import algomaster.designpatterns.handler.loggersystem.LogLevel;

public class LogMessage {
    private final LocalDateTime timeStamp;
    private final LogLevel level;
    private final String loggerName;
    private final String threadName;
    private final String message;

    public LogMessage(LogLevel level, String loggerName, String message) {
        this.level = level;
        this.loggerName = loggerName;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
        this.threadName = Thread.currentThread().getName();
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getMessage() {
        return message;
    }
}
