package dev.azemoning.CodeChallenge1.controller;

import dev.azemoning.CodeChallenge1.model.Kelas;
import dev.azemoning.CodeChallenge1.service.KelasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class KelasController {

    @Autowired
    private KelasServiceImpl kelasService;

    @GetMapping("kelas")
    public ResponseEntity<Object> getAllKelas(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size,
                                              @RequestParam(defaultValue = "name") String sortBy) {
        return new ResponseEntity<>(kelasService.getAllKelas(page, size, sortBy), HttpStatus.OK);
    }

    @GetMapping("kelas/search")
    public ResponseEntity<Object> searchKelasByName(@RequestParam String name) {
        return new ResponseEntity<>(kelasService.searchKelasByName(name), HttpStatus.OK);
    }

    @GetMapping("kelas/{id}")
    public ResponseEntity<Object> getKelasById(@PathVariable Long id) {
        return new ResponseEntity<>(kelasService.getKelasById(id), HttpStatus.OK);
    }

    @PostMapping("kelas")
    public ResponseEntity<Object> addKelas(@RequestBody Kelas kelas) {
        return new ResponseEntity<>(kelasService.addKelas(kelas), HttpStatus.CREATED);
    }

    @PutMapping("kelas/{id}")
    public ResponseEntity<Object> updateKelas(@PathVariable Long id, @RequestBody Kelas kelas) {
        return new ResponseEntity<>(kelasService.updateKelas(id, kelas), HttpStatus.OK);
    }

    @DeleteMapping("kelas/{id}")
    public ResponseEntity<Object> deleteKelas(@PathVariable Long id) {
        return new ResponseEntity<>(kelasService.deleteKelas(id), HttpStatus.OK);
    }
}
