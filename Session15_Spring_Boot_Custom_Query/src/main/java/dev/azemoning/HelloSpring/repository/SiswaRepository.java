package dev.azemoning.HelloSpring.repository;

import dev.azemoning.HelloSpring.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {
    @Query("SELECT s FROM Siswa s")
    List<Siswa> getAllSiswa();
}
