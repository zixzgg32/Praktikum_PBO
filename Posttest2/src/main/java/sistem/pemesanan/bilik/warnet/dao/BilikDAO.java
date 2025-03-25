package sistem.pemesanan.bilik.warnet.dao;

import java.util.ArrayList;
import java.util.List;

import sistem.pemesanan.bilik.warnet.entitas.Bilik;

public class BilikDAO {
    private List<Bilik> bilikList = new ArrayList<>();
    private int currentId = 1;

    public void addBilik(Bilik bilik) {
        bilik.setIdBilik(currentId++);
        bilikList.add(bilik);
    }

    public List<Bilik> getAllBilik() {
        return new ArrayList<>(bilikList);
    }

    public Bilik getBilikById(int id) {
        for (Bilik bilik : bilikList) {
            if (bilik.getIdBilik() == id) {
                return bilik;
            }
        }
        return null;
    }

    public void updateBilik(Bilik bilik) {
        for (int i = 0; i < bilikList.size(); i++) {
            if (bilikList.get(i).getIdBilik() == bilik.getIdBilik()) {
                bilikList.set(i, bilik);
                return;
            }
        }
    }

    public void deleteBilik(int id) {
        bilikList.removeIf(bilik -> bilik.getIdBilik() == id);
    }
}
