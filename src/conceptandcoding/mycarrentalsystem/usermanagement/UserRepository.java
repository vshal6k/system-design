package mycarrentalsystem.usermanagement;

public interface UserRepository {
    public void registerUser(String userName, User user);

    public User findUser(String userName);
}
