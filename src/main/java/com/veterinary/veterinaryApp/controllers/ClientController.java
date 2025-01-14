package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.ClientDTO;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-veterinary/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public ResponseEntity<?> getAllClients(Authentication authentication) {
        List<ClientDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);

        if (client == null) {
            return new ResponseEntity<>("No client was found.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ClientDTO(client), HttpStatus.OK);
    }

    /*@GetMapping("/current")
    public ResponseEntity<?> getCurrentClient() {

    }*/

}
