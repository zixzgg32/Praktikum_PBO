package sistem.pemesanan.bilik.warnet.entitas;

import sistem.pemesanan.bilik.warnet.service.BilikService;
import sistem.pemesanan.bilik.warnet.service.JadwalPemakaianService;

public class Owner extends Admin {
    private BilikService bilikService;
    private JadwalPemakaianService jadwalPemakaianService;

    public Owner(int idAdmin, String noHp, String nama, String password, BilikService bilikService, JadwalPemakaianService jadwalPemakaianService) {
        super(idAdmin, noHp, nama, password);
        this.bilikService = bilikService;
        this.jadwalPemakaianService = jadwalPemakaianService;
    }

    public void setTarifBilik(int idBilik, double tarifBaru) {
        Bilik bilik = bilikService.getBilikById(idBilik);
        if (bilik != null) {
            bilik.setHargaPerjam(tarifBaru);
            bilikService.updateBilik(bilik);
            System.out.println("Tarif bilik berhasil diperbarui.");
        } else {
            System.out.println("Bilik tidak ditemukan.");
        }
    }

    public void lihatLaporanKeuangan() {
        double totalPendapatan = jadwalPemakaianService.getAllJadwalPemakaian().stream()
                .filter(jadwal -> jadwal.getStatus().equalsIgnoreCase("Aktif"))
                .mapToDouble(jadwal -> {
                    Bilik bilik = bilikService.getBilikById(jadwal.getIdBilik());
                    if (bilik != null) {
                        long durasiJam = java.time.Duration.between(jadwal.getWaktuMulai(), jadwal.getWaktuSelesai()).toHours();
                        return durasiJam * bilik.getHargaPerjam();
                    }
                    return 0;
                })
                .sum();
        System.out.println("Total Pendapatan Warnet: Rp " + totalPendapatan);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Owner");
    }
}