package dev.azemoning.HelloSpring.controller;


import dev.azemoning.HelloSpring.exception.ResourceNotFoundException;
import dev.azemoning.HelloSpring.model.Aset;
import dev.azemoning.HelloSpring.model.dto.*;
import dev.azemoning.HelloSpring.repository.AsetRepository;
import dev.azemoning.HelloSpring.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AsetController {
    @Autowired
    private AsetRepository asetRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @GetMapping("/aset")
    public List<ListAsetDto> getListAset() {
        List<Aset> listAset = asetRepository.findAll();
        return mapperAsetToListAsetDto(listAset);
    }

    @GetMapping("/aset/{id}")
    public DetailAsetDto getDetailAset(@PathVariable Long id) {
        return mapperAsetToDetailAsetDto(asetRepository.findById(id));
    }

    @PostMapping("/aset")
    public ResponseEntity<Object> createAset(@RequestBody CreateAsetDto createAsetDto) {
        Aset aset = mapperAsetToCreateAsetDto(createAsetDto);
        return new ResponseEntity<>(aset, HttpStatus.CREATED);
    }

    @PutMapping("/aset/{id}")
    public ResponseEntity<Object> updateAset(@PathVariable Long id,
                                             @RequestBody UpdateAsetDto updateAsetDto) {
        Aset aset = mapperAsetToUpdateAsetDto(id, updateAsetDto);
        return new ResponseEntity<>(aset, HttpStatus.OK);
    }

    @DeleteMapping("/aset/{id}")
    public ResponseEntity<Object> deleteAset(@PathVariable Long id) {
        Aset aset = asetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aset not found"));
        asetRepository.delete(aset);
        return new ResponseEntity<>(aset, HttpStatus.OK);
    }

    private List<ListAsetDto> mapperAsetToListAsetDto(List<Aset> asets) {
        List<ListAsetDto> listAsetDtos = new ArrayList<>();
        for (Aset aset: asets) {
            ListAsetDto listAsetDto = modelMapperUtil.modelMapper().map(aset, ListAsetDto.class);
            listAsetDto.setNama(aset.getNama());
            listAsetDto.setJumlah_aset(aset.getJumlah_aset());
            listAsetDtos.add(listAsetDto);
        }

        return listAsetDtos;
    }

    private DetailAsetDto mapperAsetToDetailAsetDto(Optional<Aset> aset) {
        DetailAsetDto detailAsetDto = modelMapperUtil.modelMapper().map(aset, DetailAsetDto.class);
        aset.ifPresent(value -> {
            detailAsetDto.setNama(value.getNama());
            detailAsetDto.setUmur_aset(value.getUmur_aset());
            detailAsetDto.setJumlah_aset(value.getJumlah_aset());
        });

        return detailAsetDto;
    }

    private Aset mapperAsetToCreateAsetDto(CreateAsetDto createAsetDto) {
        Aset aset = modelMapperUtil.modelMapper().map(createAsetDto, Aset.class);

        aset.setNama(createAsetDto.getNama());
        aset.setUmur_aset(createAsetDto.getUmur_aset());
        aset.setJumlah_aset(createAsetDto.getJumlah_aset());

        asetRepository.save(aset);
        return aset;
    }

    private Aset mapperAsetToUpdateAsetDto(Long id, UpdateAsetDto updateAsetDto) {
        Aset findAsetById = asetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aset not found"));
        Aset aset = modelMapperUtil.modelMapper().map(updateAsetDto, Aset.class);

        aset.setNama(updateAsetDto.getNama());
        aset.setUmur_aset(updateAsetDto.getUmur_aset());
        aset.setJumlah_aset(updateAsetDto.getJumlah_aset());

        findAsetById.setNama(aset.getNama());
        findAsetById.setUmur_aset(aset.getUmur_aset());
        findAsetById.setJumlah_aset(aset.getJumlah_aset());

        asetRepository.save(findAsetById);
        return findAsetById;
    }
}
