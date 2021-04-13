package dev.azemoning.HelloSpring.repository;

import dev.azemoning.HelloSpring.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, Long> {
    Optional<Assets> findBy(String search);
}
