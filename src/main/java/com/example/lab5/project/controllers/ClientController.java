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
    public List<Client> getClients() {
        List<Client> clients = clientRepository.getClients();
        return clients;
    }

    @GetMapping("/{id}")
    public Client getClientId(@PathVariable int id, @RequestParam(required = true) String name) {
        Client client = clientRepository.getClientId(id, name);
        return client;
    }


    @PostMapping("/reqBody")
    public void saveClient(@RequestBody Client client) {
        clientRepository.saveClient(client);
    }

    @PutMapping("/put/{id}")
    public void updateClient(@PathVariable int id, @RequestBody Client client) {
        clientRepository.updateClient(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable int id) {
        clientRepository.deleteClient(id);
    }

}

