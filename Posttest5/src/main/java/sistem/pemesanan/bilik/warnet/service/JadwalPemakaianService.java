package sistem.pemesanan.bilik.warnet.service;

import java.util.List;

import sistem.pemesanan.bilik.warnet.dao.JadwalPemakaianDAO;
import sistem.pemesanan.bilik.warnet.entitas.JadwalPemakaian;

public class JadwalPemakaianService {
    private JadwalPemakaianDAO jadwalPemakaianDAO;

    public JadwalPemakaianService() {
        jadwalPemakaianDAO = new JadwalPemakaianDAO();
    }

    public void addJadwalPemakaian(JadwalPemakaian jadwal) {
        jadwalPemakaianDAO.addJadwalPemakaian(jadwal);
    }

    public List<JadwalPemakaian> getAllJadwalPemakaian() {
        return jadwalPemakaianDAO.getAllJadwalPemakaian();
    }

    public JadwalPemakaian getJadwalPemakaianById(int id) {
        return jadwalPemakaianDAO.getJadwalPemakaianById(id);
    }

    public void updateJadwalPemakaian(JadwalPemakaian jadwal) {
        jadwalPemakaianDAO.updateJadwalPemakaian(jadwal);
    }

    public void deleteJadwalPemakaian(int id) {
        jadwalPemakaianDAO.deleteJadwalPemakaian(id);
    }
}
