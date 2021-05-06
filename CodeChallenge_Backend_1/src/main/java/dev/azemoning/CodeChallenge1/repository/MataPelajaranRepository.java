package dev.azemoning.CodeChallenge1.repository;

import dev.azemoning.CodeChallenge1.model.MataPelajaran;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataPelajaranRepository extends PagingAndSortingRepository<MataPelajaran, Long> {
}
