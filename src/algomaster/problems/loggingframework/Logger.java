package algomaster.problems.loggingframework;

import java.util.ArrayList;
import java.util.List;

import algomaster.problems.loggingframework.entities.LogMessage;
import algomaster.problems.loggingframework.enums.LogLevel;
import algomaster.problems.loggingframework.strategy.appender.LogAppender;

public class Logger {
    private final String name;
    private LogLevel level;
    private final Logger parent;
    private final List<LogAppender> appenders;
    private boolean additivity = true;

    public Logger(String name, Logger parent) {
        this.name = name;
        this.parent = parent;
        this.appenders = new ArrayList<>();
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

    public LogLevel getEffectiveLevel() {
        for (Logger logger = this; logger != null; logger = logger.parent) {
            LogLevel currentLevel = logger.level;
            if (currentLevel != null) {
                return currentLevel;
            }
        }
        return LogLevel.DEBUG; // Default root level
    }

    public void setAdditivity(boolean value) {
        this.additivity = value;
    }

    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    public void log(String message, LogLevel level) {
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            LogMessage logMessage = new LogMessage(level, this.name, message);
            callAppenders(logMessage);
        }
    }

    private void callAppenders(LogMessage logMessage) {
        if (!appenders.isEmpty()) {
            LogManager.getInstance().getProcessor().process(logMessage, this.appenders);
        }
        if (additivity && parent != null) {
            parent.callAppenders(logMessage);
        }
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
