package sistem.pemesanan.bilik.warnet.entitas;

import java.util.List;

import sistem.pemesanan.bilik.warnet.service.BilikService;
import sistem.pemesanan.bilik.warnet.service.JadwalPemakaianService;

public class Operator extends Admin {
    private BilikService bilikService;
    private JadwalPemakaianService jadwalPemakaianService;

    public Operator(int idAdmin, String noHp, String nama, String password, BilikService bilikService, JadwalPemakaianService jadwalPemakaianService) {
        super(idAdmin, noHp, nama, password);
        this.bilikService = bilikService;
        this.jadwalPemakaianService = jadwalPemakaianService;
    }

    public void lihatBilik() {
        List<Bilik> bilikList = bilikService.getAllBilik();
        for (Bilik bilik : bilikList) {
            System.out.println("ID: " + bilik.getIdBilik() + ", Nomor: " + bilik.getNomorBilik() + ", Status: " + bilik.getStatus());
        }
    }

    public void tambahBilik(Bilik bilik) {
        bilikService.addBilik(bilik);
        System.out.println("Bilik berhasil ditambahkan.");
    }

    public void ubahBilik(Bilik bilik) {
        bilikService.updateBilik(bilik);
        System.out.println("Bilik berhasil diubah.");
    }

    public void hapusBilik(int idBilik) {
        bilikService.deleteBilik(idBilik);
        System.out.println("Bilik berhasil dihapus.");
    }

    public void lihatPesanan() {
        List<JadwalPemakaian> jadwalList = jadwalPemakaianService.getAllJadwalPemakaian();
        for (JadwalPemakaian jadwal : jadwalList) {
            System.out.println("ID Jadwal: " + jadwal.getIdJadwal() + ", ID Bilik: " + jadwal.getIdBilik() + ", Status: " + jadwal.getStatus());
        }
    }

    public void hapusPesanan(int idJadwal) {
        jadwalPemakaianService.deleteJadwalPemakaian(idJadwal);
        System.out.println("Pesanan berhasil dihapus.");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Operator");
    }
}