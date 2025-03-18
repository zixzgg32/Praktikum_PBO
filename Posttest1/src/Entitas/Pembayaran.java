package Entitas;

import java.time.LocalDateTime;

public class Pembayaran {
    private int idPembayaran;
    private int idPelanggan;
    private double totalHarga;
    private String metodeBayar;
    private String status;
    private LocalDateTime tanggalBayar;

    public Pembayaran(int idPembayaran, int idPelanggan, double totalHarga, String metodeBayar, String status, LocalDateTime tanggalBayar) {
        this.idPembayaran = idPembayaran;
        this.idPelanggan = idPelanggan;
        this.totalHarga = totalHarga;
        this.metodeBayar = metodeBayar;
        this.status = status;
        this.tanggalBayar = tanggalBayar;
    }

    public int getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(int idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getMetodeBayar() {
        return metodeBayar;
    }

    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(LocalDateTime tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }
}