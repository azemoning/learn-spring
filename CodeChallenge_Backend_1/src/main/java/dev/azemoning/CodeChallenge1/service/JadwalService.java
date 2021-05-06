package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.model.Jadwal;

public interface JadwalService {
    Iterable<Jadwal> getAllJadwal();
    Jadwal getJadwalById(Long id);
    Jadwal addJadwal(Jadwal jadwal);
    Jadwal updateJadwal(Long id, Jadwal jadwal);
    Jadwal deleteJadwal(Long id);
}
