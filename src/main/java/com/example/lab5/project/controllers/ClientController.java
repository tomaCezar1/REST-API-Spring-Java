package com.example.lab5.project.controllers;

import com.example.lab5.project.entity.Client;
import com.example.lab5.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping
    public List<Client> getManufacturers() {
        List<Client> clients = clientRepository.getClients();
        return clients;
    }

    @GetMapping("/{id}")
    public Client getManufacturerID(@PathVariable int id, @RequestParam String location) {
        Client client = clientRepository.getClientId(id, location);
        return client;
    }


    @PostMapping("/reqBody")
    public void saveCarBody(@RequestBody Client client) {
        clientRepository.saveClient(client);
    }

    @PutMapping("/put/{id}")
    public void updateManufacturer(@PathVariable int id, @RequestBody Client client) {
        clientRepository.updateClient(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManufacturer(@PathVariable int id) {
        clientRepository.deleteClient(id);
    }

}

