package dev.azemoning.HelloSpring.controller;

import dev.azemoning.HelloSpring.exception.ResourceNotFoundException;
import dev.azemoning.HelloSpring.model.Guru;
import dev.azemoning.HelloSpring.repository.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class GuruController {
    @Autowired
    private GuruRepository guruRepository;

    @GetMapping("/guru")
    public ResponseEntity<Object> getAllGuru() {
        List<Guru> guruList = guruRepository.getAllGuru();
        return new ResponseEntity<>(guruList, HttpStatus.OK);
    }

    @PostMapping("/guru")
    public ResponseEntity<Object> createNewGuru(@RequestBody Guru guru) {
        return new ResponseEntity<>(guruRepository.save(guru), HttpStatus.CREATED);
    }

    @PutMapping("/guru/{id}")
    public ResponseEntity<Object> updateGuru(@PathVariable Long id, @RequestBody Guru guru) {
        Guru findGuru = guruRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guru not found"));
        findGuru.setNama(guru.getNama());
        findGuru.setAlamat(guru.getAlamat());
        findGuru.setUmur(guru.getUmur());
        return new ResponseEntity<>(guruRepository.save(findGuru), HttpStatus.OK);
    }

    @DeleteMapping("/guru/{id}")
    public ResponseEntity<Object> deleteGuru(@PathVariable Long id) {
        Guru findGuru = guruRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guru not found"));
        guruRepository.delete(findGuru);
        return new ResponseEntity<>(findGuru, HttpStatus.OK);
    }
}
