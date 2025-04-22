package sistem.pemesanan.bilik.warnet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sistem.pemesanan.bilik.warnet.entitas.Admin;
import sistem.pemesanan.bilik.warnet.entitas.Bilik;
import sistem.pemesanan.bilik.warnet.entitas.JadwalPemakaian;
import sistem.pemesanan.bilik.warnet.entitas.LogAktivitas;
import sistem.pemesanan.bilik.warnet.entitas.MemberPelanggan;
import sistem.pemesanan.bilik.warnet.entitas.Operator;
import sistem.pemesanan.bilik.warnet.entitas.Owner;
import sistem.pemesanan.bilik.warnet.entitas.Pelanggan;
import sistem.pemesanan.bilik.warnet.entitas.Teknisi;
import sistem.pemesanan.bilik.warnet.service.BilikService;
import sistem.pemesanan.bilik.warnet.service.JadwalPemakaianService;
import sistem.pemesanan.bilik.warnet.service.PelangganService;

public final class App {
    private static final PelangganService pelangganService = new PelangganService();
    private static final BilikService bilikService = new BilikService();
    private static final JadwalPemakaianService jadwalPemakaianService = new JadwalPemakaianService();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Admin> adminList = new ArrayList<>();
    private static final List<LogAktivitas> logAktivitasList = new ArrayList<>();

