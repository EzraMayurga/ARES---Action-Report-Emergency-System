package com.ares;

public class Report {
    private String reportID;
    private String reporterName;
    private String type;
    private String evidence;
    private String location;
    private String date;
    private String time;
    private String status;
    private String description;

    public Report(String reportID, String reporterName, String type, String evidence, String location, String date, String time, String description) {
        this.reportID = reportID;
        this.reporterName = reporterName;
        this.type = type;
        this.evidence = evidence;
        this.location = location;
        this.date = date;
        this.time = time;
        this.description = description;
        this.status = "Pending";
    }

    public String getReportID() {
        return reportID;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getType() {
        return type;
    }

    public String getEvidence() {
        return evidence;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addEvidence(String additionalEvidence) {
        this.evidence = this.evidence + ", " + additionalEvidence;
    }

    public void addDescription(String additionalDescription) {
        this.description = this.description + " | UPDATE: " + additionalDescription;
    }
}