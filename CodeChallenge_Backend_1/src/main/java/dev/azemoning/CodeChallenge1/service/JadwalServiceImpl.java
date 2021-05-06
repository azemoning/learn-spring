package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.exception.ResourceNotFoundException;
import dev.azemoning.CodeChallenge1.model.Jadwal;
import dev.azemoning.CodeChallenge1.repository.JadwalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JadwalServiceImpl implements JadwalService {
    @Autowired
    private JadwalRepository jadwalRepository;

    @Override
    public Iterable<Jadwal> getAllJadwal() {
        return jadwalRepository.findAll();
    }

    @Override
    public Jadwal getJadwalById(Long id) {
        return jadwalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jadwal not found"));
    }

    @Override
    public Jadwal addJadwal(Jadwal jadwal) {
        return jadwalRepository.save(jadwal);
    }

    @Override
    public Jadwal updateJadwal(Long id, Jadwal jadwal) {
        Jadwal findJadwal = jadwalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jadwal not found"));
        findJadwal.setKelas(jadwal.getKelas());
        findJadwal.setMataPelajaran(jadwal.getMataPelajaran());
        return jadwalRepository.save(findJadwal);
    }

    @Override
    public Jadwal deleteJadwal(Long id) {
        Jadwal jadwal = jadwalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jadwal not found"));
        jadwalRepository.delete(jadwal);
        return jadwal;
    }
}
