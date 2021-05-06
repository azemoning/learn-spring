package dev.azemoning.CodeChallenge1.repository;

import dev.azemoning.CodeChallenge1.model.Siswa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends PagingAndSortingRepository<Siswa, Long> {
    Iterable<Siswa> findByNameContaining(String name);
}
