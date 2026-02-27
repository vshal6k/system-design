package algomaster;

import java.util.List;

public class RegistrationService {
    private List<Validator> validators;

    public RegistrationService(List<Validator> validators) {
        this.validators = validators;
    }

    public boolean register(String input) {
        if (validators == null)
            return true;
        return !validators.stream().anyMatch(validator -> !validator.validate(input));
    }

    public static void main(String[] args) {
        List<Validator> emailValidators = List.of(new EmailValidator());
        RegistrationService emailReg = new RegistrationService(emailValidators);
        System.out.println(emailReg.register("user@example.com"));
        System.out.println(emailReg.register("invalid-email"));
        
        List<Validator> passwordValidators = List.of(new PasswordValidator());
        RegistrationService passReg = new RegistrationService(passwordValidators);
        System.out.println(passReg.register("strongpassword"));
        System.out.println(passReg.register("short"));
        
    }

}
