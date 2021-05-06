package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.exception.ResourceNotFoundException;
import dev.azemoning.CodeChallenge1.model.MataPelajaran;
import dev.azemoning.CodeChallenge1.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class MataPelajaranServiceImpl implements MataPelajaranService {

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    @Override
    public Iterable<MataPelajaran> getAllMataPelajaran(Integer page, Integer size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size , Sort.by(sortBy));
        return mataPelajaranRepository.findAll(pageable);
    }

    @Override
    public MataPelajaran getMataPelajaranById(Long id) {
        return mataPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mata pelajaran not found"));
    }

    @Override
    public MataPelajaran addMataPelajaran(MataPelajaran mataPelajaran) {
        return mataPelajaranRepository.save(mataPelajaran);
    }

    @Override
    public MataPelajaran updateMataPelajaran(Long id, MataPelajaran mataPelajaran) {
        MataPelajaran findMataPelajaran = mataPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mata pelajaran not found"));
        findMataPelajaran.setName(mataPelajaran.getName());
        return mataPelajaranRepository.save(findMataPelajaran);
    }

    @Override
    public MataPelajaran deleteMataPelajaran(Long id) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mata pelajaran not found"));
        mataPelajaranRepository.delete(mataPelajaran);
        return mataPelajaran;
    }
}
