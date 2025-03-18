package Entitas;

import java.time.LocalDateTime;

public class JadwalPemakaian {
    private int idJadwal;
    private int idPemesanan;
    private int idPelanggan;
    private int idAdmin;
    private int idBilik;
    private LocalDateTime waktuMulai;
    private LocalDateTime waktuSelesai;
    private String status;

    public JadwalPemakaian(int idJadwal, int idPemesanan, int idPelanggan, int idAdmin, int idBilik, LocalDateTime waktuMulai, LocalDateTime waktuSelesai, String status) {
        this.idJadwal = idJadwal;
        this.idPemesanan = idPemesanan;
        this.idPelanggan = idPelanggan;
        this.idAdmin = idAdmin;
        this.idBilik = idBilik;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.status = status;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public int getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(int idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdBilik() {
        return idBilik;
    }

    public void setIdBilik(int idBilik) {
        this.idBilik = idBilik;
    }

    public LocalDateTime getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(LocalDateTime waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public LocalDateTime getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(LocalDateTime waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}