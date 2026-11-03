package com.ares;

public class Review {
    private String comment;
    private Report report;
    private double rating;
    private User user;

    public Review(String comment, Report report, double rating, User user) {
        this.comment = comment;
        this.report = report;
        this.rating = rating;
        this.user = user;
    }

    public String getComment() { return comment; }
    public Report getReport() { return report; }
    public double getRating() { return rating; }
    public User getUser() { return user; }
}