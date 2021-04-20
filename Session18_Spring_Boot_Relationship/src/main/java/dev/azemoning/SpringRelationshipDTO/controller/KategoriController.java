package dev.azemoning.SpringRelationshipDTO.controller;

import dev.azemoning.SpringRelationshipDTO.model.Kategori;
import dev.azemoning.SpringRelationshipDTO.service.CrudKategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class KategoriController {
    @Autowired
    private CrudKategoriService crudKategoriService;

    @GetMapping("/kategori")
    public ResponseEntity<Object> getAllKategori() {
        return new ResponseEntity<>(crudKategoriService.getAllKategori(), HttpStatus.OK);
    }

    @GetMapping("/kategori/{id}")
    public ResponseEntity<Object> getKategoriById(@PathVariable Long id) {
        return new ResponseEntity<>(crudKategoriService.getDetailKategori(id), HttpStatus.OK);
    }

    @PostMapping("/kategori")
    public ResponseEntity<Object> createKategori(@RequestBody Kategori kategori) {
        return new ResponseEntity<>(crudKategoriService.createNewKategori(kategori), HttpStatus.CREATED);
    }

    @PutMapping("/kategori/{id}")
    public ResponseEntity<Object> updateKategori(@PathVariable Long id, @RequestBody Kategori kategori) {
        return new ResponseEntity<>(crudKategoriService.updateKategori(id, kategori), HttpStatus.OK);
    }

    @DeleteMapping("/kategori/{id}")
    public ResponseEntity<Object> deleteKategori(@PathVariable Long id) {
        return new ResponseEntity<>(crudKategoriService.deleteKategori(id), HttpStatus.OK);
    }
}
