package dev.azemoning.CodeChallenge1.controller;

import dev.azemoning.CodeChallenge1.model.Jadwal;
import dev.azemoning.CodeChallenge1.service.JadwalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class JadwalController {

    @Autowired
    private JadwalServiceImpl jadwalService;

    @GetMapping("jadwal")
    public ResponseEntity<Object> getAllJadwal() {
        return new ResponseEntity<>(jadwalService.getAllJadwal(), HttpStatus.OK);
    }

    @GetMapping("jadwal/{id}")
    public ResponseEntity<Object> getJadwalById(@PathVariable Long id) {
        return new ResponseEntity<>(jadwalService.getJadwalById(id), HttpStatus.OK);
    }

    @PostMapping("jadwal")
    public ResponseEntity<Object> addJadwal(@RequestBody Jadwal jadwal) {
        return new ResponseEntity<>(jadwalService.addJadwal(jadwal), HttpStatus.CREATED);
    }

    @PutMapping("jadwal/{id}")
    public ResponseEntity<Object> updateJadwal(@PathVariable Long id, @RequestBody Jadwal jadwal) {
        return new ResponseEntity<>(jadwalService.updateJadwal(id, jadwal), HttpStatus.OK);
    }

    @DeleteMapping("jadwal/{id}")
    public ResponseEntity<Object> deleteJadwal(@PathVariable Long id) {
        return new ResponseEntity<>(jadwalService.deleteJadwal(id), HttpStatus.OK);
    }
}
