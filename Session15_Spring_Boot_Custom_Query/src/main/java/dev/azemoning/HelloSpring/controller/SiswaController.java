package dev.azemoning.HelloSpring.controller;


import dev.azemoning.HelloSpring.exception.ResourceNotFoundException;
import dev.azemoning.HelloSpring.model.Siswa;
import dev.azemoning.HelloSpring.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SiswaController {
    @Autowired
    private SiswaRepository siswaRepository;

    @GetMapping("/siswa")
    public ResponseEntity<Object> getAllSiswa() {
        List<Siswa> siswaList = siswaRepository.getAllSiswa();
        return new ResponseEntity<>(siswaList, HttpStatus.OK);
    }

    @PostMapping("/siswa")
    public ResponseEntity<Object> createNewSiswa(@RequestBody Siswa siswa) {
        return new ResponseEntity<>(siswaRepository.save(siswa), HttpStatus.CREATED);
    }

    @PutMapping("/siswa/{id}")
    public ResponseEntity<Object> updateSiswa(@PathVariable Long id, @RequestBody Siswa siswa) {
        Siswa findSiswa = siswaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Siswa not found"));
        findSiswa.setNama(siswa.getNama());
        findSiswa.setAlamat(siswa.getAlamat());
        findSiswa.setUmur(siswa.getUmur());
        return new ResponseEntity<>(siswaRepository.save(findSiswa), HttpStatus.OK);
    }

    @DeleteMapping("/siswa/{id}")
    public ResponseEntity<Object> deleteSiswa(@PathVariable Long id){
        Siswa findSiswa = siswaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Siswa not found"));
        siswaRepository.delete(findSiswa);
        return new ResponseEntity<>(findSiswa, HttpStatus.OK);
    }
}
