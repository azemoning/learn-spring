package dev.azemoning.CodeChallenge1.repository;

import dev.azemoning.CodeChallenge1.model.Kelas;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepository extends PagingAndSortingRepository<Kelas, Long> {
    Iterable<Kelas> findByNameContaining(String name);
}
