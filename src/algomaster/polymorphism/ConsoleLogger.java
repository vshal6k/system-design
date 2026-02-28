package algomaster.polymorphism;

public class ConsoleLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("ConsoleLogger: " + message);
    }

    @Override
    public String getDestination() {
        return "Console";
    }
    
}
