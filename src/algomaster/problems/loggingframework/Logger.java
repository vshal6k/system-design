package algomaster.problems.loggingframework;

import java.util.ArrayList;
import java.util.List;

import algomaster.designpatterns.handler.loggersystem.LogLevel;
import algomaster.problems.loggingframework.entities.LogMessage;
import algomaster.problems.loggingframework.strategy.appender.LogAppender;

public class Logger {
    private final String name;
    private LogLevel level;
    private final Logger parent;
    private final List<LogAppender> appenders;
    private final LogManager logManager;

    public Logger(String name, Logger parent) {
        this.name = name;
        this.parent = parent;
        this.appenders = new ArrayList<>();
        this.logManager = new LogManager();
    }

    public List<LogAppender> getAppenders() {
        return new ArrayList<>(appenders);
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    public void log(String message, LogLevel level) {
        if (this.level != null && level.ordinal() < this.level.ordinal())
            return;

        LogMessage logMessage = new LogMessage(level, name, message);
        logManager.getProcessor().process(logMessage, appenders);
    }

    public void debug(String message) {
        log(message, LogLevel.DEBUG);
    }

    public void info(String message) {
        log(message, LogLevel.INFO);
    }

    public void warn(String message) {
        log(message, LogLevel.WARN);
    }

    public void error(String message) {
        log(message, LogLevel.ERROR);
    }

    public Logger getParent() {
        return parent;
    }

}
