package com.ares;

public class AdminController {

    public Admin loginAdmin(String userName, String password) {
        for (Admin a : Database.getAdmins()) {
            if (a.login(userName, password)) {
                return a;
            }
        }
        return null;
    }
}