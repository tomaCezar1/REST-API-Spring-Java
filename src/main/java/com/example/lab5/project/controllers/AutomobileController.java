package com.example.lab5.project.controllers;

import com.example.lab5.project.entity.Automobile;
import com.example.lab5.project.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auto")
public class AutomobileController {

    @Autowired
    private AutomobileRepository automobileRepository;

    @GetMapping
    public List<Automobile> getAutomobiles() {
        List<Automobile> automobiles = automobileRepository.getAutomobiles();
        return automobiles;
    }

    @GetMapping("/auto/{id}")
    public Automobile getCar(@PathVariable long id) {
        Automobile automobile = automobileRepository.getCar(id);
        return automobile;
    }


    @PostMapping("/{country}/{brand}/{price}")
    public void saveCar(@PathVariable String country, @PathVariable String brand, @PathVariable Integer price){
        automobileRepository.saveCar(country, brand, price);
    }

    @PostMapping
    public void saveCar(@RequestParam(name = "country", required = true) String country,
                        @RequestParam(name = "brand", required = false) String brand,
                        @RequestParam(name = "price", required = false) Integer price,
                        @RequestParam(name = "power", required = false) String power){
        automobileRepository.saveCar(country, brand, price, power);
    }

    @PostMapping("/reqBody/")
    public void saveCarBody(@RequestBody Automobile automobile) {
        automobileRepository.saveCarBody(automobile);
    }

    @PutMapping("/put/{id}")
    public void updateCar(@PathVariable long id, @RequestBody Automobile automobile) {
        automobileRepository.updateCar(id, automobile);
    }

    @PatchMapping("/patch/{id}")
    public void updateCarPower(@PathVariable long id, @RequestBody Automobile automobile){
        automobileRepository.updateCarPower(id, automobile);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable long id) {
        automobileRepository.deleteCar(id);
    }
}
