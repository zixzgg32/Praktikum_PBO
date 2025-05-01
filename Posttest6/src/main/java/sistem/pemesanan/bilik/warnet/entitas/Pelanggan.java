package sistem.pemesanan.bilik.warnet.entitas;

public interface Pelanggan {
    int getIdPelanggan();
    void setIdPelanggan(int idPelanggan);
    String getNama();
    void setNama(String nama);
    String getEmail();
    void setEmail(String email);
    String getPassword();
    void setPassword(String password);
    String getNoHp();
    void setNoHp(String noHp);
}