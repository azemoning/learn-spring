package dev.azemoning.SpringRelationshipDTO.service;

import dev.azemoning.SpringRelationshipDTO.exception.ResourceNotFoundException;
import dev.azemoning.SpringRelationshipDTO.model.Barang;
import dev.azemoning.SpringRelationshipDTO.model.Kategori;
import dev.azemoning.SpringRelationshipDTO.repository.KategoriRepository;
import dev.azemoning.SpringRelationshipDTO.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudKategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;

    public List<Kategori> getAllKategori() {
        return kategoriRepository.findAll();
    }

    public Kategori getDetailKategori(Long id) {
        return kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
    }

    public Kategori createNewKategori(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    public Kategori updateKategori(Long id, Kategori kategori) {
        Kategori findKategoriById = kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        findKategoriById.setNama(kategori.getNama());
        kategoriRepository.save(findKategoriById);
        return findKategoriById;
    }

    public Kategori deleteKategori(Long id) {
        Kategori kategori = kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        kategoriRepository.delete(kategori);
        return kategori;
    }
}
