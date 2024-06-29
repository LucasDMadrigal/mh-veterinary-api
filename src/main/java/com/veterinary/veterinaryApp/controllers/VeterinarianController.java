package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.VeterinarianDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.DeleteVeterinarianDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.NewVeterinarianDTO;
import com.veterinary.veterinaryApp.models.Veterinarian;
import com.veterinary.veterinaryApp.services.VeterinarianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-veterinarian/veterinarians")
public class VeterinarianController {

  @Autowired
  private VeterinarianService veterinarianService;
  
  @GetMapping("/")
  public ResponseEntity<?> getAllVeterinarians(Authentication authentication) {
    if (!authentication.isAuthenticated()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }
    List<VeterinarianDTO> veterinariansDTO = veterinarianService.getAllVeterinariansDTO();
    return new ResponseEntity<>(veterinariansDTO, HttpStatus.OK);
  }

  @PostMapping("/new")
  public ResponseEntity<?> createVeterinarian(@RequestBody NewVeterinarianDTO newVeterinarianDTO) {

    if (newVeterinarianDTO.name().isBlank()) {
      return new ResponseEntity<>("phone must not be empty ", HttpStatus.BAD_REQUEST);
    }

    if (newVeterinarianDTO.specialty().isBlank()) {
      return new ResponseEntity<>("specialty must not be empty ", HttpStatus.BAD_REQUEST);
    }

    if (newVeterinarianDTO.address().isBlank()) {
      return new ResponseEntity<>("address must not be empty ", HttpStatus.BAD_REQUEST);
    }

    if (newVeterinarianDTO.phone().isBlank()) {
      return new ResponseEntity<>("phone must not be empty ", HttpStatus.BAD_REQUEST);
    }

    if (newVeterinarianDTO.email().isBlank()) {
      return new ResponseEntity<>("email must not be empty ", HttpStatus.BAD_REQUEST);
    }

    Veterinarian newVeterinarian = veterinarianService.createVeterinarian(newVeterinarianDTO);

    veterinarianService.saveVeterinarian(newVeterinarian);

    return new ResponseEntity<>(newVeterinarian, HttpStatus.CREATED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<?> deleteVeterinarian(@RequestBody DeleteVeterinarianDTO deleteVeterinarianDTO) {
    
    long vetId = deleteVeterinarianDTO.id();
    
    Veterinarian veterinarian = veterinarianService.getVeterinarianById(vetId);
    
    if (veterinarian == null) {
      return new ResponseEntity<>("Veterinarian not found", HttpStatus.NOT_FOUND);
    }
    
    veterinarianService.deleteVeterinarian(veterinarian);
    
    return new ResponseEntity<>(veterinarian.getName() + " was deleted successfully", HttpStatus.OK);
  }
}
