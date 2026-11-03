package com.ares;

public class UserController {

    public boolean registerUser(String userName, String password, String fullName) {
        if (userName.trim().isEmpty() || password.trim().isEmpty() || fullName.trim().isEmpty()) {
            return false;
        }

        for (User u : Database.getUsers()) {
            if (u.getUserName().equals(userName)) {
                return false;
            }
        }

        User newUser = new User(userName, password, fullName);
        Database.addUser(newUser);
        return true;
    }

    public User loginUser(String userName, String password) {
        for (User u : Database.getUsers()) {
            if (u.login(userName, password)) {
                return u;
            }
        }
        return null;
    }

    public boolean deleteUser(String username) {
        for (int i = 0; i < Database.getUsers().size(); i++) {
            if (Database.getUsers().get(i).getUserName().equals(username)) {
                Database.getUsers().remove(i);
                return true;
            }
        }
        return false;
    }
}