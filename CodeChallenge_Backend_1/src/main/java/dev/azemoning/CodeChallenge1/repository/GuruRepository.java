package dev.azemoning.CodeChallenge1.repository;

import dev.azemoning.CodeChallenge1.model.Guru;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepository extends PagingAndSortingRepository<Guru, Long> {
    Iterable<Guru> findByNameContaining(String name);
}
