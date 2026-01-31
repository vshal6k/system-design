package mycarrentalsystem.usermanagement;

import java.util.ArrayList;

import mycarrentalsystem.bookingmanagement.Booking;

public class User {
    private String userName;
    private String password;
    private ArrayList<Booking> bookingHistory;

    public String getUserName() {
        return this.userName;
    }

    public boolean isPasswordCorrect(String password) {
        return (password.equals(this.password));
    }

}
