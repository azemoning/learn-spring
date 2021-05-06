package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.model.MataPelajaran;

public interface MataPelajaranService {
    Iterable<MataPelajaran> getAllMataPelajaran(Integer page, Integer size, String sortBy);
    MataPelajaran getMataPelajaranById(Long id);
    MataPelajaran addMataPelajaran(MataPelajaran mataPelajaran);
    MataPelajaran updateMataPelajaran(Long id, MataPelajaran mataPelajaran);
    MataPelajaran deleteMataPelajaran(Long id);
}
