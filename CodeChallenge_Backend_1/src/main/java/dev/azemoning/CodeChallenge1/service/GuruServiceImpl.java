package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.exception.ResourceNotFoundException;
import dev.azemoning.CodeChallenge1.model.Guru;
import dev.azemoning.CodeChallenge1.model.Kelas;
import dev.azemoning.CodeChallenge1.repository.GuruRepository;
import dev.azemoning.CodeChallenge1.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruRepository guruRepository;

    @Autowired
    private KelasRepository kelasRepository;

    @Override
    public Iterable<Guru> getAllGuru(Integer page, Integer size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return guruRepository.findAll(pageable);
    }

    @Override
    public Iterable<Guru> searchGuruByName(String name) {
        return guruRepository.findByNameContaining(name);
    }

    @Override
    public Guru getGuruById(Long id) {
        return guruRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guru not found"));
    }

    @Override
    public Guru addGuru(Long kelasId, Guru guru) {
        Kelas kelas = kelasRepository.findById(kelasId)
                .orElseThrow(() -> new ResourceNotFoundException("Kelas not found"));
        guru.setKelas(kelas);
        return guruRepository.save(guru);
    }

    @Override
    public Guru updateGuru(Long id, Guru guru) {
        Guru findGuru = guruRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guru not found"));
        findGuru.setName(guru.getName());
        findGuru.setGender(guru.getGender());
        return guruRepository.save(findGuru);
    }

    @Override
    public Guru deleteGuru(Long id) {
        Guru guru = guruRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guru not found"));
        guruRepository.delete(guru);
        return guru;
    }
}
