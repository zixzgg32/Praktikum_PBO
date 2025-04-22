package sistem.pemesanan.bilik.warnet.entitas;

public class Pemesanan {
    private int idPemesanan;
    private int idPelanggan;
    private int idBilik;
    private int idPembayaran;
    private int idJadwal;

    public Pemesanan(int idPemesanan, int idPelanggan, int idBilik, int idPembayaran, int idJadwal) {
        this.idPemesanan = idPemesanan;
        this.idPelanggan = idPelanggan;
        this.idBilik = idBilik;
        this.idPembayaran = idPembayaran;
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

    public int getIdBilik() {
        return idBilik;
    }

    public void setIdBilik(int idBilik) {
        this.idBilik = idBilik;
    }

    public int getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(int idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }
}
