package com.ares;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<User> users = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();
    private static List<Report> reports = new ArrayList<>();
    private static List<Reward> rewards = new ArrayList<>();
    private static int reportCounter = 1;

    static {
        admins.add(new Admin("admin", "admin123", "Administrator"));
        
        rewards.add(new Reward("Voucher Grab 50k", 50));
        rewards.add(new Reward("Voucher GoFood 100k", 100));
        rewards.add(new Reward("Voucher Shopee 200k", 200));
    }

    public static List<User> getUsers() { return users; }
    public static List<Admin> getAdmins() { return admins; }
    public static List<Report> getReports() { return reports; }
    public static List<Reward> getRewards() { return rewards; }
    
    public static void addUser(User u) { users.add(u); }
    public static void addReport(Report r) { reports.add(r); }
    
    public static String generateReportID() {
        return String.format("REP-%03d", reportCounter++);
    }
}