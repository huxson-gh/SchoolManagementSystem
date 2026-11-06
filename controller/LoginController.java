package controller;

import model.User;

import java.util.List;

public class LoginController {

    private List<User> users;

    public LoginController(List<User> users) {
        this.users = users;
    }

    public User login(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }

    public boolean usernameExists(String username) {

        for (User user : users) {

            if (user.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }
}