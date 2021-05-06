package dev.azemoning.CodeChallenge1.service;

import dev.azemoning.CodeChallenge1.model.Guru;

public interface GuruService {
    Iterable<Guru> getAllGuru(Integer page, Integer size, String sortBy);
    Iterable<Guru> searchGuruByName(String name);
    Guru getGuruById(Long id);
    Guru addGuru(Long kelasId, Guru guru);
    Guru updateGuru(Long id, Guru guru);
    Guru deleteGuru(Long id);
}
