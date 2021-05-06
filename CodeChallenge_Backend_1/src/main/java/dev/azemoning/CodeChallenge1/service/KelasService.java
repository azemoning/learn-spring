package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.model.Kelas;

public interface KelasService {
    Iterable<Kelas> getAllKelas(Integer page, Integer size, String sortBy);
    Iterable<Kelas> searchKelasByName(String name);
    Kelas getKelasById(Long id);
    Kelas addKelas(Kelas kelas);
    Kelas updateKelas(Long id, Kelas kelas);
    Kelas deleteKelas(Long id);
}
