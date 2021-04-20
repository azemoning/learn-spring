package dev.azemoning.SpringRelationshipDTO.controller;

import dev.azemoning.SpringRelationshipDTO.model.Barang;
import dev.azemoning.SpringRelationshipDTO.service.CrudBarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class BarangController {
    @Autowired
    private CrudBarangService crudBarangService;

    // Cari barang
    @GetMapping("/barang/search")
    public ResponseEntity<Object> searchBarang(@RequestParam String barang) {
        return new ResponseEntity<>(crudBarangService.searchBarang(barang),
                HttpStatus.OK);
    }

    @GetMapping("/barang")
    public ResponseEntity<Object> getAllBarang(@RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "10") Integer size,
                                               @RequestParam(defaultValue = "nama") String sort) {
        return new ResponseEntity<>(crudBarangService.getAllBarang(page, size, sort), HttpStatus.OK);
    }

    @GetMapping("/barang/{id}")
    public ResponseEntity<Object> getDetailBarang(@PathVariable Long id) {
        return new ResponseEntity<>(crudBarangService.getDetailBarang(id), HttpStatus.OK);
    }

    @PostMapping("/barang")
    public ResponseEntity<Object> createBarang(@RequestBody Barang barang, @RequestParam Long kategoriId) {
        return new ResponseEntity<>(crudBarangService.createNewBarang(barang, kategoriId), HttpStatus.CREATED);
    }

    @PutMapping("/barang/{id}")
    public ResponseEntity<Object> updateBarang(@PathVariable Long id, @RequestBody Barang barang) {
        return new ResponseEntity<>(crudBarangService.updateBarang(id, barang), HttpStatus.OK);
    }

    @DeleteMapping("/barang/{id}")
    public ResponseEntity<Object> deleteBarang(@PathVariable Long id) {
        return new ResponseEntity<>(crudBarangService.deleteBarang(id), HttpStatus.OK);
    }
}
