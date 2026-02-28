package algomaster.polymorphism;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileLogger implements Logger {

    private Path file;

    public FileLogger(Path file) {
        this.file = file;
    }

    @Override
    public void log(String message) {
        try (BufferedWriter out = Files.newBufferedWriter(file, StandardOpenOption.CREATE)) {
            out.write(message);
            out.newLine();
        } catch (Exception e) {
            System.out.println("Error occured in loggin to the file " + e.getMessage());
        }
    }

    @Override
    public String getDestination() {
        return file.toString();
    }

}
