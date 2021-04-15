package dev.azemoning.HelloSpring.repository;

import dev.azemoning.HelloSpring.model.Aset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsetRepository extends JpaRepository<Aset, Long> {
}
