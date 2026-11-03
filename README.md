# ARES (Action Report Emergency System)

ARES adalah aplikasi konsol berbasis Java yang dirancang untuk mempermudah pelaporan darurat dan masalah publik (seperti infrastruktur rusak, kecelakaan, atau tindak kriminal) di wilayah perkotaan seperti Jakarta. 

Aplikasi ini dikembangkan dengan menerapkan prinsip **Object-Oriented Programming (OOP)** dan dilengkapi dengan sistem reward berbasis poin untuk memotivasi warga agar lebih proaktif menjaga keamanan serta ketertiban lingkungan dengan reward.

---

## Main Feature dari ARES

### 1. Role-Based Access Control (RBAC)
* **Admin:** Mengelola seluruh laporan yang masuk (CRUD), mengubah status laporan menjadi "Selesai", dan menghapus laporan yang tidak valid.
* **User:** Melakukan registrasi akun unik, membuat laporan baru lengkap dengan bukti foto/video, lokasi, tanggal, serta jam kejadian, dan memantau status laporan (*Pending* atau *Selesai*).

### 2. Reward System
* Setiap kali *User* berhasil mengirimkan laporan yang valid, mereka akan mendapatkan akumulasi poin.
* Poin tersebut dapat ditukar dengan berbagai *reward* menarik sebagai insentif partisipasi aktif masyarakat.

## 🛠️ Tech Stack & Konsep OOP
* **Bahasa Pemrograman:** Java
* **Konsep OOP yang Diterapkan:**
  * *Inheritance* (Pewarisan kelas *Person* ke *User* dan *Admin*)
  * *Encapsulation* (Penggunaan *getter* dan *setter* pada atribut model)
  * *Association & Dependency* (Relasi antar kelas menggunakan *Controller* dan *ArrayList* untuk penyimpanan data sementara)

---

## Pembagian Tugas Kelompok
berikut adalah detail (Nama | Pembagian Tugas) kami:

**Ezra Mayurga** (2802481626) | Implementasi fitur User (register, login, create report), Use Case Diagram, & Pengujian Program
**Wiravindra Wilbert Winarso** (2802480945) | Implementasi fitur Admin (view reports, update status, delete report), Class Diagram Inti, & Pengujian Program
**Achmad Rafif Zahran** (2802483184) | Implementasi fitur Report (CRUD & validasi input), Sequence Diagram, & Pengujian Program
**Kenneth Rafael Tjahjadi** (2802483663) | Implementasi Reward & Rating System, Integrasi Modul (User-Admin-Report-Reward), & Pengujian Program