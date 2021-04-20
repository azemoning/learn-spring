package dev.azemoning.SpringRelationshipDTO.controller;

import dev.azemoning.SpringRelationshipDTO.model.PeminjamanBarang;
import dev.azemoning.SpringRelationshipDTO.service.CrudPeminjamanBarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class PeminjamanBarangController {

    @Autowired
    private CrudPeminjamanBarangService crudPeminjamanBarangService;

    @GetMapping("/barang/peminjaman")
    public ResponseEntity<Object> getAllPeminjaman(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer size,
                                                   @RequestParam(defaultValue = "tanggal_pinjam") String sort) {
        return new ResponseEntity<>(crudPeminjamanBarangService.getAllPeminjamanBarang(page, size, sort),
                HttpStatus.OK);

    }

    @GetMapping("/barang/peminjaman/{id}")
    public ResponseEntity<Object> getDetailPeminjaman(@PathVariable Long id) {
        return new ResponseEntity<>(crudPeminjamanBarangService.getDetailPeminjamanBarang(id),
                HttpStatus.OK);
    }

    @PostMapping("/barang/peminjaman")
    public ResponseEntity<Object> createPeminjaman(@RequestBody PeminjamanBarang peminjamanBarang,
                                                   @RequestParam Long barangId) {
        return new ResponseEntity<>(crudPeminjamanBarangService.createPeminjamanBarang(peminjamanBarang, barangId),
                HttpStatus.CREATED);
    }

    @PutMapping("/barang/peminjaman/{id}")
    public ResponseEntity<Object> updatePeminjaman(@PathVariable Long id,
                                                   @RequestBody PeminjamanBarang peminjamanBarang) {
        return new ResponseEntity<>(crudPeminjamanBarangService.updatePeminjamanBarang(id, peminjamanBarang),
                HttpStatus.OK);
    }

    @DeleteMapping("/barang/peminjaman/{id}")
    public ResponseEntity<Object> deletePeminjaman(@PathVariable Long id) {
        return new ResponseEntity<>(crudPeminjamanBarangService.deletePeminjamanBarang(id), HttpStatus.OK);
    }

}
