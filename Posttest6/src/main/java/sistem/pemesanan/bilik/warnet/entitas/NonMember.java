package sistem.pemesanan.bilik.warnet.entitas;

public class NonMember implements Pelanggan {
    private int idPelanggan;
    private String nama;
    private String email;
    private String password;
    private String noHp;

    public NonMember(int idPelanggan, String nama, String email, String password, String noHp) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.noHp = noHp;
    }

    @Override
    public int getIdPelanggan() {
        return idPelanggan;
    }

    @Override
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getNoHp() {
        return noHp;
    }

    @Override
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}