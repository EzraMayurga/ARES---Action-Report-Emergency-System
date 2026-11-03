package com.ares;

public class Admin extends Person {

    public Admin(String userName, String password, String fullName) {
        super(userName, password, fullName);
    }

    public boolean deleteUser(UserController userController, String userName) {
        return userController.deleteUser(userName);
    }

    public boolean deleteReport(ReportController reportController, String reportID) {
        return reportController.deleteReport(reportID);
    }

    public boolean editReport(ReportController reportController, String reportID, String newType, String newLocation, String newDate, String newDescription) {
        return reportController.editReport(reportID, newType, newLocation, newDate, newDescription);
    }

    public Report createManualReport(ReportController reportController, String reporterName, String type, String evidence, String location, String date, String time, String description) {
        return reportController.addManualReport(reporterName, type, evidence, location, date, time, description);
    }
}