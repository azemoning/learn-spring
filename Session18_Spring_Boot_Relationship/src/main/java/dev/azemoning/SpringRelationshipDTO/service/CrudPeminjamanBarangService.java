package dev.azemoning.SpringRelationshipDTO.service;

import dev.azemoning.SpringRelationshipDTO.exception.ResourceNotFoundException;
import dev.azemoning.SpringRelationshipDTO.model.Barang;
import dev.azemoning.SpringRelationshipDTO.model.PeminjamanBarang;
import dev.azemoning.SpringRelationshipDTO.repository.BarangRepository;
import dev.azemoning.SpringRelationshipDTO.repository.PeminjamanBarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudPeminjamanBarangService {
    @Autowired
    private PeminjamanBarangRepository peminjamanBarangRepository;

    @Autowired
    private BarangRepository barangRepository;

    public List<PeminjamanBarang> getAllPeminjamanBarang(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Iterable<PeminjamanBarang> peminjamanBarang = peminjamanBarangRepository.findAll(paging);
        List<PeminjamanBarang> peminjamanBarangList = new ArrayList<>();
        for (PeminjamanBarang data: peminjamanBarang) {
            peminjamanBarangList.add(data);
        }

        return peminjamanBarangList;
    }

    public PeminjamanBarang getDetailPeminjamanBarang(Long id) {
        return peminjamanBarangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
    }

    public PeminjamanBarang createPeminjamanBarang(PeminjamanBarang peminjamanBarang, Long barangId) {
        Barang barang = barangRepository.findById(barangId)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found"));
        peminjamanBarang.setBarang(barang);
        return peminjamanBarangRepository.save(peminjamanBarang);
    }

    public PeminjamanBarang updatePeminjamanBarang(Long id, PeminjamanBarang peminjamanBarang) {
        PeminjamanBarang findPeminjamanBarangById = peminjamanBarangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        findPeminjamanBarangById.setTanggal_pinjam(peminjamanBarang.getTanggal_pinjam());
        findPeminjamanBarangById.setTanggal_pulang(peminjamanBarang.getTanggal_pulang());
        peminjamanBarangRepository.save(findPeminjamanBarangById);

        return findPeminjamanBarangById;
    }

    public PeminjamanBarang deletePeminjamanBarang(Long id) {
        PeminjamanBarang peminjamanBarang = peminjamanBarangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        peminjamanBarangRepository.delete(peminjamanBarang);
        return peminjamanBarang;
    }
}
