package com.example.lab5.project.controllers;

import com.example.lab5.project.entity.Manufacturer;
import com.example.lab5.project.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;



    @GetMapping
    public List<Manufacturer> getManufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.getManufacturers();
        return manufacturers;
    }

    @GetMapping("/{id}")
    public Manufacturer getManufacturerID(@PathVariable int id, @RequestParam String location) {
        Manufacturer manufacturer = manufacturerRepository.getManufacturerID(id, location);
        return manufacturer;
    }


    @PostMapping("/reqBody")
    public void saveCarBody(@RequestBody Manufacturer manufacturer) {
        manufacturerRepository.saveManufacturer(manufacturer);
    }

    @PutMapping("/put/{id}")
    public void updateManufacturer(@PathVariable int id, @RequestBody Manufacturer manufacturer) {
        manufacturerRepository.updateManufacturer(id, manufacturer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManufacturer(@PathVariable int id) {
        manufacturerRepository.deleteManufacturer(id);
    }

}

