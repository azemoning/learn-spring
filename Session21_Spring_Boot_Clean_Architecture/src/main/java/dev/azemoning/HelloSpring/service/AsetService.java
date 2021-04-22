package dev.azemoning.HelloSpring.service;

import dev.azemoning.HelloSpring.model.Aset;

import java.util.List;

public interface AsetService {
    List<Aset> getAsetList();
    Aset getAset(Long id);
    Aset addAset(Long kategoriId, Aset aset);
    Aset updateAset(Long KategoriId, Long id, Aset aset);
    Aset deleteAset(Long id);
}
