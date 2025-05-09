package sistem.pemesanan.bilik.warnet.entitas;

public class Admin {
    private int idAdmin;
    private String noHp;
    private String nama;
    private String password;

    public Admin(int idAdmin, String noHp, String nama, String password) {
        this.idAdmin = idAdmin;
        this.noHp = noHp;
        this.nama = nama;
        this.password = password;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String nama, String password) {
        return this.nama.equals(nama) && this.password.equals(password);
    }

    public boolean login(String noHp, String password, boolean usePhone) {
        return this.noHp.equals(noHp) && this.password.equals(password);
    }

    public void displayRole() {
        System.out.println("Role: Admin");
    }
}
