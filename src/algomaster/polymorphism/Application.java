package algomaster.polymorphism;

import java.nio.file.Path;

public class Application {
    private Logger logger;

    public Application(Logger logger){
        this.logger = logger;
    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }

    public static void main(String[] args) {
        Application app = new Application(new ConsoleLogger());
        app.logger.log("Hello World!");

        app.setLogger(new FileLogger(Path.of("src/algomaster/polymorphism/FilleLogger.txt")));
        app.logger.log("Hello World!");
        
    }
}
