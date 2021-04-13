package dev.azemoning.HelloSpring.repository;

import dev.azemoning.HelloSpring.model.Guru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuruRepository extends JpaRepository<Guru, Long> {
    @Query("SELECT g FROM Guru g")
    List<Guru> getAllGuru();
}
