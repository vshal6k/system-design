package algomaster.problems.loggingframework.strategy.appender;

import algomaster.problems.loggingframework.entities.LogMessage;
import algomaster.problems.loggingframework.strategy.formatter.LogFormatter;

public interface LogAppender {
    LogFormatter getFormatter();

    void setFormatter(LogFormatter formatter);

    public void append(LogMessage message);

    public void close();
}
