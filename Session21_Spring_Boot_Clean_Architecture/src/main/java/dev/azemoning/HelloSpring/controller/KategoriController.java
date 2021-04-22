package dev.azemoning.HelloSpring.controller;

import dev.azemoning.HelloSpring.model.Kategori;
import dev.azemoning.HelloSpring.service.KategoriServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class KategoriController {
    @Autowired
    private KategoriServiceImpl kategoriService;

    @GetMapping("/kategori")
    public ResponseEntity<Object> getAllKategori() {
        return new ResponseEntity<>(kategoriService.getKategoriList(), HttpStatus.OK);
    }

    @GetMapping("/kategori/{id}")
    public ResponseEntity<Object> getKategori(@PathVariable Long id) {
        return new ResponseEntity<>(kategoriService.getKategori(id), HttpStatus.OK);
    }

    @PostMapping("/kategori")
    public ResponseEntity<Object> addKategori(@RequestBody Kategori kategori) {
        return new ResponseEntity<>(kategoriService.addKategori(kategori), HttpStatus.CREATED);
    }

    @PutMapping("/kategori/{id}")
    public ResponseEntity<Object> updateKategori(@PathVariable Long id, @RequestBody Kategori kategori) {
        return new ResponseEntity<>(kategoriService.updateKategori(id, kategori), HttpStatus.OK);
    }

    @DeleteMapping("/kategori/{id}")
    public ResponseEntity<Object> deleteKategori(@PathVariable Long id) {
        return new ResponseEntity<>(kategoriService.deleteKategori(id), HttpStatus.OK);
    }
}
