package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Long> {

}
