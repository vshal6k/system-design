package algomaster.problems.loggingframework.strategy.formatter;

import algomaster.problems.loggingframework.entities.LogMessage;

public class SimpleTextFormatter implements LogFormatter {

    @Override
    public String format(LogMessage logMessage) {
        return "LogMessage "
                + "[timeStamp=" + logMessage.getTimeStamp()
                + ", level=" + logMessage.getLevel()
                + ", loggerName=" + logMessage.getLoggerName()
                + ", threadName=" + logMessage.getThreadName()
                + ", message=" + logMessage.getMessage() + "]";
    }

}
