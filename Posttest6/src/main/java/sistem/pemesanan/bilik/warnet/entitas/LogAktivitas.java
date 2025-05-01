package sistem.pemesanan.bilik.warnet.entitas;

import java.time.LocalDateTime;

public class LogAktivitas {
    private int idLog;
    private int idBilik;
    private int idPelanggan;
    private int idAdmin;
    private String aktivitas;
    private LocalDateTime waktuLog;

    public LogAktivitas(int idLog, int idBilik, int idPelanggan, int idAdmin, String aktivitas,
            LocalDateTime waktuLog) {
        this.idLog = idLog;
        this.idBilik = idBilik;
        this.idPelanggan = idPelanggan;
        this.idAdmin = idAdmin;
        this.aktivitas = aktivitas;
        this.waktuLog = waktuLog;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdBilik() {
        return idBilik;
    }

    public void setIdBilik(int idBilik) {
        this.idBilik = idBilik;
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

    public String getAktivitas() {
        return aktivitas;
    }

    public void setAktivitas(String aktivitas) {
        this.aktivitas = aktivitas;
    }

    public LocalDateTime getWaktuLog() {
        return waktuLog;
    }

    public void setWaktuLog(LocalDateTime waktuLog) {
        this.waktuLog = waktuLog;
    }
}
