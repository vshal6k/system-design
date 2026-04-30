package algomaster.problems.loggingframework.strategy.appender;

import java.io.FileWriter;
import java.io.IOException;

import algomaster.problems.loggingframework.entities.LogMessage;
import algomaster.problems.loggingframework.strategy.formatter.LogFormatter;
import algomaster.problems.loggingframework.strategy.formatter.SimpleTextFormatter;

public class FileAppender implements LogAppender {
    private FileWriter writer;
    private LogFormatter formatter;

    public FileAppender(String filePath) {
        this.formatter = new SimpleTextFormatter();
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (Exception e) {
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }
    }

    @Override
    public synchronized void append(LogMessage logMessage) {
        try {
            writer.write(formatter.format(logMessage) + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
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
