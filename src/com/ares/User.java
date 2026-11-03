package com.ares;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private int points;
    private List<Report> reportHistory;

    public User(String userName, String password, String fullName) {
        super(userName, password, fullName);
        this.points = 0;
        this.reportHistory = new ArrayList<>();
    }

    public int getPoints() {
        return points;
    }

    public List<Report> getReportHistory() {
        return reportHistory;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int p) {
        this.points += p;
    }

    public void addReport(Report r) {
        reportHistory.add(r);
    }

    public boolean updateReport(ReportController reportController, String reportID, String additionalEvidence, String additionalDescription) {
        for (Report r : reportHistory) {
            if (r.getReportID().equals(reportID)) {
                return reportController.updateUserReport(reportID, additionalEvidence, additionalDescription);
            }
        }
        return false;
    }
}