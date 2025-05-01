package sistem.pemesanan.bilik.warnet.entitas;

public class Member implements Pelanggan {
    private int idPelanggan;
    private String nama;
    private String email;
    private String password;
    private String noHp;
    private double discountRate;

    public Member(int idPelanggan, String nama, String email, String password, String noHp, double discountRate) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.noHp = noHp;
        this.discountRate = discountRate;
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

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double calculateDiscount(double totalHarga) {
        return totalHarga * (1 - discountRate);
    }

    @Override
    public String toString() {
        return "MemberPelanggan{" +
                "idPelanggan=" + idPelanggan +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", discountRate=" + discountRate +
                '}';
    }
}