package algomaster.problems.loggingframework.strategy.formatter;

import algomaster.problems.loggingframework.entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
