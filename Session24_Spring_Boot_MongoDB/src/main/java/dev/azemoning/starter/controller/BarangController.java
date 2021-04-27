package dev.azemoning.starter.controller;

import dev.azemoning.starter.model.Barang;
import dev.azemoning.starter.service.CrudBarangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class BarangController {
    @Autowired
    private CrudBarangServiceImpl barangService;

    @GetMapping("barang")
    public ResponseEntity<Object> getAllBarang() {
        return new ResponseEntity<>(barangService.getAllBarang(), HttpStatus.OK);
    }

    @GetMapping("barang/{id}")
    public ResponseEntity<Object> getBarangById(@PathVariable String id) {
        return new ResponseEntity<>(barangService.getBarangById(id), HttpStatus.OK);
    }

    @GetMapping("barang/search")
    public ResponseEntity<Object> getBarangByName(@RequestParam String name) {
        return new ResponseEntity<>(barangService.searchBarangByName(name), HttpStatus.OK);
    }

    @PostMapping("barang")
    public ResponseEntity<Object> addBarang(@RequestBody Barang barang) {
        return new ResponseEntity<>(barangService.addBarang(barang), HttpStatus.CREATED);
    }

    @PutMapping("barang/{id}")
    public ResponseEntity<Object> updateBarang(@PathVariable String id, @RequestBody Barang barang) {
        return new ResponseEntity<>(barangService.updateBarang(id, barang), HttpStatus.OK);
    }

    @DeleteMapping("barang/{id}")
    public ResponseEntity<Object> deleteBarang(@PathVariable String id) {
        return new ResponseEntity<>(barangService.deleteBarang(id), HttpStatus.OK);
    }
}
