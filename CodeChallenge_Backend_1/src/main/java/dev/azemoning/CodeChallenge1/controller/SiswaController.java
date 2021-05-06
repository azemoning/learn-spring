package dev.azemoning.CodeChallenge1.controller;

import dev.azemoning.CodeChallenge1.model.Siswa;
import dev.azemoning.CodeChallenge1.service.SiswaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class SiswaController {

    @Autowired
    private SiswaServiceImpl siswaService;

    @GetMapping("siswa")
    public ResponseEntity<Object> getAllSiswa(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size,
                                              @RequestParam(defaultValue = "name") String sortBy) {
        return new ResponseEntity<>(siswaService.getAllSiswa(page, size, sortBy), HttpStatus.OK);
    }

    @GetMapping("siswa/search")
    public ResponseEntity<Object> searchSiswaByName(@RequestParam String name) {
        return new ResponseEntity<>(siswaService.searchSiswaByName(name), HttpStatus.OK);
    }

    @GetMapping("siswa/{id}")
    public ResponseEntity<Object> getSiswaById(@PathVariable Long id) {
        return new ResponseEntity<>(siswaService.getSiswaById(id), HttpStatus.OK);
    }

    @PostMapping("siswa")
    public ResponseEntity<Object> addSiswa(@RequestParam Long kelasId, @RequestBody Siswa siswa) {
        return new ResponseEntity<>(siswaService.addSiswa(kelasId, siswa), HttpStatus.CREATED);
    }

    @PutMapping("siswa/{id}")
    public ResponseEntity<Object> updateSiswa(@PathVariable Long id, @RequestBody Siswa siswa) {
        return new ResponseEntity<>(siswaService.updateSiswa(id, siswa), HttpStatus.OK);
    }

    @DeleteMapping("siswa/{id}")
    public ResponseEntity<Object> deleteSiswa(@PathVariable Long id) {
        return new ResponseEntity<>(siswaService.deleteSiswa(id), HttpStatus.OK);
    }
}
