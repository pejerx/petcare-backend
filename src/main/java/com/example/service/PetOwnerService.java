package com.example.service;

import com.example.model.PetOwner;
import com.example.repository.PetOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerService {
    private final PetOwnerRepository repository;

    public PetOwnerService(PetOwnerRepository repository) {
        this.repository = repository;
    }

    public PetOwner create(PetOwner petOwner) {
        return repository.save(petOwner);
    }

    public List<PetOwner> getAll() {
        return repository.findAll();
    }

    public Optional<PetOwner> getById(Long id) {
        return repository.findById(id);
    }

    public PetOwner update(Long id, PetOwner petOwner) {
        petOwner.setId(id);
        return repository.save(petOwner);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
} 