package dev.azemoning.HelloSpring.repository;

import dev.azemoning.HelloSpring.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetsRepository extends JpaRepository<Assets, Long> {
}
