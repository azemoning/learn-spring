package dev.azemoning.SpringRelationshipDTO.repository;

import dev.azemoning.SpringRelationshipDTO.model.PeminjamanBarang;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeminjamanBarangRepository extends PagingAndSortingRepository<PeminjamanBarang, Long> {
}
