package sistem.pemesanan.bilik.warnet.dao;

import java.util.ArrayList;
import java.util.List;

import sistem.pemesanan.bilik.warnet.entitas.JadwalPemakaian;

public class JadwalPemakaianDAO {
    private List<JadwalPemakaian> jadwalList = new ArrayList<>();
    private int currentId = 1;

    public void addJadwalPemakaian(JadwalPemakaian jadwal) {
        jadwal.setIdJadwal(currentId++);
        jadwalList.add(jadwal);
    }

    public List<JadwalPemakaian> getAllJadwalPemakaian() {
        return new ArrayList<>(jadwalList);
    }

    public JadwalPemakaian getJadwalPemakaianById(int id) {
        for (JadwalPemakaian jadwal : jadwalList) {
            if (jadwal.getIdJadwal() == id) {
                return jadwal;
            }
        }
        return null;
    }

    public void updateJadwalPemakaian(JadwalPemakaian jadwal) {
        for (int i = 0; i < jadwalList.size(); i++) {
            if (jadwalList.get(i).getIdJadwal() == jadwal.getIdJadwal()) {
                jadwalList.set(i, jadwal);
                return;
            }
        }
    }

    public void deleteJadwalPemakaian(int id) {
        jadwalList.removeIf(jadwal -> jadwal.getIdJadwal() == id);
    }
}
