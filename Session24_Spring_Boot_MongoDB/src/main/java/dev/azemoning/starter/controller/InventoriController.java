package dev.azemoning.starter.controller;

import dev.azemoning.starter.model.Inventori;
import dev.azemoning.starter.service.CrudInventoriServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class InventoriController {
    @Autowired
    private CrudInventoriServiceImpl inventoriService;

    @GetMapping("inventori")
    public ResponseEntity<Object> getAllInventori() {
        return new ResponseEntity<>(inventoriService.getAllInventori(), HttpStatus.OK);
    }

    @GetMapping("inventori/{id}")
    public ResponseEntity<Object> getInventoriById(@PathVariable String id) {
        return new ResponseEntity<>(inventoriService.getInventoriById(id), HttpStatus.OK);
    }

    @GetMapping("inventori/search")
    public ResponseEntity<Object> searchInventoriByBarangId(@RequestParam String barangId) {
        return new ResponseEntity<>(inventoriService.searchInventoriByBarangId(barangId), HttpStatus.OK);
    }

    @PostMapping("inventori")
    public ResponseEntity<Object> addInventori(@RequestParam String barangId , @RequestBody Inventori inventori) {
        return new ResponseEntity<>(inventoriService.addInventori(barangId, inventori), HttpStatus.CREATED);
    }

    @PutMapping("inventori/{id}")
    public ResponseEntity<Object> updateInventori(@PathVariable String id, Inventori inventori) {
        return new ResponseEntity<>(inventoriService.updateInventori(id, inventori), HttpStatus.OK);
    }

    @DeleteMapping("inventori/{id}")
    public ResponseEntity<Object> deleteInventori(@PathVariable String id) {
        return new ResponseEntity<>(inventoriService.deleteInventori(id), HttpStatus.OK);
    }
}