    public static void main(String[] args) {
        initializeBilik();
        initializeAdmin();
        boolean isRunning = true;
    
        while (isRunning) {
            clearScreen();
            System.out.println("Menu Utama:");
            System.out.println("1. Login sebagai Pelanggan");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Register Akun Pelanggan");
            System.out.println("4. Exit");
            System.out.print("Pilih opsi: ");
    
            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
    
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    loginPelanggan();
                    break;
                case 2:
                    loginAdmin();
                    break;
                case 3:
                    registerPelanggan();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void loginAdmin() {
        clearScreen();
        System.out.print("Masukkan nama: ");
        final String nama = scanner.nextLine();
        System.out.print("Masukkan password: ");
        final String password = scanner.nextLine();

        final Admin admin = adminList.stream()
                .filter(a -> a.getNama().equals(nama) && a.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (admin != null) {
            System.out.println("Login berhasil! Selamat datang, " + admin.getNama());
            admin.displayRole();
            menuAdmin(admin);
        } else {
            System.out.println("Nama atau password salah.");
        }
    }

    private static void loginPelanggan() {
        clearScreen();
        System.out.print("Masukkan email: ");
        final String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        final String password = scanner.nextLine();

        final Pelanggan pelanggan = pelangganService.loginPelanggan(email, password);
        if (pelanggan != null) {
            System.out.println("Login berhasil! Selamat datang, " + pelanggan.getNama());
            menuPelanggan(pelanggan);
        } else {
            System.out.println("Email atau password salah.");
        }
    }

    private static void registerPelanggan() {
        clearScreen();
        System.out.print("Masukkan nama: ");
        final String nama = scanner.nextLine();
        System.out.print("Masukkan email: ");
        final String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        final String password = scanner.nextLine();
        System.out.print("Masukkan nomor HP: ");
        final String noHp = scanner.nextLine();
        System.out.print("Apakah pelanggan ini adalah member? (y/n): ");
        final String isMember = scanner.nextLine();

        if (isMember.equalsIgnoreCase("y")) {
            double discountRate;
            do {
                System.out.print("Masukkan diskon (0-1): ");
                discountRate = scanner.nextDouble();
                if (discountRate < 0 || discountRate > 1) {
                    System.out.println("Diskon harus di antara 0 dan 1.");
                }
            } while (discountRate < 0 || discountRate > 1);
            scanner.nextLine();
            final MemberPelanggan member = new MemberPelanggan(0, nama, email, password, noHp, discountRate);
            pelangganService.registerPelanggan(member);
        } else {
            final Pelanggan newPelanggan = new Pelanggan(0, nama, email, password, noHp);
            pelangganService.registerPelanggan(newPelanggan);
        }
        System.out.println("Registrasi berhasil!");
    }

    private static void menuAdmin(Admin admin) {
        while (true) {
            clearScreen();
            System.out.println("Menu Admin:");
            System.out.println("1. Lihat List Bilik");
            if (admin instanceof Operator || admin instanceof Owner) {
                System.out.println("2. Tambah Bilik");
                System.out.println("3. Edit Bilik");
                System.out.println("4. Hapus Bilik");
                System.out.println("5. Lihat Pesanan");
                System.out.println("6. Hapus Pesanan");
            }
            if (admin instanceof Owner) {
                System.out.println("7. Lihat Laporan Keuangan");
                System.out.println("8. Lihat Log Aktivitas");
            } else if (admin instanceof Teknisi) {
                System.out.println("7. Periksa Bilik");
                System.out.println("8. Perbaiki Bilik");
            }
            System.out.println("9. Logout");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    lihatBilik();
                    break;
                case 2:
                    if (admin instanceof Operator || admin instanceof Owner) tambahBilik();
                    break;
                case 3:
                    if (admin instanceof Operator || admin instanceof Owner) editBilik();
                    break;
                case 4:
                    if (admin instanceof Operator || admin instanceof Owner) hapusBilik();
                    break;
                case 5:
                    if (admin instanceof Operator || admin instanceof Owner) lihatPesanan();
                    break;
                case 6:
                    if (admin instanceof Operator || admin instanceof Owner) hapusPesanan();
                    break;
                case 7:
                    if (admin instanceof Owner owner) {
                        owner.lihatLaporanKeuangan();
                    } else if (admin instanceof Teknisi teknisi) {
                        System.out.print("Masukkan ID Bilik yang ingin diperiksa: ");
                        int idBilik = scanner.nextInt();
                        scanner.nextLine();
                        teknisi.periksaBilik(idBilik);
                    }
                    break;
                case 8:
                    if (admin instanceof Teknisi teknisi) {
                        System.out.print("Masukkan ID Bilik yang ingin diperbaiki: ");
                        int idBilik = scanner.nextInt();
                        scanner.nextLine();
                        teknisi.perbaikiBilik(idBilik);
                    } else if (admin instanceof Owner) {
                        lihatLogAktivitas();
                    }
            
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahBilik() {
        clearScreen();
        System.out.print("Masukkan nomor bilik: ");
        String nomorBilik = scanner.nextLine();
        System.out.print("Masukkan spesifikasi PC: ");
        String spesifikasiPc = scanner.nextLine();
        System.out.print("Masukkan harga per jam: ");
        double hargaPerjam = scanner.nextDouble();
        scanner.nextLine();

        Bilik bilik = new Bilik(0, nomorBilik, "Tersedia", spesifikasiPc, hargaPerjam);
        bilikService.addBilik(bilik);
        System.out.println("Bilik berhasil ditambahkan.");
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void editBilik() {
        clearScreen();
        System.out.print("Masukkan ID Bilik yang ingin diedit: ");
        int idBilik = scanner.nextInt();
        scanner.nextLine();

        Bilik bilik = bilikService.getBilikById(idBilik);
        if (bilik != null) {
            System.out.print("Masukkan nomor bilik baru: ");
            String nomorBilik = scanner.nextLine();
            System.out.print("Masukkan spesifikasi PC baru: ");
            String spesifikasiPc = scanner.nextLine();
            System.out.print("Masukkan harga per jam baru: ");
            double hargaPerjam = scanner.nextDouble();
            scanner.nextLine();

            bilik.setNomorBilik(nomorBilik);
            bilik.setSpesifikasiPc(spesifikasiPc);
            bilik.setHargaPerjam(hargaPerjam);
            bilikService.updateBilik(bilik);

            System.out.println("Bilik berhasil diedit.");
        } else {
            System.out.println("Bilik tidak ditemukan.");
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void hapusBilik() {
        clearScreen();
        System.out.print("Masukkan ID Bilik yang ingin dihapus: ");
        int idBilik = scanner.nextInt();
        scanner.nextLine();

        bilikService.deleteBilik(idBilik);
        System.out.println("Bilik berhasil dihapus.");
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void lihatPesanan() {
        clearScreen();
        List<JadwalPemakaian> jadwalList = jadwalPemakaianService.getAllJadwalPemakaian();
        for (JadwalPemakaian jadwal : jadwalList) {
            System.out.println("ID Jadwal: " + jadwal.getIdJadwal() + ", ID Bilik: " + jadwal.getIdBilik() +
                    ", ID Pelanggan: " + jadwal.getIdPelanggan() + ", Status: " + jadwal.getStatus());
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void hapusPesanan() {
        clearScreen();
        System.out.print("Masukkan ID Jadwal yang ingin dihapus: ");
        int idJadwal = scanner.nextInt();
        scanner.nextLine();

        jadwalPemakaianService.deleteJadwalPemakaian(idJadwal);
        System.out.println("Pesanan berhasil dihapus.");
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void lihatLogAktivitas() {
        clearScreen();
        System.out.println("Log Aktivitas:");
        if (logAktivitasList.isEmpty()) {
            System.out.println("Tidak ada log aktivitas.");
        } else {
            for (LogAktivitas log : logAktivitasList) {
                System.out.println("ID Log: " + log.getIdLog() +
                        ", Aktivitas: " + log.getAktivitas() +
                        ", Waktu: " + log.getWaktuLog());
            }
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }
    
    private static void menuPelanggan(Pelanggan pelanggan) {
        while (true) {
            clearScreen();
            System.out.println("Menu Pelanggan:");
            System.out.println("1. Lihat Bilik");
            System.out.println("2. Sewa Bilik");
            System.out.println("3. Perpanjang Sewa");
            System.out.println("4. Batalkan Sewa Bilik");
            System.out.println("5. Kembali");
            System.out.print("Pilih opsi: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine(); 
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    lihatBilik();
                    break;
                case 2:
                    sewaBilik(pelanggan);
                    break;
                case 3:
                    perpanjangSewa(pelanggan);
                    break;
                case 4:
                    batalkanSewa(pelanggan);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void lihatBilik() {
        clearScreen();
        List<Bilik> bilikList = bilikService.getAllBilik();
        for (Bilik bilik : bilikList) {
            System.out.println("ID: " + bilik.getIdBilik() + ", Nomor: " + bilik.getNomorBilik() + ", Status: "
                    + bilik.getStatus() + ", Spesifikasi: " + bilik.getSpesifikasiPc() + ", Harga per jam: "
                    + bilik.getHargaPerjam());
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void sewaBilik(Pelanggan pelanggan) {
        clearScreen();
        System.out.print("Masukkan ID Bilik: ");
        int idBilik = scanner.nextInt();
        scanner.nextLine();
    
        Bilik bilik = bilikService.getBilikById(idBilik);
        if (bilik != null && bilik.getStatus().equals("Tersedia")) {
            System.out.print("Masukkan durasi sewa (jam): ");
            int durasi = scanner.nextInt();
            scanner.nextLine();
    
            double totalHarga = bilik.getHargaPerjam() * durasi;
            if (pelanggan instanceof MemberPelanggan member) {
                totalHarga = member.calculateDiscount(totalHarga);
                System.out.println("Diskon diterapkan! Total harga setelah diskon: Rp " + totalHarga);
            } else {
                System.out.println("Total harga: Rp " + totalHarga);
            }
    
            LocalDateTime waktuMulai = LocalDateTime.now();
            LocalDateTime waktuSelesai = waktuMulai.plusHours(durasi);
    
            JadwalPemakaian jadwal = new JadwalPemakaian(0, 0, pelanggan.getIdPelanggan(), 0, idBilik, waktuMulai,
                    waktuSelesai, "Aktif");
            jadwalPemakaianService.addJadwalPemakaian(jadwal);
    
            bilik.setStatus("Disewa");
            bilikService.updateBilik(bilik);
    
            logAktivitasList.add(new LogAktivitas(
                    logAktivitasList.size() + 1,
                    idBilik,
                    pelanggan.getIdPelanggan(),
                    0, 
                    "Pelanggan ID " + pelanggan.getIdPelanggan() + " menyewa bilik ID " + idBilik,
                    LocalDateTime.now()
            ));
    
            System.out.println("Bilik berhasil disewa.");
        } else {
            System.out.println("Bilik tidak tersedia.");
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void perpanjangSewa(Pelanggan pelanggan) {
        clearScreen();
        System.out.print("Masukkan ID Jadwal: ");
        int idJadwal = scanner.nextInt();
        scanner.nextLine();
    
        JadwalPemakaian jadwal = jadwalPemakaianService.getJadwalPemakaianById(idJadwal);
        if (jadwal != null && jadwal.getIdPelanggan() == pelanggan.getIdPelanggan()
                && jadwal.getStatus().equals("Aktif")) {
            System.out.print("Masukkan durasi perpanjangan (jam): ");
            int durasi = scanner.nextInt();
            scanner.nextLine();
    
            LocalDateTime waktuSelesaiBaru = jadwal.getWaktuSelesai().plusHours(durasi);
            jadwal.setWaktuSelesai(waktuSelesaiBaru);
            jadwalPemakaianService.updateJadwalPemakaian(jadwal);
    
            logAktivitasList.add(new LogAktivitas(
                    logAktivitasList.size() + 1,
                    jadwal.getIdBilik(),
                    pelanggan.getIdPelanggan(),
                    0,
                    "Pelanggan ID " + pelanggan.getIdPelanggan() + " memperpanjang sewa bilik ID " + jadwal.getIdBilik(),
                    LocalDateTime.now()
            ));
    
            System.out.println("Sewa berhasil diperpanjang.");
        } else {
            System.out.println("Jadwal tidak ditemukan atau tidak aktif.");
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void batalkanSewa(Pelanggan pelanggan) {
        clearScreen();
        System.out.print("Masukkan ID Jadwal: ");
        int idJadwal = scanner.nextInt();
        scanner.nextLine();
    
        JadwalPemakaian jadwal = jadwalPemakaianService.getJadwalPemakaianById(idJadwal);
        if (jadwal != null && jadwal.getIdPelanggan() == pelanggan.getIdPelanggan()
                && jadwal.getStatus().equals("Aktif")) {
            jadwal.setStatus("Dibatalkan");
            jadwalPemakaianService.updateJadwalPemakaian(jadwal);
    
            Bilik bilik = bilikService.getBilikById(jadwal.getIdBilik());
            bilik.setStatus("Tersedia");
            bilikService.updateBilik(bilik);
    
            logAktivitasList.add(new LogAktivitas(
                    logAktivitasList.size() + 1,
                    jadwal.getIdBilik(),
                    pelanggan.getIdPelanggan(),
                    0, 
                    "Pelanggan ID " + pelanggan.getIdPelanggan() + " membatalkan sewa bilik ID " + jadwal.getIdBilik(),
                    LocalDateTime.now()
            ));
    
            System.out.println("Sewa berhasil dibatalkan.");
        } else {
            System.out.println("Jadwal tidak ditemukan atau tidak aktif.");
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private final static void initializeAdmin() {
        adminList.add(new Owner(1, "081234567891", "owner", "owner", bilikService, jadwalPemakaianService));
        adminList.add(new Operator(2, "081234567892", "operator", "operator", bilikService, jadwalPemakaianService));
        adminList.add(new Teknisi(3, "081234567893", "teknisi", "teknisi", bilikService));  
    }

    private final static void initializeBilik() {
        for (int i = 1; i <= 5; i++) {
            final Bilik bilik = new Bilik(0, "Bilik " + i, "Tersedia", "I9 RTX5090", 10000);
            bilikService.addBilik(bilik);
        }
    }

    private final static void clearScreen() {
        try {
            Thread.sleep(1000);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Terjadi kesalahan pada delay.");
        }
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}
