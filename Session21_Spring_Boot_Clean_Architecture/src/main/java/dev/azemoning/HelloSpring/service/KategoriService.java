package dev.azemoning.HelloSpring.service;

import dev.azemoning.HelloSpring.model.Kategori;

import java.util.List;

public interface KategoriService {
    List<Kategori> getKategoriList();
    Kategori getKategori(Long id);
    Kategori addKategori(Kategori kategori);
    Kategori updateKategori(Long id, Kategori kategori);
    Kategori deleteKategori(Long id);
}
