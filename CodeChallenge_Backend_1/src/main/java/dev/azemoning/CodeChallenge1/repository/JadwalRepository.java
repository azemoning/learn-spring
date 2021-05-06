package dev.azemoning.CodeChallenge1.repository;

import dev.azemoning.CodeChallenge1.model.Jadwal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalRepository extends JpaRepository<Jadwal, Long> {
}
