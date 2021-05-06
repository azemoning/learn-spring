package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.exception.ResourceNotFoundException;
import dev.azemoning.CodeChallenge1.model.Kelas;
import dev.azemoning.CodeChallenge1.model.Siswa;
import dev.azemoning.CodeChallenge1.repository.KelasRepository;
import dev.azemoning.CodeChallenge1.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class SiswaServiceImpl implements SiswaService {

    @Autowired
    private SiswaRepository siswaRepository;

    @Autowired
    private KelasRepository kelasRepository;

    @Override
    public Iterable<Siswa> getAllSiswa(Integer page, Integer size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return siswaRepository.findAll(pageable);
    }

    @Override
    public Iterable<Siswa> searchSiswaByName(String name) {
        return siswaRepository.findByNameContaining(name);
    }

    @Override
    public Siswa getSiswaById(Long id) {
        return siswaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Siswa not found"));
    }

    @Override
    public Siswa addSiswa(Long kelasId, Siswa siswa) {
        Kelas kelas = kelasRepository.findById(kelasId)
                .orElseThrow(() -> new ResourceNotFoundException("Kelas not found"));
        siswa.setKelas(kelas);
        return siswaRepository.save(siswa);
    }

    @Override
    public Siswa updateSiswa(Long id, Siswa siswa) {
        Siswa findSiswa = siswaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Siswa not found"));
        findSiswa.setName(siswa.getName());
        findSiswa.setGender(siswa.getGender());
        return siswaRepository.save(findSiswa);
    }

    @Override
    public Siswa deleteSiswa(Long id) {
        Siswa siswa = siswaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Siswa not found"));
        siswaRepository.delete(siswa);
        return siswa;
    }
}
