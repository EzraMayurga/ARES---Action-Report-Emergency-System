package com.ares;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static User currentUser = null;
    static Admin currentAdmin = null;

    static UserController userController = new UserController();
    static AdminController adminController = new AdminController();
    static ReportController reportController = new ReportController();
    static RewardController rewardController = new RewardController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== ARES - Action Report Emergency System ===");
            System.out.println("1. Login User");
            System.out.println("2. Register User");
            System.out.println("3. Login Admin");
            System.out.println("4. Emergency Call");
            System.out.println("5. Exit");
            System.out.print("Pilih: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("ERROR: Input harus berupa angka 1 - 5!");
                sc.nextLine();
                continue;
            }

            if (choice == 1) {
                loginUser();
            } else if (choice == 2) {
                registerUser();
            } else if (choice == 3) {
                loginAdmin();
            } else if (choice == 4) {
                emergencyCall();
            } else if (choice == 5) {
                System.out.println("Terima kasih telah menggunakan ARES!");
                break;
            } else {
                System.out.println("ERROR: Pilihan tidak tersedia! Masukkan 1 - 5.");
            }
        }
    }

    static void registerUser() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Nama Lengkap: ");
        String fullName = sc.nextLine();

        if (userController.registerUser(username, password, fullName)) {
            System.out.println("Registrasi berhasil!");
        } else {
            System.out.println("Registrasi gagal! Username sudah digunakan atau input tidak valid.");
        }
    }

    static void loginUser() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        currentUser = userController.loginUser(username, password);
        if (currentUser != null) {
            System.out.println("Login berhasil! Selamat datang, " + currentUser.getFullName());
            userMenu();
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    static void loginAdmin() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        currentAdmin = adminController.loginAdmin(username, password);
        if (currentAdmin != null) {
            System.out.println("Login berhasil! Selamat datang, " + currentAdmin.getFullName());
            adminMenu();
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    static void userMenu() {
        while (true) {
            System.out.println("\n=== User Menu ===");
            System.out.println("User: " + currentUser.getFullName());
            System.out.println("Poin: " + currentUser.getPoints());
            System.out.println("1. Buat Laporan");
            System.out.println("2. Lihat Laporan Saya");
            System.out.println("3. Detail Laporan");
            System.out.println("4. Update Laporan");
            System.out.println("5. Tukar Reward");
            System.out.println("6. Emergency Call");
            System.out.println("7. Logout");
            System.out.print("Pilih: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("ERROR: Input harus angka 1 - 7!");
                sc.nextLine();
                continue;
            }

            if (choice == 1) {
                createReport();
            } else if (choice == 2) {
                viewMyReports();
            } else if (choice == 3) {
                viewReportDetail();
            } else if (choice == 4) {
                updateReport();
            } else if (choice == 5) {
                claimReward();
            } else if (choice == 6) {
                emergencyCall();
            } else if (choice == 7) {
                System.out.println("Logout berhasil!");
                currentUser = null;
                break;
            } else {
                System.out.println("ERROR: Pilihan tidak tersedia!");
            }
        }
    }

    static void createReport() {
        System.out.print("Jenis (Darurat/Publik): ");
        String type = sc.nextLine();
        System.out.print("Bukti (foto/video): ");
        String evidence = sc.nextLine();
        System.out.print("Lokasi: ");
        String location = sc.nextLine();
        System.out.print("Tanggal (DD/MM/YYYY): ");
        String date = sc.nextLine();
        System.out.print("Jam (HH:MM): ");
        String time = sc.nextLine();
        System.out.print("Deskripsi kejadian: ");
        String description = sc.nextLine();

        Report newReport = reportController.addReport(currentUser.getFullName(), type, evidence, location, date, time, description);
        if (newReport != null) {
            currentUser.addReport(newReport);
            rewardController.addPointsToUser(currentUser, 10);
            System.out.println("Laporan berhasil dibuat! ID: " + newReport.getReportID());
            System.out.println("Anda mendapat +10 poin!");
        } else {
            System.out.println("ERROR: Semua field wajib diisi!");
        }
    }

    static void viewMyReports() {
        System.out.println("\n=== Laporan Saya ===");
        if (currentUser.getReportHistory().isEmpty()) {
            System.out.println("Belum ada laporan.");
            return;
        }

        for (Report r : currentUser.getReportHistory()) {
            System.out.println("\n--------------------------");
            System.out.println("ID: " + r.getReportID());
            System.out.println("Jenis: " + r.getType());
            System.out.println("Lokasi: " + r.getLocation());
            System.out.println("Tanggal: " + r.getDate() + " " + r.getTime());
            System.out.println("Status: " + r.getStatus());
        }
    }

    static void viewReportDetail() {
        System.out.print("Masukkan ID Laporan: ");
        String id = sc.nextLine();

        for (Report r : currentUser.getReportHistory()) {
            if (r.getReportID().equals(id)) {
                System.out.println("\n=== Detail Laporan ===");
                System.out.println("ID: " + r.getReportID());
                System.out.println("Pelapor: " + r.getReporterName());
                System.out.println("Jenis: " + r.getType());
                System.out.println("Bukti: " + r.getEvidence());
                System.out.println("Lokasi: " + r.getLocation());
                System.out.println("Tanggal: " + r.getDate());
                System.out.println("Jam: " + r.getTime());
                System.out.println("Deskripsi: " + r.getDescription());
                System.out.println("Status: " + r.getStatus());
                return;
            }
        }
        System.out.println("ERROR: Laporan tidak ditemukan!");
    }

    static void updateReport() {
        System.out.print("Masukkan ID Laporan: ");
        String id = sc.nextLine();

        Report report = null;
        for (Report r : currentUser.getReportHistory()) {
            if (r.getReportID().equals(id)) {
                report = r;
                break;
            }
        }

        if (report == null) {
            System.out.println("ERROR: Laporan tidak ditemukan!");
            return;
        }

        System.out.print("Bukti tambahan (foto/video) [Enter untuk skip]: ");
        String additionalEvidence = sc.nextLine();
        System.out.print("Keterangan tambahan [Enter untuk skip]: ");
        String additionalDescription = sc.nextLine();

        if (currentUser.updateReport(reportController, id, additionalEvidence, additionalDescription)) {
            System.out.println("Laporan berhasil diupdate!");
        } else {
            System.out.println("ERROR: Gagal mengupdate laporan!");
        }
    }

    static void claimReward() {
        System.out.println("\n=== Tukar Reward ===");
        System.out.println("Poin Anda: " + currentUser.getPoints());

        int i = 1;
        for (Reward rw : Database.getRewards()) {
            System.out.println(i++ + ". " + rw.getRewardType() + " (" + rw.getPointsRequired() + " poin)");
        }

        System.out.print("Pilih (0 untuk batal): ");
        int choice;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("ERROR: Input harus angka!");
            sc.nextLine();
            return;
        }

        if (choice > 0 && choice <= Database.getRewards().size()) {
            if (rewardController.claimReward(currentUser, choice - 1)) {
                System.out.println("Reward berhasil ditukar!");
            } else {
                System.out.println("ERROR: Poin tidak cukup!");
            }
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("Admin: " + currentAdmin.getFullName());
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Detail Laporan");
            System.out.println("3. Update Status Laporan");
            System.out.println("4. Edit Laporan");
            System.out.println("5. Hapus Laporan");
            System.out.println("6. Tambah Laporan Manual");
            System.out.println("7. Hapus User");
            System.out.println("8. Logout");
            System.out.print("Pilih: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("ERROR: Input harus angka 1 - 8!");
                sc.nextLine();
                continue;
            }

            if (choice == 1) {
                viewAllReports();
            } else if (choice == 2) {
                viewAdminReportDetail();
            } else if (choice == 3) {
                updateStatus();
            } else if (choice == 4) {
                editReport();
            } else if (choice == 5) {
                deleteReport();
            } else if (choice == 6) {
                addManualReport();
            } else if (choice == 7) {
                deleteUser();
            } else if (choice == 8) {
                System.out.println("Logout berhasil!");
                currentAdmin = null;
                break;
            } else {
                System.out.println("ERROR: Pilihan tidak tersedia!");
            }
        }
    }

    static void viewAllReports() {
        System.out.println("\n=== Semua Laporan ===");
        if (Database.getReports().isEmpty()) {
            System.out.println("Belum ada laporan.");
            return;
        }

        for (Report r : Database.getReports()) {
            System.out.println("\n--------------------------");
            System.out.println("ID: " + r.getReportID());
            System.out.println("Pelapor: " + r.getReporterName());
            System.out.println("Jenis: " + r.getType());
            System.out.println("Lokasi: " + r.getLocation());
            System.out.println("Tanggal: " + r.getDate() + " " + r.getTime());
            System.out.println("Status: " + r.getStatus());
        }
    }

    static void viewAdminReportDetail() {
        System.out.print("Masukkan ID Laporan: ");
        String id = sc.nextLine();

        for (Report r : Database.getReports()) {
            if (r.getReportID().equals(id)) {
                System.out.println("\n=== Detail Laporan ===");
                System.out.println("ID: " + r.getReportID());
                System.out.println("Pelapor: " + r.getReporterName());
                System.out.println("Jenis: " + r.getType());
                System.out.println("Bukti: " + r.getEvidence());
                System.out.println("Lokasi: " + r.getLocation());
                System.out.println("Tanggal: " + r.getDate());
                System.out.println("Jam: " + r.getTime());
                System.out.println("Deskripsi: " + r.getDescription());
                System.out.println("Status: " + r.getStatus());
                return;
            }
        }
        System.out.println("ERROR: Laporan tidak ditemukan!");
    }

    static void updateStatus() {
        System.out.print("ID Laporan: ");
        String id = sc.nextLine();

        for (Report r : Database.getReports()) {
            if (r.getReportID().equals(id)) {
                r.setStatus("Selesai");
                System.out.println("Status laporan berhasil diupdate menjadi Selesai!");
                return;
            }
        }
        System.out.println("ERROR: Laporan tidak ditemukan!");
    }

    static void editReport() {
        System.out.print("ID Laporan yang akan diedit: ");
        String id = sc.nextLine();

        Report report = reportController.getReportByID(id);
        if (report == null) {
            System.out.println("ERROR: Laporan tidak ditemukan!");
            return;
        }

        System.out.println("\n=== Data Saat Ini ===");
        System.out.println("Jenis: " + report.getType());
        System.out.println("Lokasi: " + report.getLocation());
        System.out.println("Tanggal: " + report.getDate());
        System.out.println("Deskripsi: " + report.getDescription());

        System.out.println("\n=== Masukkan Data Baru (Enter untuk skip) ===");
        System.out.print("Jenis baru: ");
        String newType = sc.nextLine();
        System.out.print("Lokasi baru: ");
        String newLocation = sc.nextLine();
        System.out.print("Tanggal baru: ");
        String newDate = sc.nextLine();
        System.out.print("Deskripsi baru: ");
        String newDescription = sc.nextLine();

        if (currentAdmin.editReport(reportController, id, newType, newLocation, newDate, newDescription)) {
            System.out.println("Laporan berhasil diedit!");
        } else {
            System.out.println("ERROR: Gagal mengedit laporan!");
        }
    }

    static void deleteReport() {
        System.out.print("ID Laporan yang akan dihapus: ");
        String id = sc.nextLine();

        if (currentAdmin.deleteReport(reportController, id)) {
            System.out.println("Laporan berhasil dihapus!");
        } else {
            System.out.println("ERROR: Laporan tidak ditemukan!");
        }
    }

    static void addManualReport() {
        System.out.println("\n=== Tambah Laporan Manual ===");
        System.out.print("Nama Pelapor: ");
        String reporterName = sc.nextLine();
        System.out.print("Jenis (Darurat/Publik): ");
        String type = sc.nextLine();
        System.out.print("Bukti (foto/video): ");
        String evidence = sc.nextLine();
        System.out.print("Lokasi: ");
        String location = sc.nextLine();
        System.out.print("Tanggal (DD/MM/YYYY): ");
        String date = sc.nextLine();
        System.out.print("Jam (HH:MM): ");
        String time = sc.nextLine();
        System.out.print("Deskripsi: ");
        String description = sc.nextLine();

        Report newReport = currentAdmin.createManualReport(reportController, reporterName, type, evidence, location, date, time, description);
        if (newReport != null) {
            System.out.println("Laporan manual berhasil ditambahkan! ID: " + newReport.getReportID());
        } else {
            System.out.println("ERROR: Semua field wajib diisi!");
        }
    }

    static void deleteUser() {
        System.out.print("Username yang akan dihapus: ");
        String username = sc.nextLine();

        if (currentAdmin.deleteUser(userController, username)) {
            System.out.println("User berhasil dihapus!");
        } else {
            System.out.println("ERROR: User tidak ditemukan!");
        }
    }

    static void emergencyCall() {
        System.out.println("\n==========================================================================");
        System.out.println("                       ⚠️ EMERGENCY CALL ⚠️                           ");
        System.out.println("Kamu sekarang sedang dihubungkan dengan Emergency Response terdekat:");
        System.out.println("                       - Pemadam Kebakaran 🚒");
        System.out.println("                       - Kepolisian 🚓");
        System.out.println("                       - Rumah Sakit 🏥");
        System.out.println("\n       Mohon tetap tenang dan ikuti instruksi petugas");
        System.out.println("==========================================================================\n");
    }
}