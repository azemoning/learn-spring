package dev.azemoning.starter.controller;

import dev.azemoning.starter.model.StokBarang;
import dev.azemoning.starter.service.CrudStokBarangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class StokBarangController {

    @Autowired
    private CrudStokBarangServiceImpl stokBarangService;

    @GetMapping("stok")
    public ResponseEntity<Object> getAllStokBarang() {
        return new ResponseEntity<>(stokBarangService.getAllStokBarang(), HttpStatus.OK);
    }

    @GetMapping("stok/{id}")
    public ResponseEntity<Object> getStokBarangById(@PathVariable String id) {
        return new ResponseEntity<>(stokBarangService.getStokBarangById(id), HttpStatus.OK);
    }

    @GetMapping("stok/search")
    public ResponseEntity<Object> searchStokBarangByBarangId(@RequestParam String barangId) {
        return new ResponseEntity<>(stokBarangService.searchStokBarangByBarangId(barangId), HttpStatus.OK);
    }

    @PostMapping("stok")
    public ResponseEntity<Object> addStokBarang(@RequestParam String barangId, @RequestBody StokBarang stokBarang) {
        return new ResponseEntity<>(stokBarangService.addStokBarang(barangId, stokBarang), HttpStatus.CREATED);
    }

    @PutMapping("stok/{id}")
    public ResponseEntity<Object> updateStokBarang(@PathVariable String id, StokBarang stokBarang) {
        return new ResponseEntity<>(stokBarangService.updateStokBarang(id, stokBarang), HttpStatus.OK);
    }

    @DeleteMapping("stok/{id}")
    public ResponseEntity<Object> deleteStokBarang(@PathVariable String id) {
        return new ResponseEntity<>(stokBarangService.deleteStokBarang(id), HttpStatus.OK);
    }
}
