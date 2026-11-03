package com.ares;

public class ReportController {

    public Report addReport(String reporterName, String type, String evidence, String location, String date, String time, String description) {
        if (type.trim().isEmpty() || location.trim().isEmpty() || date.trim().isEmpty() || time.trim().isEmpty()) {
            return null;
        }

        String reportID = Database.generateReportID();
        Report newReport = new Report(reportID, reporterName, type, evidence, location, date, time, description);
        Database.addReport(newReport);
        return newReport;
    }

    public Report addManualReport(String reporterName, String type, String evidence, String location, String date, String time, String description) {
        if (type.trim().isEmpty() || location.trim().isEmpty() || date.trim().isEmpty() || time.trim().isEmpty()) {
            return null;
        }

        String reportID = Database.generateReportID();
        Report newReport = new Report(reportID, reporterName, type, evidence, location, date, time, description);
        Database.addReport(newReport);
        return newReport;
    }

    public boolean deleteReport(String reportID) {
        for (int i = 0; i < Database.getReports().size(); i++) {
            if (Database.getReports().get(i).getReportID().equals(reportID)) {
                Database.getReports().remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editReport(String reportID, String newType, String newLocation, String newDate, String newDescription) {
        for (Report r : Database.getReports()) {
            if (r.getReportID().equals(reportID)) {
                if (!newType.trim().isEmpty()) {
                    r.setType(newType);
                }
                if (!newLocation.trim().isEmpty()) {
                    r.setLocation(newLocation);
                }
                if (!newDate.trim().isEmpty()) {
                    r.setDate(newDate);
                }
                if (!newDescription.trim().isEmpty()) {
                    r.setDescription(newDescription);
                }
                return true;
            }
        }
        return false;
    }

    public boolean updateUserReport(String reportID, String additionalEvidence, String additionalDescription) {
        for (Report r : Database.getReports()) {
            if (r.getReportID().equals(reportID)) {
                if (!additionalEvidence.trim().isEmpty()) {
                    r.addEvidence(additionalEvidence);
                }
                if (!additionalDescription.trim().isEmpty()) {
                    r.addDescription(additionalDescription);
                }
                return true;
            }
        }
        return false;
    }

    public Report getReportByID(String reportID) {
        for (Report r : Database.getReports()) {
            if (r.getReportID().equals(reportID)) {
                return r;
            }
        }
        return null;
    }
}