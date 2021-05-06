package dev.azemoning.CodeChallenge1.controller;

import dev.azemoning.CodeChallenge1.model.Guru;
import dev.azemoning.CodeChallenge1.service.GuruServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class GuruController {

    @Autowired
    private GuruServiceImpl guruService;

    @GetMapping("guru")
    public ResponseEntity<Object> getAllGuru(@RequestParam(defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size,
                                             @RequestParam(defaultValue = "name") String sortBy) {
        return new ResponseEntity<>(guruService.getAllGuru(page, size, sortBy), HttpStatus.OK);
    }

    @GetMapping("guru/search")
    public ResponseEntity<Object> searchGuruByName(@RequestParam String name) {
        return new ResponseEntity<>(guruService.searchGuruByName(name), HttpStatus.OK);
    }

    @GetMapping("guru/{id}")
    public ResponseEntity<Object> getGuruById(@PathVariable Long id) {
        return new ResponseEntity<>(guruService.getGuruById(id), HttpStatus.OK);
    }

    @PostMapping("guru")
    public ResponseEntity<Object> addGuru(@RequestParam Long kelasId, @RequestBody Guru guru) {
        return new ResponseEntity<>(guruService.addGuru(kelasId, guru), HttpStatus.CREATED);
    }

    @PutMapping("guru/{id}")
    public ResponseEntity<Object> updateGuru(@PathVariable Long id, Guru guru) {
        return new ResponseEntity<>(guruService.updateGuru(id, guru), HttpStatus.OK);
    }

    @DeleteMapping("guru/{id}")
    public ResponseEntity<Object> deleteGuru(@PathVariable Long id) {
        return new ResponseEntity<>(guruService.deleteGuru(id), HttpStatus.OK);
    }
}
