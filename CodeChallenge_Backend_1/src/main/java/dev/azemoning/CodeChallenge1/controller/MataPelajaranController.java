package dev.azemoning.CodeChallenge1.controller;

import dev.azemoning.CodeChallenge1.model.MataPelajaran;
import dev.azemoning.CodeChallenge1.service.MataPelajaranServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MataPelajaranController {

    @Autowired
    private MataPelajaranServiceImpl mataPelajaranService;

    @GetMapping("mapel")
    public ResponseEntity<Object> getAllMataPelajaran(@RequestParam(defaultValue = "0") Integer page,
                                                      @RequestParam(defaultValue = "10") Integer size,
                                                      @RequestParam(defaultValue = "name") String sortBy) {
        return new ResponseEntity<>(mataPelajaranService.getAllMataPelajaran(page, size, sortBy),
                HttpStatus.OK);
    }

    @GetMapping("mapel/{id}")
    public ResponseEntity<Object> getMataPelajaranById(@PathVariable Long id) {
        return new ResponseEntity<>(mataPelajaranService.getMataPelajaranById(id), HttpStatus.OK);
    }

    @PostMapping("mapel")
    public ResponseEntity<Object> addMataPelajaran(@RequestBody MataPelajaran mataPelajaran) {
        return new ResponseEntity<>(mataPelajaranService.addMataPelajaran(mataPelajaran), HttpStatus.CREATED);
    }

    @PutMapping("mapel/{id}")
    public ResponseEntity<Object> updateMataPelajaran(@PathVariable Long id,
                                                      @RequestBody MataPelajaran mataPelajaran) {
        return new ResponseEntity<>(mataPelajaranService.updateMataPelajaran(id, mataPelajaran), HttpStatus.OK);
    }

    @DeleteMapping("mapel/{id}")
    public ResponseEntity<Object> deleteMataPelajaran(@PathVariable Long id) {
        return new ResponseEntity<>(mataPelajaranService.deleteMataPelajaran(id), HttpStatus.OK);
    }
}
