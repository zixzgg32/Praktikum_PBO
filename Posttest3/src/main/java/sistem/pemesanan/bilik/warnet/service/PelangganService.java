package sistem.pemesanan.bilik.warnet.service;

import java.util.List;

import sistem.pemesanan.bilik.warnet.dao.PelangganDAO;
import sistem.pemesanan.bilik.warnet.entitas.Pelanggan;

public class PelangganService {
    private PelangganDAO pelangganDAO;

    public PelangganService() {
        pelangganDAO = new PelangganDAO();
    }

    public void registerPelanggan(Pelanggan pelanggan) {
        pelangganDAO.addPelanggan(pelanggan);
    }

    public Pelanggan loginPelanggan(String email, String password) {
        Pelanggan pelanggan = pelangganDAO.getPelangganByEmail(email);
        if (pelanggan != null && pelanggan.getPassword().equals(password)) {
            return pelanggan;
        }
        return null;
    }

    public List<Pelanggan> getAllPelanggan() {
        return pelangganDAO.getAllPelanggan();
    }

    public Pelanggan getPelangganById(int id) {
        return pelangganDAO.getPelangganById(id);
    }

    public void updatePelanggan(Pelanggan pelanggan) {
        pelangganDAO.updatePelanggan(pelanggan);
    }

    public void deletePelanggan(int id) {
        pelangganDAO.deletePelanggan(id);
    }
}
