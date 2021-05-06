package dev.azemoning.HelloSpring.controller;

import dev.azemoning.HelloSpring.model.Aset;
import dev.azemoning.HelloSpring.model.Kategori;
import dev.azemoning.HelloSpring.service.AsetServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Aset", value = "Aset Resource Operation")
public class AsetController {
    @Autowired
    private AsetServiceImpl asetService;

    @GetMapping("/aset")
    @ApiOperation(value = "Get All Asets")
    public ResponseEntity<Object> getAllAset() {
        return new ResponseEntity<>(asetService.getAsetList(), HttpStatus.OK);
    }

    @GetMapping("/aset/{id}")
    public ResponseEntity<Object> getAsetById(@PathVariable Long id) {
        return new ResponseEntity<>(asetService.getAset(id), HttpStatus.OK);
    }

    @PostMapping("/aset")
    public ResponseEntity<Object> addAset(@RequestParam Long kategoriId, @RequestBody Aset aset) {
        return new ResponseEntity<>(asetService.addAset(kategoriId, aset), HttpStatus.CREATED);
    }

    @PutMapping("/aset/{id}")
    public ResponseEntity<Object> updateAset(@RequestParam Long kategoriId,
                                             @PathVariable Long id,
                                             @RequestBody Aset aset) {
        return new ResponseEntity<>(asetService.updateAset(kategoriId, id, aset), HttpStatus.OK);
    }

    @DeleteMapping("/aset/{id}")
    public ResponseEntity<Object> deleteAset(@PathVariable Long id) {
        return new ResponseEntity<>(asetService.deleteAset(id), HttpStatus.OK);
    }
}
