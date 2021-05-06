package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.model.Siswa;

public interface SiswaService {
    Iterable<Siswa> getAllSiswa(Integer page, Integer size, String sortBy);
    Iterable<Siswa> searchSiswaByName(String name);
    Siswa getSiswaById(Long id);
    Siswa addSiswa(Long kelasId, Siswa siswa);
    Siswa updateSiswa(Long id, Siswa siswa);
    Siswa deleteSiswa(Long id);
}
