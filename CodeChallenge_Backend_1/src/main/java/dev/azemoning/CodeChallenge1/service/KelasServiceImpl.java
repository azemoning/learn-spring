package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.exception.ResourceNotFoundException;
import dev.azemoning.CodeChallenge1.model.Kelas;
import dev.azemoning.CodeChallenge1.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class KelasServiceImpl implements KelasService {

    @Autowired
    private KelasRepository kelasRepository;

    @Override
    public Iterable<Kelas> getAllKelas(Integer page, Integer size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return kelasRepository.findAll(pageable);
    }

    @Override
    public Iterable<Kelas> searchKelasByName(@RequestParam String name) {
        return kelasRepository.findByNameContaining(name);
    }

    @Override
    public Kelas getKelasById(Long id) {
        return kelasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kelas not found"));
    }

    @Override
    public Kelas addKelas(Kelas kelas) {
        return kelasRepository.save(kelas);
    }

    @Override
    public Kelas updateKelas(Long id, Kelas kelas) {
        Kelas findKelas = kelasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kelas not found"));
        findKelas.setName(kelas.getName());
        return kelasRepository.save(findKelas);
    }

    @Override
    public Kelas deleteKelas(Long id) {
        Kelas kelas = kelasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kelas not found"));
        kelasRepository.delete(kelas);
        return kelas;
    }
}
