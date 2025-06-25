package com.example.controller;

import com.example.model.PetOwner;
import com.example.service.PetOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petowners")
@CrossOrigin(origins = "*")
public class PetOwnerController {

    private final PetOwnerService service;

    public PetOwnerController(PetOwnerService service) {
        this.service = service;
    }

    @PostMapping
    public PetOwner create(@RequestBody PetOwner petOwner) {
        return service.create(petOwner);
    }

    @GetMapping
    public List<PetOwner> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetOwner> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public PetOwner update(@PathVariable Long id, @RequestBody PetOwner petOwner) {
        return service.update(id, petOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
} 