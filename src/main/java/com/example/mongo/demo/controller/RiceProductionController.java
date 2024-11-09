package com.example.mongo.demo.controller;

import com.example.mongo.demo.model.RiceProductionData;
import com.example.mongo.demo.repository.SpringDataRiceProductionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rice-production")
public class RiceProductionController {

    private final SpringDataRiceProductionRepository springDataRiceProductionRepository;

    public RiceProductionController(final SpringDataRiceProductionRepository springDataRiceProductionRepository) {
        this.springDataRiceProductionRepository = springDataRiceProductionRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final RiceProductionData riceProductionData) {
        return ResponseEntity.ok(springDataRiceProductionRepository.save(riceProductionData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final String id, @RequestBody final RiceProductionData riceProductionData) {
        var response = springDataRiceProductionRepository.findById(id);
        if(response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var responseUpdated = RiceProductionData.update(id, riceProductionData);
        return ResponseEntity.ok(springDataRiceProductionRepository.save(responseUpdated));
    }

    @GetMapping
    public ResponseEntity<?> listRiceproduction() {
        return ResponseEntity.ok(springDataRiceProductionRepository.findAll());
    }

    @GetMapping("/area/{countryName}")
    public ResponseEntity<?> findByArea(@PathVariable final String countryName) {
        return ResponseEntity.ok(springDataRiceProductionRepository.findByArea(countryName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final String id) {
        return ResponseEntity.ok(springDataRiceProductionRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable final String id) {
        springDataRiceProductionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}