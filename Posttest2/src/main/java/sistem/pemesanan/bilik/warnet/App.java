package sistem.pemesanan.bilik.warnet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import sistem.pemesanan.bilik.warnet.entitas.Bilik;
import sistem.pemesanan.bilik.warnet.entitas.JadwalPemakaian;
import sistem.pemesanan.bilik.warnet.entitas.Pelanggan;
import sistem.pemesanan.bilik.warnet.service.BilikService;
import sistem.pemesanan.bilik.warnet.service.JadwalPemakaianService;
import sistem.pemesanan.bilik.warnet.service.PelangganService;

public class App {
    private static PelangganService pelangganService = new PelangganService();
    private static BilikService bilikService = new BilikService();
    private static JadwalPemakaianService jadwalPemakaianService = new JadwalPemakaianService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBilik();
        while (true) {
            clearScreen();
            System.out.println("Menu Utama:");
            System.out.println("1. Login sebagai Pelanggan");
            System.out.println("2. Register Akun Pelanggan");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                loginPelanggan();
            } else if (choice == 2) {
                registerPelanggan();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void loginPelanggan() {
        clearScreen();
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        Pelanggan pelanggan = pelangganService.loginPelanggan(email, password);
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
        String nama = scanner.nextLine();
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        System.out.print("Masukkan nomor HP: ");
        String noHp = scanner.nextLine();

        Pelanggan newPelanggan = new Pelanggan(0, nama, email, password, noHp);
        pelangganService.registerPelanggan(newPelanggan);
        System.out.println("Registrasi berhasil!");
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
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                lihatBilik();
            } else if (choice == 2) {
                sewaBilik(pelanggan);
            } else if (choice == 3) {
                perpanjangSewa(pelanggan);
            } else if (choice == 4) {
                batalkanSewa(pelanggan);
            } else if (choice == 5) {
                break;
            } else {
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

            LocalDateTime waktuMulai = LocalDateTime.now();
            LocalDateTime waktuSelesai = waktuMulai.plusHours(durasi);

            JadwalPemakaian jadwal = new JadwalPemakaian(0, 0, pelanggan.getIdPelanggan(), 0, idBilik, waktuMulai,
                    waktuSelesai, "Aktif");
            jadwalPemakaianService.addJadwalPemakaian(jadwal);

            bilik.setStatus("Disewa");
            bilikService.updateBilik(bilik);

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

            System.out.println("Sewa berhasil dibatalkan.");
        } else {
            System.out.println("Jadwal tidak ditemukan atau tidak aktif.");
        }
        System.out.println("Tekan Enter untuk kembali...");
        scanner.nextLine();
    }

    private static void initializeBilik() {
        for (int i = 1; i <= 5; i++) {
            Bilik bilik = new Bilik(0, "Bilik " + i, "Tersedia", "Spesifikasi PC " + i, 10000);
            bilikService.addBilik(bilik);
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
