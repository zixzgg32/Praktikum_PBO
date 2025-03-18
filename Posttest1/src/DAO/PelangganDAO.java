package DAO;

import Entitas.Pelanggan;

import java.util.ArrayList;
import java.util.List;

public class PelangganDAO {
    private List<Pelanggan> pelangganList = new ArrayList<>();
    private int currentId = 1;

    public void addPelanggan(Pelanggan pelanggan) {
        pelanggan.setIdPelanggan(currentId++);
        pelangganList.add(pelanggan);
    }

    public List<Pelanggan> getAllPelanggan() {
        return new ArrayList<>(pelangganList);
    }

    public Pelanggan getPelangganById(int id) {
        for (Pelanggan pelanggan : pelangganList) {
            if (pelanggan.getIdPelanggan() == id) {
                return pelanggan;
            }
        }
        return null;
    }

    public Pelanggan getPelangganByEmail(String email) {
        for (Pelanggan pelanggan : pelangganList) {
            if (pelanggan.getEmail().equals(email)) {
                return pelanggan;
            }
        }
        return null;
    }

    public void updatePelanggan(Pelanggan pelanggan) {
        for (int i = 0; i < pelangganList.size(); i++) {
            if (pelangganList.get(i).getIdPelanggan() == pelanggan.getIdPelanggan()) {
                pelangganList.set(i, pelanggan);
                return;
            }
        }
    }

    public void deletePelanggan(int id) {
        pelangganList.removeIf(pelanggan -> pelanggan.getIdPelanggan() == id);
    }
}