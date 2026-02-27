package algomaster;

public class EmailValidator implements Validator{

    @Override
    public boolean validate(String input) {
        return (input != null) ? input.contains("@"): false;
    }
    
}
