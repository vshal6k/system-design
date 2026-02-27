package algomaster.interfaces;

public class PasswordValidator implements Validator{

    @Override
    public boolean validate(String input) {
        return (input != null) ? input.length() >= 8 : false;
    }
    
}
