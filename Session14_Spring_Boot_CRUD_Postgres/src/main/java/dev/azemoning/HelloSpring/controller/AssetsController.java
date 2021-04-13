package dev.azemoning.HelloSpring.controller;

import dev.azemoning.HelloSpring.exception.ResourceNotFoundException;
import dev.azemoning.HelloSpring.model.Assets;
import dev.azemoning.HelloSpring.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class AssetsController {
    @Autowired
    private AssetsRepository assetsRepository;

    @GetMapping("/assets")
    public ResponseEntity<Object> getPaginatedAssets(@RequestParam(defaultValue = "0") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer size,
                                                     @RequestParam(defaultValue = "name") String sort)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Assets> paginatedAssets = assetsRepository.findAll(pageable);
        return new ResponseEntity<>(paginatedAssets, HttpStatus.OK);
    }

    @PostMapping("/assets")
    public ResponseEntity<Object> createNewAsset(@RequestBody Assets assets) {
        return new ResponseEntity<>(assetsRepository.save(assets), HttpStatus.CREATED);
    }

    @PutMapping("/assets/{id}")
    public ResponseEntity<Object> updateAsset(@PathVariable Long id, @RequestBody Assets assets) {
        Assets findAsset = assetsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        findAsset.setName(assets.getName());
        findAsset.setQty(assets.getQty());
        findAsset.setPrice(assets.getPrice());
        return new ResponseEntity<>(assetsRepository.save(findAsset), HttpStatus.OK);
    }

    @DeleteMapping("/assets/{id}")
    public ResponseEntity<Object> deleteAsset(@PathVariable Long id) {
        Assets findAsset = assetsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));
        assetsRepository.delete(findAsset);
        return new ResponseEntity<>(findAsset, HttpStatus.OK);
    }
}
