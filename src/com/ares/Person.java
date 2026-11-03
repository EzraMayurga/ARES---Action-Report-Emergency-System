package com.ares;

public class Person {
    protected String userName;
    protected String password;
    protected String fullName;

    public Person(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean login(String userName, String password) {
        return this.userName.equals(userName) && this.password.equals(password);
    }
}