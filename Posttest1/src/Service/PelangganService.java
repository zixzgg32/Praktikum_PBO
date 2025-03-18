package Service;

import DAO.PelangganDAO;
import Entitas.Pelanggan;

import java.util.List;

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