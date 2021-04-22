package dev.azemoning.HelloSpring.repository;

import dev.azemoning.HelloSpring.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {
}
