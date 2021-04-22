package dev.azemoning.HelloSpring.service;

import dev.azemoning.HelloSpring.exception.ResourceNotFoundException;
import dev.azemoning.HelloSpring.model.Aset;
import dev.azemoning.HelloSpring.model.Kategori;
import dev.azemoning.HelloSpring.repository.AsetRepository;
import dev.azemoning.HelloSpring.repository.KategoriRepository;
import dev.azemoning.HelloSpring.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsetServiceImpl implements AsetService{

    @Autowired
    private AsetRepository asetRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @Override
    public List<Aset> getAsetList() {
        return asetRepository.findAll();
    }

    @Override
    public Aset getAset(Long id) {
        return asetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aset not found"));
    }

    @Override
    public Aset addAset(Long kategoriId, Aset aset) {
        Kategori findKategori = kategoriRepository.findById(kategoriId)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        aset.setKategori(findKategori);
        return asetRepository.save(aset);
    }

    @Override
    public Aset updateAset(Long kategoriId, Long id, Aset aset) {
        Kategori findKategori = kategoriRepository.findById(kategoriId)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        Aset findAsetById = asetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aset not found"));
        findAsetById.setNama(aset.getNama());
        findAsetById.setQty(aset.getQty());
        findAsetById.setKategori(findKategori);
        return findAsetById;
    }

    @Override
    public Aset deleteAset(Long id) {
        Aset findAsetById = asetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aset not found"));
        asetRepository.delete(findAsetById);
        return findAsetById;
    }

}
