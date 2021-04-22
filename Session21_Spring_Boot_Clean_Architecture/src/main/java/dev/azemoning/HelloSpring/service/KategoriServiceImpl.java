package dev.azemoning.HelloSpring.service;

import dev.azemoning.HelloSpring.exception.ResourceNotFoundException;
import dev.azemoning.HelloSpring.model.Kategori;
import dev.azemoning.HelloSpring.repository.KategoriRepository;
import dev.azemoning.HelloSpring.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriServiceImpl implements KategoriService{

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @Override
    public List<Kategori> getKategoriList() {
        return kategoriRepository.findAll();
    }

    @Override
    public Kategori getKategori(Long id) {
        return kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
    }

    @Override
    public Kategori addKategori(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    @Override
    public Kategori updateKategori(Long id, Kategori kategori) {
        Kategori findKategori = kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        findKategori.setNama(kategori.getNama());
        return kategoriRepository.save(findKategori);
    }

    @Override
    public Kategori deleteKategori(Long id) {
        Kategori findKategori = kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        kategoriRepository.delete(findKategori);
        return findKategori;
    }
}
