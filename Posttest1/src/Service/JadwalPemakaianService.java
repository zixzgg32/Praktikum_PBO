package Service;

import DAO.JadwalPemakaianDAO;
import Entitas.JadwalPemakaian;
import java.util.List;

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