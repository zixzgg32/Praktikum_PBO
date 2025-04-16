package sistem.pemesanan.bilik.warnet.entitas;

public class MemberPelanggan extends Pelanggan {
    private double discountRate;

    public MemberPelanggan(int idPelanggan, String nama, String email, String password, String noHp, double discountRate) {
        super(idPelanggan, nama, email, password, noHp);
        this.discountRate = discountRate;
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
        return super.toString() + ", Discount Rate: " + (discountRate * 100) + "%";
    }
}