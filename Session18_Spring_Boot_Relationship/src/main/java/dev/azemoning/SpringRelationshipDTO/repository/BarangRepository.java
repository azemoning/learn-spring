package dev.azemoning.SpringRelationshipDTO.repository;

import dev.azemoning.SpringRelationshipDTO.model.Barang;
import dev.azemoning.SpringRelationshipDTO.model.Kategori;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepository extends PagingAndSortingRepository<Barang, Long> {
    Iterable<Barang> findByNamaContaining(String barang);
}
