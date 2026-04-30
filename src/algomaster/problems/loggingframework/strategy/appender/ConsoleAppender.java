package algomaster.problems.loggingframework.strategy.appender;

import algomaster.problems.loggingframework.entities.LogMessage;
import algomaster.problems.loggingframework.strategy.formatter.LogFormatter;
import algomaster.problems.loggingframework.strategy.formatter.SimpleTextFormatter;

public class ConsoleAppender implements LogAppender {
    private LogFormatter formatter;

    public ConsoleAppender() {
        this.formatter = new SimpleTextFormatter();
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }

    @Override
    public void close() {
    }

    @Override
    public LogFormatter getFormatter() {
        return this.formatter;
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

}
