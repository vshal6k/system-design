package mycarrentalsystem.usermanagement;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        String userName = user.getUserName();
        if (userRepository.findUser(userName) != null)
            return;
        userRepository.registerUser(userName, user);

    }

    public boolean loginUser(String userName, String password) {
        User user = userRepository.findUser(userName);
        if (user == null)
            return false;
        return user.isPasswordCorrect(password);
    }

}
