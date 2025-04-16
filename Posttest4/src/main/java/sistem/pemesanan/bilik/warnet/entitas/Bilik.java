package sistem.pemesanan.bilik.warnet.entitas;

public class Bilik {
    private int idBilik;
    private String nomorBilik;
    private String status;
    private String spesifikasiPc;
    private double hargaPerjam;

    public Bilik(int idBilik, String nomorBilik, String status, String spesifikasiPc, double hargaPerjam) {
        this.idBilik = idBilik;
        this.nomorBilik = nomorBilik;
        this.status = status;
        this.spesifikasiPc = spesifikasiPc;
        this.hargaPerjam = hargaPerjam;
    }

    public int getIdBilik() {
        return idBilik;
    }

    public void setIdBilik(int idBilik) {
        this.idBilik = idBilik;
    }

    public String getNomorBilik() {
        return nomorBilik;
    }

    public void setNomorBilik(String nomorBilik) {
        this.nomorBilik = nomorBilik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpesifikasiPc() {
        return spesifikasiPc;
    }

    public void setSpesifikasiPc(String spesifikasiPc) {
        this.spesifikasiPc = spesifikasiPc;
    }

    public double getHargaPerjam() {
        return hargaPerjam;
    }

    public void setHargaPerjam(double hargaPerjam) {
        this.hargaPerjam = hargaPerjam;
    }
}
