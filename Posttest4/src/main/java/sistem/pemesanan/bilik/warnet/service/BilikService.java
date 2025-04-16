package sistem.pemesanan.bilik.warnet.service;

import java.util.List;

import sistem.pemesanan.bilik.warnet.dao.BilikDAO;
import sistem.pemesanan.bilik.warnet.entitas.Bilik;

public class BilikService {
    private BilikDAO bilikDAO;

    public BilikService() {
        bilikDAO = new BilikDAO();
    }

    public void addBilik(Bilik bilik) {
        bilikDAO.addBilik(bilik);
    }

    public List<Bilik> getAllBilik() {
        return bilikDAO.getAllBilik();
    }

    public Bilik getBilikById(int id) {
        return bilikDAO.getBilikById(id);
    }

    public void updateBilik(Bilik bilik) {
        bilikDAO.updateBilik(bilik);
    }

    public void deleteBilik(int id) {
        bilikDAO.deleteBilik(id);
    }
}
