package dev.azemoning.starter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoriRepository extends MongoRepository<InventoriRepository, String> {
}
