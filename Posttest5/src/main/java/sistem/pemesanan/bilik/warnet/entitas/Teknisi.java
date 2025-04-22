package sistem.pemesanan.bilik.warnet.entitas;

import sistem.pemesanan.bilik.warnet.service.BilikService;

public class Teknisi extends Admin {
    private BilikService bilikService;

    public Teknisi(int idAdmin, String noHp, String nama, String password, BilikService bilikService) {
        super(idAdmin, noHp, nama, password);
        this.bilikService = bilikService;
    }

    public void periksaBilik(int idBilik) {
        Bilik bilik = bilikService.getBilikById(idBilik);
        if (bilik != null) {
            System.out.println("Memeriksa bilik: " + bilik.getNomorBilik());
            System.out.println("Status: " + bilik.getStatus());
        } else {
            System.out.println("Bilik tidak ditemukan.");
        }
    }

    public void perbaikiBilik(int idBilik) {
        Bilik bilik = bilikService.getBilikById(idBilik);
        if (bilik != null && bilik.getStatus().equals("Rusak")) {
            bilik.setStatus("Tersedia");
            bilikService.updateBilik(bilik);
            System.out.println("Bilik berhasil diperbaiki.");
        } else {
            System.out.println("Bilik tidak ditemukan atau tidak dalam status rusak.");
        }
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Teknisi");
    }
}