package dev.azemoning.SpringRelationshipDTO.service;

import dev.azemoning.SpringRelationshipDTO.dto.ListBarangDto;
import dev.azemoning.SpringRelationshipDTO.exception.ResourceNotFoundException;
import dev.azemoning.SpringRelationshipDTO.model.Barang;
import dev.azemoning.SpringRelationshipDTO.model.Kategori;
import dev.azemoning.SpringRelationshipDTO.repository.BarangRepository;
import dev.azemoning.SpringRelationshipDTO.repository.KategoriRepository;
import dev.azemoning.SpringRelationshipDTO.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudBarangService {
    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    // Cari barang
    public Iterable<Barang> searchBarang(String barang) {
        return barangRepository.findByNamaContaining(barang);
    }

    public List<ListBarangDto> getAllBarang(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Iterable<Barang> barangs = barangRepository.findAll(paging);
        List<ListBarangDto> listBarangDtos = new ArrayList<>();
        for(Barang barang: barangs) {
            ListBarangDto listBarangDto = modelMapperUtil.modelMapper().map(barang, ListBarangDto.class);
            listBarangDto.setId(barang.getId());
            listBarangDto.setNama(barang.getNama());
            listBarangDtos.add(listBarangDto);
        }

        return listBarangDtos;
    }

    public Barang createNewBarang(Barang barang, Long kategoriId) {
        Kategori kategori = kategoriRepository.findById(kategoriId)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori not found"));
        barang.setKategori(kategori);
        barangRepository.save(barang);
        return barang;
    }

    public Barang getDetailBarang(Long id) {
        return barangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found"));
    }

    public Barang updateBarang(Long id, Barang barang) {
        Barang findBarangById = barangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found"));
        findBarangById.setNama(barang.getNama());
        findBarangById.setQty(barang.getQty());

        barangRepository.save(findBarangById);
        return findBarangById;
    }

    public Barang deleteBarang(Long id) {
        Barang barang = barangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barang not found"));
        barangRepository.delete(barang);
        return barang;
    }
}


